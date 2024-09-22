package com.algoriant.sms.controller;

import com.algoriant.sms.model.Student;
import com.algoriant.sms.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/createStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/getAllStudent")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> student=studentService.getAllStudent();
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id")int userId){
        Student student = studentService.getStudentById(userId);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id")int userId){
        studentService.deleteStudent(userId);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id")int userId,@RequestBody Student student){
        student.setId(userId);
        studentService.saveStudent(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
