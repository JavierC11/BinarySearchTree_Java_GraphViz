/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageTrees;

/**
 *
 * @author javie_c2zwkpq
 */
public class Binarytree {
    protected Node raiz;
    
    
     public void insertar(int coursecode, String description, Boolean highlevel) throws Exception{
        raiz = insertar(raiz, coursecode, description, highlevel);
    }
    
    public Node insertar(Node raizSub, int coursecode, String description, Boolean highlevel) throws Exception {
        if(raizSub == null){
            raizSub = new Node(coursecode, description, highlevel);
        }else if(coursecode<raizSub.valorNodo()) {
            Node iz;
            iz = insertar(raizSub.getLeft(), coursecode, description, highlevel);
            raizSub.setLeft(iz);
        }else if (coursecode > raizSub.valorNodo()){
          Node dr;
          dr = insertar(raizSub.getRigth(), coursecode, description, highlevel);
          raizSub.setRigth(dr);
        }else {
            throw new Exception("Nodo Duplicado");
        }
        return raizSub;
    }
    
    
    public void Inorden(Node r){
        if(r!=null){
        Inorden(r.getLeft());
        r.Check();
        Inorden(r.getRigth());
        }
    }
    
    
    public void Preorden(Node r){           
        if(r!=null){
        r.Check();
        Inorden(r.getLeft());
        Inorden(r.getRigth());
        }
    }
    
    public void Postorden(Node r){
        if(r!=null){
        Inorden(r.getLeft());
        Inorden(r.getRigth());
        r.Check();
        }
    }
    
    
    public boolean EliminarNode(int d){
        Node auxiliar = raiz;
        Node padre = raiz;
        boolean isleft = true;
        while(auxiliar.CourseCod!=d){
            padre= auxiliar;
            if(d<auxiliar.CourseCod){
                isleft = true;
                auxiliar = auxiliar.Left;            
            }else{
                isleft = false;
                auxiliar = auxiliar.Rigth;
            }
            if(auxiliar==null){
                return false;
            }
        } //fin del while
        
        if(auxiliar.Left==null && auxiliar.Rigth==null){
            if(auxiliar == raiz){
                raiz=null;
            }else if(isleft){
                padre.Left=null;
            }else{
                padre.Rigth=null;
            }
        }else if(auxiliar.Rigth==null){
            if(auxiliar == raiz){
                raiz=auxiliar.Left;
            }else if(isleft){
                padre.Left=auxiliar.Left;
            }else{
                padre.Rigth=auxiliar.Left;
            }
        }else if(auxiliar.Left == null){
            if(auxiliar == raiz){
                raiz=auxiliar.Rigth;
            }else if(isleft){ 
                padre.Left=auxiliar.Rigth;
            }else{
                padre.Rigth=auxiliar.Left;
            }
        }else{
            Node reemplazo = obtenerNodoRemp(auxiliar);
            if(auxiliar==raiz){
                raiz= reemplazo;
            }else if(isleft){
                padre.Left=reemplazo;
            }else{
                padre.Rigth=reemplazo;
            }
            reemplazo.Left= auxiliar.Left;
        }
        return true;
    } 
    
    //Metodo para buscar el reemplazo para borrar
    public Node obtenerNodoRemp(Node nodoRemp){
        Node remplazarpadre = nodoRemp;
        Node reemplazo = nodoRemp;
        Node auxiliar = nodoRemp.Left;
        
        while(auxiliar!=null){
            remplazarpadre= reemplazo;
            reemplazo=auxiliar;
            auxiliar=auxiliar.Left;
        }
        if(reemplazo!=nodoRemp.Rigth){
            remplazarpadre.Left = reemplazo.Rigth;
            reemplazo.Rigth=nodoRemp.Rigth;
        }
        System.out.println("El Nodo Reemplazo es "+reemplazo);
        return reemplazo;
    }
    
    
}
