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
public class Node {
    int CourseCod;
    String Description;
    Boolean Highlevel;
    Node Left;
    Node Rigth;

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
    
    
}




