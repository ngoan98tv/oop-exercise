/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.util.Scanner;

/**
 *
 * @author Ngoan Tran
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    int n;
    int arr[];
    
    public void getN(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of Fibonacci series: ");
        n = sc.nextInt();
        arr = new int[n];
    }
    
    public void setArr(){
        arr[0] = 1;
        arr[1] = 1;
        for (int i=2; i<n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
    }
    
    public void show(){
        System.out.print("Fibonacci series: ");
        for (int i=0; i<n-1; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[n-1]);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Fibonacci fibo = new Fibonacci();
        fibo.getN();
        fibo.setArr();
        fibo.show();
        
    }
    
}
