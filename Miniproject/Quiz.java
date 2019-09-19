/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

/**
 *
 * @author Rishi
 */


abstract class Detail{
    private String username;
    private String passwd;
    private double points;
    private int age;
    
    Detail(String username,String password,int age)
    {
        this.username=username;
        this.passwd=password;
        this.age=age;
        this.points=0;
    }
    
    
}





public class Quiz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
