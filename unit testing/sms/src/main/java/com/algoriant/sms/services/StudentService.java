package com.algoriant.sms.services;

import com.algoriant.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.algoriant.sms.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public Student saveStudent(Student student){
        studentRepository.save(student);
        return student;
    }
    public List<Student> getAllStudent(){
        List<Student> student=new ArrayList<>();
        studentRepository.findAll().forEach(student::add);
        return student;
    }
    public Student getStudentById(int id){
        return studentRepository.findById(id).get();
    }
    public void deleteStudent(int id){
        studentRepository.deleteById(id);
    }
    public Student updateStudent(Student student){
        Optional<Student> student1=studentRepository.findById(student.getId());
        if (student1.isPresent()){
            Student student2= student1.get();
            student2.setName(student.getName());
            student2.setNumber(student.getNumber());
            studentRepository.save(student2);
        }
        return student;
    }
}
