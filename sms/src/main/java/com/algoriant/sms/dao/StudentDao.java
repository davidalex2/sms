package com.algoriant.sms.dao;

import com.algoriant.model.Student;
import java.util.List;

public interface StudentDao {

	public void createStudent(Student student);
	public void updateStudent(Student student);
	public Student deleteStudent(int id);
	public List<Student> getAllStudent();
}