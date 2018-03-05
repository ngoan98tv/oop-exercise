/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Ngoan Tran
 */
public class Student {
    int mark;
    String name;
    
    public Student(String n, int m){
        mark = m;
        name = n;
    }

    Student() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setMark(int m){
        mark = m;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public int getMark(){
        return mark;
    }
    
    public String getName(){
        return name;
    }
}
