package PackageTrees;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author javie_c2zwkpq
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("DATOS DE ESTUDIANTE");
        try {
            System.out.println("=========================");
            System.out.println("5190-19-7011, Victor Javier Castillo Garcia, Seccion: 'D' ");
            System.out.println("" + InetAddress.getLocalHost());
            System.out.println("=========================");
            
        } catch (UnknownHostException ex) {
            System.out.println("Mensaje del error: " + ex.getMessage());
            
     }

        
        Binarytree BTree = new Binarytree();
        
        try{
            BTree.insertar(65, "Uso del manejador de bases de datos ACCESS", false);
            BTree.insertar(80, "Introducción al diseño de bases de datos", false);
            BTree.insertar(81, "Creación de páginas web con HTML", true);
            BTree.insertar(51, "Introducción a HTML5", false);
            BTree.insertar(23, "Lenguaje de programación PHP", true);
            BTree.insertar(71, "Hoja de cálculo EXCEL", false);
            BTree.insertar(72, "Macros con EXCEL", true);
            BTree.insertar(53, "Programación con Java Principiante", false);
            BTree.insertar(38, "Programación con Java Intermedio", false);
            BTree.insertar(35, "Programación con Java Avanzado", true);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        
        
        BTree.graficar();
        System.out.println("\nRecodido por Preorden");
        BTree.Preorden(BTree.raiz);
        
        BTree.EliminarNode(65);
        
        BTree.graficar();
        System.out.println("\nRecodido por Inorden");
        BTree.Inorden(BTree.raiz);
    }
    
}
