/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi1_bai7;

import java.util.Scanner;

/**
 *
 * @author Ngoan Tran
 */
public class Buoi1_Bai7 {

    /**
     * @param args the command line arguments
     */
    
    static String string;
    static String[] arr;
        
    public static void main(String[] args) {
        readFullName();
        splitName();
        showName();
    }
    
    private static void splitName(){
        
        arr = string.trim().split(" ");
        
    }
    
    private static void readFullName(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter your full name: ");
        string = sc.nextLine();
    }
    
    private static void showName(){
        //System.out.println("Your first name is: " + arr[0]);
        System.out.println("Your name is: " + arr[arr.length - 1]);
    }
    
}
