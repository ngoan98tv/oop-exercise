/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi1_bai5;

/**
 *
 * @author Ngoan Tran
 */
public class Buoi1_Bai5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        solveFirstOrderEquation(3, 6);
        
        solveSecondOrderEquation(2, 3, 1);
        
    }
    
    private static void solveFirstOrderEquation(float a, float b){
       System.out.println(a + "x" + " + " + b + " = 0");
       if (a == 0){
           if (b == 0)
               System.out.println("Always true.");
           else
               System.out.println("There is not solution.");
       } else {
           System.out.println("x = " + (-b/a));
       }
    }
    
    private static void solveSecondOrderEquation(float a, float b, float c){
        System.out.println(a + "x^2" + " + " + b + "x" + " + " + c + " = 0");
        
        float delta = b*b - 4*a*c;
        
        if (delta > 0){
            System.out.println("x1 = " + (-b + Math.sqrt(delta))/(2*a));
            System.out.println("x2 = " + (-b - Math.sqrt(delta))/(2*a));
        } else if (delta == 0){
            System.out.println("x1 = x2 = " + (-b/(2*a)));
        } else {
            System.out.println("There is not solution.");
        }
    }
}
