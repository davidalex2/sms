package com.algoriant.sms.impl;

import com.algoriant.sms.dao.StudentDao;
import com.algoriant.model.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.util.Scanner;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Date;

public class StudentDaoImpl implements StudentDao {
	
	public String url="jdbc:postgresql://localhost:5432/postgres";
	public String uname="postgres";
	public String pwd="root";
	PreparedStatement ps;
	List<Student> student;
	Scanner s=new Scanner(System.in);
	
	public void createStudent(Student student) {
		String query="INSERT INTO student(name,dept,dob) VALUES(?,?,?)";	
		try {
			Connection con=DriverManager.getConnection(url,uname,pwd);
			ps=con.prepareStatement(query);	
			ps.setString(2,student.getName());
			ps.setString(3,student.getDept());
			ps.setDate(4,student.getDob());
			int abc=ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
}
	public void updateStudent(Student student) {
		try {
			Connection con=DriverManager.getConnection(url,uname,pwd);
			String query="UPDATE student SET name=?, dept=? ,dob=?  WHERE name='alex'";		
			ps=con.prepareStatement(query);
			ps.setString(2,student.getName());
			ps.setString(3,student.getDept());	
			ps.setDate(4,student.getDob());	
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Student deleteStudent(int id) {
		String query="DELETE FROM student WHERE id=?";	
	try {
		Connection con=DriverManager.getConnection(url,uname,pwd);
		ps=con.prepareStatement(query);	
		ps.setInt(1,student.getId());
		ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Student> getAllStudent() {
		try {
			Connection con=DriverManager.getConnection(url,uname,pwd);
			String query="SELECT * FROM student";		
			ps=con.prepareStatement(query);
			ps.executeQuery();
			ResultSet rst=ps.executeQuery();
			while (rst.next()) {
				System.out.println("ID is::"+rst.getInt(1));
				System.out.println("Name is::"+rst.getString(2));
				System.out.println("Password is::"+rst.getString(3));
				System.out.println("Date of birth::"+rst.getDate(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}
}
