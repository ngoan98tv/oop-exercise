/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_manage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nguyen_Nhat_Quang
 */
public class Student implements Serializable {

    String student_id;
    String student_name;
    Date birth_date;
    String major;
    String email;
    int course;
    ArrayList<Class> cls = new ArrayList<>();

    public Student() {
        this.grade = new HashMap<>();
        this.student_id = null;
        this.student_name = null;
        this.birth_date = null;
        this.major = null;
        this.course = 0;
    }

    public Student(String student_id, String student_name, Date birth_date, String major, int course) {
        this.grade = new HashMap<>();
        this.student_id = student_id;
        this.student_name = student_name;
        this.birth_date = birth_date;
        this.major = major;
        this.course = course;
        this.email = this.createStudentEmail();
    }
    public String getStudentID() 
    {
        return this.student_id;
    }

    public String getFullName() {
        return this.student_name;
    }

    public String getLastName() {
        return this.student_name.substring(0, this.student_name.indexOf(' ') - 1);
    }

    public String getFirstName() {
        return this.student_name.substring(this.student_name.lastIndexOf(' ') + 1);
    }

    public Date getBirthDate() {
        return this.birth_date;
    }

    public String getMajor() {
        return this.major;
    }

    public String getEmail() {
        return this.email;
    }

    public int getNumberOfClass() {
        return this.cls.size();
    }

    public String createStudentEmail() {
        return this.getFirstName().toLowerCase() + this.student_id.toLowerCase() + "@student.ctu.edu.vn";
    }

    public boolean changeStudentID(String student_id) {
        String temp = this.student_id;
        this.student_id = student_id;
        if (this.isStudentIDValid()) {
            return true;
        } else {
            this.student_id = temp;
            return false;
        }
    }

    public void changeName(String student_name) {
        this.student_name = student_name;
    }

    public boolean changeBirthDate(Date birth_date) {
        if (birth_date.isValid()) {
            this.birth_date = birth_date;
            return true;
        } else {
            return false;
        }
    }

    public void changeMajor(String major) {
        this.major = major;
    }

    public boolean changeCourse(int course) {
        if (course > 0) {
            this.course = course;
            return true;
        } else {
            return false;
        }
    }

    public boolean isStudentIDValid(String student_id) {
        if (student_id.charAt(0) == 'B' && student_id.charAt(0) == 'b' && student_id.length() == 8) {
            return true;
        } else {
            return false;
        }
    }

    public void displayBasicInfo() {
        String format = "%-8s \t| %-20s \t| %-6s \t | %-10s \t | \t %30s | %-30s\n";
        System.out.format(format,this.student_id,this.student_name,this.course,this.birth_date.toString(),this.email,this.major);
    }
    
    public void addClass(Class cls) {
        cls.addStudent(this);
        this.cls.add(cls);
    }

    public void deleteClass(Class cls) {
        cls.deleteStudent(this);
        this.cls.remove(cls);
    }
}
