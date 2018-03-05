/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi1_bai8;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Ngoan Tran
 */
public class Buoi1_Bai8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] list;
        list = getArrInt();
        
        int x;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer x: ");
        x = sc.nextInt();
        
        System.out.println("There are " +  count(x, list) + " numbers " + x + " in the list.");
        
        printSorted(list);
        
    }
    
    private static int[] getArrInt(){
        int n;
        String[] tmp;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter list of integer numbers (split by single spaces): ");
        tmp = sc.nextLine().trim().split(" ");
        
        int[] re;
        re = new int[tmp.length];
        
        for (int i=0; i<tmp.length; i++){
            re[i] = Integer.parseInt(tmp[i]);
        }
        
        return re;
    }
    
    private static int count(int x, int[] arr){
        int tmp = 0;
        
        for (int i : arr){
            if (i == x)
                tmp++;
        }
        
        return tmp;
    }
    
    private static void printSorted(int[] arr){
        
        Arrays.sort(arr);
        
        System.out.println("Sorted list: " + Arrays.toString(arr));
        
    }
}
