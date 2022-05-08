/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageTrees;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author javie_c2zwkpq
 */
public class Node {
    int CourseCod;
    String Description;
    Boolean Highlevel;
    Node Left;
    Node Rigth;
    //int id

    public Node(int CourseCod, String Description, Boolean Highlevel) {
        this.CourseCod = CourseCod;
        this.Description = Description;
        this.Highlevel = Highlevel;
    }

    public Node getLeft() {
        return Left;
    }

    public void setLeft(Node Left) {
        this.Left = Left;
    }

    public Node getRigth() {
        return Rigth;
    }

    public void setRigth(Node Rigth) {
        this.Rigth = Rigth;
    }
    
     public int valorNodo(){
        return CourseCod;
    }
    
    void Check(){
        System.out.println(CourseCod + ", " + Description + ", " +  Highlevel);   
    }
    
    
      public void graficar() {
        FileWriter fichero = null;
        PrintWriter escritor;
        try
        {
            fichero = new FileWriter("aux_grafico.txt");
            escritor = new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz());
        } 
        catch (Exception e){
            System.err.println("Error al escribir el archivo aux_grafico.dot");
        }finally{
           try {
                if (fichero!=null)
                    fichero.close();
                    ProcessBuilder proceso;
                    proceso=new ProcessBuilder("dot","-Tpng","-o","C:\\Users\\alumno\\Documents\\NetBeansProjects\\AVLGraphviz\\arbol_texto.png","C:\\Users\\alumno\\Documents\\NetBeansProjects\\AVLGraphviz\\aux_grafico.txt");
                    proceso.redirectErrorStream(true);
                    proceso.start();
                
           }catch (Exception e2){
               System.err.println("Error al cerrar el archivo aux_grafico.dot");
           } 
        }              
        
        
        
        
        
      try{
           System.out.println("holaaaaaaaaaaaaaaaaa");
          Runtime rt = Runtime.getRuntime();
            System.out.println("holaaaaaaaaaaaaaaaaa");
          rt.exec("dot -Tjpg -o arbol_texto.png aux_grafico.txt");
          //Esperamos medio segundo para dar tiempo a que la imagen se genere.
          //Para que no sucedan errores en caso de que se decidan graficar varios
          //árboles sucesivamente.
          //Thread.sleep(500);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }           
    }
    /**
     * Método que retorna el código que grapviz usará para generar la imagen 
     * del árbol binario de búsqueda.
     * @return 
     */
    private String getCodigoGraphviz() {
        return "digraph grafica{\n" +
               "rankdir=TB;\n" +
               "node [shape = record, style=filled, fillcolor=seashell2];\n"+
                getCodigoInterno()+
                "}\n";
    }
    /**
     * Genera el código interior de graphviz, este método tiene la particularidad 
     * de ser recursivo, esto porque recorrer un árbol de forma recursiva es bastante 
     * sencillo y reduce el código considerablemente. 
     * @return 
     */
    private String getCodigoInterno() {
        String etiqueta;    
        if(Left==null && Rigth==null){
            etiqueta="nodo"+CourseCod+" [ label =\""+CourseCod+"\"];\n";
        }else{
            etiqueta="nodo"+CourseCod+" [ label =\"<C0>|"+CourseCod+"|<C1>\"];\n";
        }
        if(Left!=null){
            etiqueta=etiqueta + Left.getCodigoInterno() +
               "nodo"+CourseCod+":C0->nodo"+Left.CourseCod+"\n";
        }
        if(Rigth!=null){
            etiqueta=etiqueta + Rigth.getCodigoInterno() +
               "nodo"+CourseCod+":C1->nodo"+Rigth.CourseCod+"\n";                    
        }
        return etiqueta;
    }        
    
    
}




