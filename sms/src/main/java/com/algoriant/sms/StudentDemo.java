package com.algoriant.sms;

import com.algoriant.sms.impl.StudentDaoImpl;
import com.algoriant.sms.dao.StudentDao;
import com.algoriant.model.Student;
import java.util.Scanner;
import java.sql.Date;

class StudentDemo {
	
	public static void main(String[] args) {
		Student student=new Student();
		StudentDao sdi=new StudentDaoImpl();
		Scanner s=new Scanner(System.in);
		System.out.println("1 -Insert, 2 -Update, 3 -Delete, 4 -Display all the details");
		int num=s.nextInt();
		while (num!=0) {
			num=s.nextInt();
			if (num==1) {
				System.out.println("name");
				String student_name=s.nextLine();
				student.setName(student_name);
				System.out.println("Department");
				String student_dept=s.nextLine();
				student.setDept(student_dept);
				System.out.println("Date:");
				//Date student_dob=s.nextDate();
				//Date date=new Date(utilPackage.getTime(student_dob));
				//java.util.Date utilDate=new java.util.Date();
				//java.sql.Date date=new java.sql.Date(utilDate.getTime());
				Date date=new Date(20010925);
				student.setDob(date);
				sdi.createStudent(student);
			} else if(num==2) {
				student.setName("alex");
				student.setDept("cs");
				sdi.updateStudent(student);
			} else if (num==3) {
				sdi.deleteStudent(1);
			} else if (num==4) {
				sdi.getAllStudent();
			} else {
				System.out.println("No options left.");
			}
		}
	}
}