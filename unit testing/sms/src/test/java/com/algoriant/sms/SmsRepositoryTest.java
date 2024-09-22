package com.algoriant.sms;

import com.algoriant.sms.model.Student;
import com.algoriant.sms.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmsRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    @DisplayName("Testing save method for Student")
    public void saveStudent(){
        try{
            Student student1 = Student.builder()
                    .id(1)
                    .name("antony")
                    .number(12223)
                    .build();
            Student saveStudent = studentRepository.save(student1);
            assertThat(saveStudent).isNotNull();
            assertThat(saveStudent.getId()).isGreaterThan(0);
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing saveStudent method",th);
        }
    }

    @Test
    @DisplayName("Testing get all method for Student")
    public void getAllStudent(){
        try{
            Student student1 = Student.builder()
                    .id(1)
                    .name("antony")
                    .number(12223)
                    .build();
            Student student2 = Student.builder()
                    .id(2)
                    .name("anto")
                    .number(1277)
                    .build();
            studentRepository.save(student1);
            studentRepository.save(student2);

            List<Student> studentList = (List<Student>) studentRepository.findAll();
            assertThat(studentList).isNotNull();
            assertThat(studentList.size()).isEqualTo(2);
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing getAllStudent method",th);
        }
    }

    @Test
    @DisplayName("Testing Get By Id method for Student")
    public void getStudentById(){
        try{
            Student student1 = Student.builder()
                    .id(1)
                    .name("antony")
                    .number(12223)
                    .build();
            studentRepository.save(student1);
            Student student = studentRepository.findById(student1.getId()).get();
            assertThat(student).isNotNull();
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing getStudentById method",th);
        }
    }

    @Test
    @DisplayName("Testing update method for Student")
    public void updateStudent(){
        try{
            Student student1 = Student.builder()
                    .id(1)
                    .name("antony")
                    .number(12223)
                    .build();
            studentRepository.save(student1);
            Student savestudent = studentRepository.findById(student1.getId()).get();
            savestudent.setNumber(22222);
            savestudent.setName("jeni");
            Student updateStudent = studentRepository.save(savestudent);
            assertThat(savestudent.getName()).isEqualTo("jeni");
            assertThat(savestudent.getNumber()).isEqualTo(22222);
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing updateStudent method",th);
        }
    }

    @Test
    @DisplayName("Testing delete method for Student")
    public void deleteStudent(){
        try{
            Student student1 = Student.builder()
                    .id(1)
                    .name("antony")
                    .number(12223)
                    .build();
            studentRepository.save(student1);
            studentRepository.deleteById(student1.getId());
            Optional<Student> OptionalStudent = studentRepository.findById(student1.getId());
            assertThat(OptionalStudent).isEmpty();
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing deleteStudent method",th);
        }
    }
}
