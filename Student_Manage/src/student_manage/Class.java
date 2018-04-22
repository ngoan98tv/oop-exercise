/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_manage;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ngoan_Tran
 */
public class Class implements Serializable {
    
    private String subject;
    private String class_id;
    private Teacher  teacher;
    private int credits;
    private ArrayList<Student> student;
    
    public Class(String subject, String id, Teacher teacher, int credits){
        this.subject = subject;
        this.class_id = id;
        this.teacher = teacher;
        this.credits = credits;
        this.student = new ArrayList<Student>();
    }
    
    public Class(Class cls) {
        this.subject = cls.subject;
        this.class_id = cls.class_id;
        this.teacher = cls.teacher;
        this.credits = cls.credits;
        this.student = new ArrayList<Student>();
    }
    
    public void updateTeacher(Teacher newTeacher){
        this.teacher = newTeacher;
    }
    
    public String getSubject(){
        return this.subject;
    }
    
    public String getClassID(){
        return this.class_id;
    }
    
    public Teacher getTeacher(){
        return this.teacher;
    }
    
    public int getCredits(){
        return this.credits;
    }
    
    public int getNumberOfStudents(){
        return this.student.size();
    }
    
    public void addStudent(Student std){
        this.student.add(std);
    }
    
    public void deleteStudent(Student std){
        this.student.remove(std);
    }
    
    public void listStudents(){
        System.out.println(this.student.toString());
    }
    
    public void displayInfo(){
        String format = "%-5s \t| %-20s \t| %-20s \t | %-8s \t | %-30s\n";
        System.out.format(format,this.class_id,this.subject,this.teacher.getName(),this.credits,this.getNumberOfStudents());
    }
}
