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

    Map<String, Student> studentList = new HashMap<>();
    Map<String, Class> classList = new HashMap<>();
    Map<String, Teacher> teacherList = new HashMap<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Student_Manage manage = new Student_Manage();

        manage.readFromFile();

        manage.chooseAction();

        manage.saveToFile();
    }

    //display a menu to take an action
    public void chooseAction() {
        int choice = 111;
        Scanner sc = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("_____________Student Management_____________");
            System.out.println(
                    " 1\tView list of available Students\n"
                    + " 2\tView list of available Teachers\n"
                    + " 3\tView list of available Classes\n"
                    + " 4\tView list of Students in a Class\n"
                    + " 5\tView list of Classes of a Teacher\n"
                    + " 6\tView list of Classes of a Student\n"
                    + " 7\tAdd a new student\n"
                    + " 8\tAdd a new teacher\n"
                    + " 9\tAdd a new class (0 student)\n"
                    + "10\tAdd students to a class\n"
                    + "11\tDelete a teacher (all classes of the teacher will loose)\n"
                    + "12\tDelete a student\n"
                    + "13\tDelete a class\n"
                    + " 0\tExit"
            );

            System.out.print("Choose an action: ");
            choice = sc.nextInt();

            switch (choice) {
                case 0: //Exit
                    break;
                case 1:
                    this.viewStudent();
                    break;
                case 2:
                    this.viewTeacher();
                    break;
                case 3:
                    this.viewClass();
                    break;
                case 4:
                    System.out.print("Enter Class ID: "); sc.nextLine();
                    this.viewStudent(classList.get(sc.nextLine()));
                    break;
                case 5:
                    System.out.print("Enter Teacher ID: "); sc.nextLine();
                    this.viewClass(teacherList.get(sc.nextLine()));
                    break;
                case 6:
                    System.out.print("Enter Student ID: "); sc.nextLine();
                    this.viewClass(studentList.get(sc.nextLine()));
                    break;
                case 7:
                    this.enterStudent();
                    break;
                case 8:
                    this.enterTeacher();
                    break;
                case 9:
                    this.enterClass();
                    break;
                case 10:
                    System.out.print("Enter Class ID: "); sc.nextLine();
                    this.addStudents(classList.get(sc.nextLine()));
                    break;
                case 11:
                    System.out.print("Enter Teacher ID: "); sc.nextLine();
                    this.deleteTeacher(teacherList.get(sc.nextLine()));
                    break;
                case 12:
                    System.out.print("Enter Student ID: "); sc.nextLine();
                    this.deleteStudent(studentList.get(sc.nextLine()));
                    break;
                case 13:
                    System.out.print("Enter Class ID: "); sc.nextLine();
                    this.deleteClass(classList.get(sc.nextLine()));
                    break;
                default:
                    System.out.println("Input is invalid, please try again!");
            }
            if (choice != 0) {
                System.out.print("Press 1 to continue or 0 to exit. ");
                choice = sc.nextInt();
            }
        }
    }

    //enter a teacher from keyboard
    public void enterTeacher() {

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

        teacher = new Teacher(code, name, email);

        this.teacherList.put(code, teacher);
    }

    //enter a student from keyboard
    public void enterStudent() {
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
        birth_date = new Date(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]));
        System.out.print("Major: ");
        major = sc.nextLine();
        System.out.print("Course: ");
        course = sc.nextInt();

        student = new Student(id, name, birth_date, major, course);

        this.studentList.put(id, student);
    }

    //enter a class from keyboard
    public void enterClass() {
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
        this.classList.put(id, cls);
    }

    //view list of available teachers
    public void viewTeacher() {
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("                                           Teachers                                           ");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.format("%-8s \t| %-20s \t| \t %30s | %-30s\n", "ID", "Name", "Email", "Classes");
        this.teacherList.keySet().forEach((key) -> {
            this.teacherList.get(key).displayInfo();
        });
        System.out.println("______________________________________________________________________________________________");
    }

    //view list of available students
    public void viewStudent() {
        String format = "%-8s \t| %-20s \t| %-6s \t | %-10s \t | \t %30s | %-30s\n";
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                      Students                                                 ");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.format(format, "ID", "Name", "Course", "Birthday", "Email", "Major");
        this.studentList.keySet().forEach((key) -> {
            this.studentList.get(key).displayBasicInfo();
        });
        System.out.println("_______________________________________________________________________________________________________________");
    }

    //view list of available classes
    public void viewClass() {
        String format = "%-5s \t| %-20s \t| %-20s \t | %-8s \t | %-30s\n";
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("                                          Classes                                              ");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.format(format, "ID", "Subject", "Teacher", "Credits", "Numbers of students");
        this.classList.keySet().forEach((key) -> {
            this.classList.get(key).displayInfo();
        });
        System.out.println("______________________________________________________________________________________________");
    }

    //view list of students in the Class cls
    public void viewStudent(Class cls) {
        String format = "%-8s \t| %-20s \t| %-6s \t | %-10s \t | \t %30s | %-30s\n";
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("                                  Students in " + cls.getClassID() + "                                         ");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.format(format, "ID", "Name", "Course", "Birthday", "Email", "Major");
        cls.student.forEach((std) -> {
            System.out.format(format, std.student_id, std.student_name, std.course, std.birth_date.toString(), std.email, std.major);
        });
        System.out.println("_______________________________________________________________________________________________________________");
    }

    //View list of classes of the teacher
    public void viewClass(Teacher teacher) {
        String format = "%-5s \t| %-20s \t| %-8s \t | %-30s\n";
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("                               Classes of " + teacher.getCode() + "                              ");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.format(format, "ID", "Subject", "Credits", "Numbers of students");
        teacher.cls.forEach((clss) -> {
            System.out.format(format, clss.getClassID(), clss.getSubject(), clss.getCredits(), clss.getNumberOfStudents());
        });
        System.out.println("______________________________________________________________________________________________");
    }
    
     //View list of classes of the student
    public void viewClass(Student std) {
        String format = "%-5s \t| %-20s \t| %-8s \t | %-30s\n";
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("                               Classes of " + std.getStudentID() + "                              ");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.format(format, "ID", "Subject", "Credits", "Numbers of students");
        std.classList.forEach((clss) -> {
            System.out.format(format, clss.getClassID(), clss.getSubject(), clss.getCredits(), clss.getNumberOfStudents());
        });
        System.out.println("______________________________________________________________________________________________");
    }
    
    //Add students into a class
    public void addStudents(Class cls){
        String[] stds;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter students id: ");
        stds = sc.nextLine().split(" ");
        for(String std:stds){
            cls.addStudent(studentList.get(std));
            this.studentList.get(std).classList.add(cls);
        }
    }
    
    //Delete teacher
    public void deleteTeacher(Teacher teacher){
        for (Class cls : teacher.cls){
            this.classList.remove(cls.getClassID());
        }
        this.teacherList.remove(teacher.getCode());
    }
    
    //Delete student
    public void deleteStudent(Student std){
        std.classList.forEach(cls -> {
            cls.deleteStudent(std);
        });
        this.studentList.remove(std.getStudentID());
    }
    
    //Delete class
    public void deleteClass(Class cls){
        cls.student.forEach(std -> {
            std.deleteClass(cls);
        });
        cls.getTeacher().deleteClass(cls);
        this.classList.remove(cls.getClassID());
    }

    public void saveToFile() throws FileNotFoundException, IOException {

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

    public void readFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("data.txt");
        ObjectInputStream data = new ObjectInputStream(file);

        this.teacherList = (Map<String, Teacher>) data.readObject();
        this.classList = (Map<String, Class>) data.readObject();
        this.studentList = (Map<String, Student>) data.readObject();

        data.close();
    }

}
