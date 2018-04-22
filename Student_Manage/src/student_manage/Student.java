/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nguyen_Nhat_Quang
 */
public class Student {

    String student_id;
    String student_name;
    Date birth_date;
    String major;
    String email;
    int course;
    ArrayList<Class> cls = new ArrayList<>();
    Map<String, Float> grade;

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

    /*public Student(Student S)
	{

	}*/
    public String getStudentID() {
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

    public double getGPA() {
        int sum = 0;
        int credits = 0;
        Class iteration;
        for (int i = 0; i < this.cls.size(); i++) {
            iteration = this.cls.get(i);
            if (this.grade.get(iteration.getClassID()) == null) {
                continue;
            }

            sum += this.grade.get(iteration.getClassID()) * iteration.getCredits();
            credits += iteration.getCredits();
        }
        return (double) sum / credits;
    }

    public boolean changeStudentID() {
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

    public boolean isStudentIDValid() {
        if ((this.student_id.charAt(0) == 'B' || this.student_id.charAt(0) == 'b') && student_id.length() == 8) {
            return true;
        } else {
            return false;
        }
    }

    public void displayBasicInfo() {
        System.out.println(
                "Student name: " + this.student_name + "\n"
                + "Student ID: " + this.student_id + "\n"
                + "Date of Birth: " + this.birth_date.toString() + "\n"
                + "Major: " + this.major + "\n"
                + "Course: " + this.course + "\n"
                + "Email: " + this.email + "\n"
        );
    }

    public boolean changeClassGrade(Class cls, float grade) {
	if(grade >= 0 && grade <= 10 && 
	   {
		   this.grade.put(cls.getClassID(), grade);
		   return true;
	   }
	else
	   {
		   return false;
	   }
    }

    public void addClass(Class cls) {
        cls.addStudent(this);
        this.cls.add(cls);
        this.grade.put(cls.getClassID(), null);
    }

    public void deleteClass(Class cls) {
        cls.deleteStudent(this);
        this.cls.remove(cls);
        this.grade.remove(cls.getClassID());
    }
    /*
	public void listAttendedClass()
	{
		Class iteration;		
		System.out.println("########Classes########");
		for(int i = 0; i < this.cls.size(); i++)
		{
			iteration = this.cls.get(i);
			System.out.println("Class ID: " + iteration.getClassID());
			System.out.println("Subject: " + iteration.getSubject());
			System.out.println("Instructor: " + iteration.getTeacher().getName());
			System.out.println("Credits: " + iteration.getCredits());
			System.out.println("Grade: " + grade.get(iteration.getClassID()));
			System.out.println("---------------------------");
		}
		System.out.println("#######################");
	}
	public void inputBasicInfo()
	{
		Scanner sc = new Scanner(System.in);
		Date birth_date = new Date();

		while(true)
		{
			try{
				System.out.print("Student ID: ");
				this.student_id = sc.nextLine().trim();
				
				if(this.isStudentIDValid(this.student_id))
				{
					break;
				}
				
				System.out.println("Invalid student ID!");
				sc.next();
				continue;

			}catch(NoSuchElementException e)
			{
				System.out.println("Invalid input!");
				sc.next();
				continue;
			}
		}
		while(true)
		{
			try{
				System.out.print("Student name: ");
				this.student_name = sc.nextLine().trim();
				break;

			}catch(NoSuchElementException e){
				System.out.println("Invalid input!");
				sc.next();
				continue;
			}
		}
		
		System.out.println("Date of Birth: ");
		this.birth_date.keyboardInput();
		
		while(true)
		{
			try{
				System.out.print("Major: ");
				this.major = sc.nextLine().trim();
				break;

			}catch(NoSuchElementException e){
				System.out.println("Invalid input!");
				sc.next();
				continue;
			}
		}
		while(true)
		{
			try{
				System.out.print("Course: ");
				this.course = sc.nextInt();
				break;

			}catch(InputMismatchException e){
				System.out.println("Invalid input!");
				sc.next();
				continue;
			}
		}
	}
/*
	public void inputAllGrade()
	{
		Class iteration;
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < this.cls.size(); i++)
		{
			iteration = this.cls.get(i);
			System.out.println("[" + iteration.getClassID() + "] " + iteration.subject + ": ");
			while(true)
			{
				try{
					this.grade.put(iteration.getClassID(), sc.nextInt());
					break;
				}catch(InputMismatchException e)
				{
					System.out.println("Invalid grade!");
					sc.next();
					continue;
				}
			}
		}
	}
     */
}
