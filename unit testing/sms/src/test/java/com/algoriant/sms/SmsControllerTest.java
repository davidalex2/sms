package com.algoriant.sms;

import com.algoriant.sms.controller.StudentController;
import com.algoriant.sms.model.Student;
import com.algoriant.sms.services.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SmsControllerTest {
    @Mock
    private StudentService studentService;
    @InjectMocks
    private StudentController studentController;

    @Test
    @DisplayName("Testing creating method for Student")
    void createStudent(){
        try{
            Student student = Student.builder()
                    .id(1)
                    .name("antony")
                    .number(2222)
                    .build();
            Student student1 = new Student(student);
            when(studentService.saveStudent(student)).thenReturn(student1);
            ResponseEntity<Student> studentResponseEntity = studentController.saveStudent(student);
            assertEquals(HttpStatus.CREATED,studentResponseEntity.getStatusCode());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing CreateStudent method !!",th);
        }
    }

    @Test
    @DisplayName("Testing updating method for Student")
    void updateStudent() {
        try {
            Student student = Student.builder()
                    .id(1)
                    .name("antony")
                    .number(2222)
                    .build();
            Student student1=new Student(student);
            student1.setId(1);
            when(studentService.getStudentById(student.getId())).thenReturn(student1);
            ResponseEntity<Student> studentResponseEntity= studentController.updateStudent(student.getId(),student);
            assertEquals(HttpStatus.OK,studentResponseEntity.getStatusCode());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing updateStudent methods !!",th);
        }
    }

    @Test
    @DisplayName("Testing Delete method for Student")
    void deleteStudent(){
        try {
            Student student = Student.builder()
                    .id(1)
                    .name("antony")
                    .number(2222)
                    .build();
            willDoNothing().given(studentService).deleteStudent(student.getId());
            ResponseEntity<String> studentResponseEntity = studentController.deleteStudent(student.getId());
            assertEquals(HttpStatus.OK,studentResponseEntity.getStatusCode());

        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing getStudentMethod !!",th);
        }
    }

    @Test
    @DisplayName("Testing find all method for Student")
    void findAllStudent(){
        try {
            List<Student> students=new ArrayList<>();
            Student student1 = Student.builder()
                    .id(1)
                    .name("antony")
                    .number(2222)
                    .build();
            Student student2 = Student.builder()
                    .id(1)
                    .name("antony")
                    .number(2222)
                    .build();
            students.add(student1);
            students.add(student2);
            when(studentService.getAllStudent()).thenReturn(students);
            ResponseEntity<List<Student>> responseEntity = studentController.getAllStudent();
            assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing getStudentMethod !!",th);
        }
    }
    @Test
    @DisplayName("Testing find by id method for Student")
    void findStudentById(){
        try {
            Student student = Student.builder()
                    .id(1)
                    .name("antony")
                    .number(2222)
                    .build();
            when(studentService.getStudentById(student.getId())).thenReturn(student);
            ResponseEntity<Student> studentResponseEntity = studentController.getStudentById(student.getId());
            assertEquals(HttpStatus.OK,studentResponseEntity.getStatusCode());

        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing getStudentMethod !!",th);
        }
    }
}
