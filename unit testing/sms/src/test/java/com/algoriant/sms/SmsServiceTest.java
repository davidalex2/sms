package com.algoriant.sms;

import com.algoriant.sms.model.Student;
import com.algoriant.sms.repository.StudentRepository;
import com.algoriant.sms.services.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class SmsServiceTest {
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;
    private Student student;

    @Test
    @DisplayName("Testing the Creating Student Method !")
    void createStudent(){
        try {
            student = Student.builder()
                    .id(1)
                    .name("antony")
                    .number(2222)
                    .build();
            when(studentRepository.save(student)).thenReturn(student);
            student.setId(1);
            Student createStudent = studentService.saveStudent(student);
            assertEquals(student.getName(), createStudent.getName());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while test the program",th);
        }
    }
    @Test
    @DisplayName("Testing the Updating Student Method !")
    void updateStudent(){
        try {
            Student student1 = Student.builder()
                    .id(1)
                    .name("antony")
                    .number(2222)
                    .build();
            Student student = new Student(student1);
            when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
            when(studentRepository.save(student)).thenReturn(student);
            assertEquals(student,studentService.updateStudent(student));
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while test the program",th);
        }
    }

    @Test
    @DisplayName("Testing Delete methodStudent")
    void deleteStudent(){
        try{
            Student student = Student.builder()
                    .id(1)
                    .name("antony")
                    .number(2222)
                    .build();
            willDoNothing().given(studentRepository).deleteById(student.getId());
            studentService.deleteStudent(student.getId());
            verify(studentRepository,times(1)).deleteById(student.getId());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing the delete method",th);
        }
    }

    @Test
    @DisplayName("Testing GetStudentById method")
    void getStudentById(){
        try{
            Student student = Student.builder()
                    .id(1)
                    .name("antony")
                    .number(2222)
                    .build();
            when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
            assertEquals(student,studentService.getStudentById(student.getId()));
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing getStudentMethod !!");
        }
    }
    @Test
    @DisplayName("Testing GetAllStudent method")
    void getAllStudent(){
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

            when(studentRepository.findAll()).thenReturn(students);
            assertEquals(students,studentService.getAllStudent());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing getStudentMethod !!",th);
        }
    }
}