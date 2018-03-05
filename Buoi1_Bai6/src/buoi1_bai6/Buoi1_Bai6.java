/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi1_bai6;

import java.util.Scanner;

/**
 *
 * @author Ngoan Tran
 */
public class Buoi1_Bai6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int n;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        n = sc.nextInt();
        
        if (isPrime(n))
            System.out.println(n + " is a prime number");
        else
            System.out.println(n + " is not a prime number");
        
        System.out.println("Binary of " + n + " = " + getBinary(n));
        
    }
    
    private static boolean isPrime(int a){
        
        for (int i = 2; i <= a/2; i++){
            if (a % i == 0)
                return false;
        }
        
        return true;
    }
    
    private static String getBinary(int a){
        String tmp = "";
        
        while (a > 0){
            tmp = a%2 + tmp;
            a = a/2;
        }
        
        return tmp;
    }
}
