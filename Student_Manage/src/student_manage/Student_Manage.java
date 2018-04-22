/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_manage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Ngoan_Tran
 */
public class Student_Manage {

    Map<String,Student> studentList = new HashMap<>();
    Map<String,Class> classList = new HashMap<>();
    Map<String,Teacher> teacherList = new HashMap<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Student_Manage manage = new Student_Manage();
        
        manage.enterTeacher();
        manage.enterClass();
        manage.enterStudent();
        
        
        //manage.readFromFile();
        
        manage.viewTeacher();
        manage.viewClass();
        manage.viewStudent();
        
        manage.saveToFile();
    }
    
    //enter a teacher from keyboard
    public void enterTeacher(){
        
        Scanner sc = new Scanner(System.in);
        Teacher teacher;
        String code;
        String name;
        String email;
        
        System.out.println("Enter a new teacher");
        System.out.print("Code: ");
        code = sc.nextLine();
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Email: ");
        email = sc.nextLine();
        
        teacher = new Teacher(code,name,email);
        
        this.teacherList.put(code,teacher);
    }
    
    //enter a student from keyboard
    public void enterStudent(){
        Scanner sc = new Scanner(System.in);
        String id;
        String name;
        Date birth_date;
        String major;
        int course; 
        Student student;
        
        System.out.println("Enter a new student");
        
        System.out.print("ID: ");
        id = sc.nextLine();
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Birth day (dd/mm/yyyy): ");
        String[] tmp = sc.nextLine().split("/");
        birth_date = new Date(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]));
        System.out.print("Major: ");
        major = sc.nextLine();
        System.out.print("Course: ");
        course = sc.nextInt();
        
        student = new Student(id, name, birth_date, major, course);
        
        this.studentList.put(id,student);
    }
    
    //enter a class from keyboard
    public void enterClass(){
        Scanner sc = new Scanner(System.in);
        Class cls;
        String subject;
        String id;
        Teacher teacher;
        int credits;
        
        System.out.println("Enter a new class");
        System.out.print("Subject: ");
        subject = sc.nextLine();
        System.out.print("Id: ");
        id = sc.nextLine();
        System.out.print("Teacher id: ");
        teacher = this.teacherList.get(sc.nextLine());
        System.out.print("Credits: ");
        credits = sc.nextInt();
        
        cls = new Class(subject, id, teacher, credits);
        teacher.addClass(cls);
        this.classList.put(id,cls);
    }
    
    //view list of available teachers
    public void viewTeacher(){
        this.teacherList.keySet().forEach((key) -> {
            System.out.println("_____________________________________________");
            this.teacherList.get(key).displayInfo();
        });
    }
    
    //view list of available students
    public void viewStudent(){
        this.studentList.keySet().forEach((key) -> {
            System.out.println("_____________________________________________");
            this.studentList.get(key).displayBasicInfo();
        });
    }
    
    //view list of available classes
    public void viewClass(){
       this.classList.keySet().forEach((key) -> {
            System.out.println("_____________________________________________");
            this.classList.get(key).displayInfo();
        });
    }
    
    public void saveToFile() throws FileNotFoundException, IOException{
        /*
        FileOutputStream stdOut = new FileOutputStream("student.txt");
        ObjectOutputStream studentFile = new ObjectOutputStream(stdOut);
        FileOutputStream tchrOut = new FileOutputStream("teacher.txt");
        ObjectOutputStream teacherFile = new ObjectOutputStream(tchrOut);
        FileOutputStream clssOut = new FileOutputStream("class.txt");
        ObjectOutputStream classFile = new ObjectOutputStream(clssOut);
        */
        try {
            FileOutputStream file = new FileOutputStream("data.txt");
            ObjectOutputStream data = new ObjectOutputStream(file);

            data.writeObject(this.teacherList);
            data.writeObject(this.classList);
            data.writeObject(this.studentList);
            data.flush();

            data.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void readFromFile() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream file = new FileInputStream("data.txt");
        ObjectInputStream data = new ObjectInputStream(file);
        
        this.teacherList = (Map<String, Teacher>) data.readObject();
        this.classList = (Map<String, Class>) data.readObject();
        this.studentList = (Map<String, Student>) data.readObject();
        
        data.close();
        file.close();
    }
    
}
