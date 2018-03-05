/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi1_bai4;

import java.util.Scanner;

/**
 *
 * @author Ngoan Tran
 */
public class Buoi1_Bai4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int a, b;
        
        a = getInteger();
        b = getInteger();
        
        System.out.println(a + " + " + b + " = " + (a+b));
    }
    
    private static int getInteger(){
        Integer a = null;
        Scanner sc;
        sc = new Scanner(System.in);
        
        while (a == null){
        try {
            System.out.print("Enter an integer number: ");
            a = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ERROR " + e.getMessage() + " is not integer!");
        }}
        return a;
    }

}
