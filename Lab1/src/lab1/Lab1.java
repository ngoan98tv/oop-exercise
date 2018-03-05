/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


/**
 *
 * @author Ngoan Tran
 */
public class Lab1 {
    
    Student students[];
    int n;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Lab1 l = new Lab1();
        l.getList();
           
        l.sortList();
        l.display();
    }

    
    public void getList(){
        int mark; String name;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of list: ");
        n = Integer.parseInt(sc.nextLine());
        
        students = new Student[n];
        
        for (int i=0; i<n; i++){
            System.out.print("Enter name " + i + ": ");
            name = sc.nextLine();
            System.out.print("Enter marks " + i + ": ");
            mark = Integer.parseInt(sc.nextLine());
            students[i] = new Student(name,mark);
        }
        
    }
    
    public void sortList(){
        
        Student tmp1 = null, tmp2 = null;
                
        for (int i=0; i<n; i++)
            for (int j=i; j<n; j++){
                if (students[i].getName().compareTo(students[j].getName()) > 0)
                    tmp1 = students[i];
                    tmp2 = students[j];
                    students[j] = tmp1;
            }
    }
    
    public void delStudent(String name){
        
    }
    
    public void display(){
        System.out.println("---------------students----------------");
        for (Student i : students){
            System.out.println(i.getName() + "     " + i.getMark());
        }
        System.out.println("---------------end-list----------------");
    }
    
}
