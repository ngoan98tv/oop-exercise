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
 * @author Ly_Linh_Kiet
 * 
 * @reviser Ngoan_Tran
 * 
 */
public class Teacher implements Serializable{

    private String code;
    private String name;
    private String email;
    private ArrayList<Class> cls;      //ben class Class

    public Teacher() {
        this.code = new String();
        this.name = new String();
        this.email = new String();
        this.cls = new ArrayList<Class>();
    }

    public Teacher(String code, String name, String email) {
        this.code = code;
        this.name = name;
        this.email = email;
        this.cls = new ArrayList<Class>();
    }

    public Teacher(Teacher T) {
        this.code = T.getCode();
        this.name = T.getName();
        this.email = T.getEmail();
        this.cls = new ArrayList<Class>();
    }

    public String getCode() {			//tra ve ma so giao vien
        return this.code;
    }

    public String getName() {			//tra ve ten giao vien
        return this.name;
    }

    public String getEmail() {			//tra ve email giao vien
        return this.email;
    }

    public void displayInfo() {			//hien thong tin giao vien ra man hinh
        System.out.println("Teacher's code: " + this.code);
        System.out.println("Teacher's name: " + this.name);
        System.out.println("Teacher's email: " + this.email);
        System.out.print("Teacher classes: ");
        for (int i = 0; i < cls.size(); i++) {		//in tung ID lop ma giao vien do day
            System.out.print(cls.get(i).getClassID() + ", "); 			//(lay ra phan tu thu i).(phuong thuc lay IDclass)
        }
        System.out.println();
    }

    public void addClass(Class cls) {
        this.cls.add(cls);
    }

    public void deleteClass(Class cls) {
        this.cls.remove(cls);
    }
}
