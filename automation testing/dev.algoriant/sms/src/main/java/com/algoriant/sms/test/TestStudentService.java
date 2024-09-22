package com.algoriant.sms.test;

import com.algoriant.sms.model.AccessToken;
import com.algoriant.sms.model.Authentication;
import com.algoriant.sms.model.Responce;
import com.algoriant.sms.service.WRPLoginService;
import com.algoriant.sms.service.WRPStudentService;
import com.algoriant.sms.model.Student;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestStudentService {
   // private  WRP
    private WRPStudentService wrpStudentService;
    private static String token;
    @BeforeClass
    public void createToken(){
        Authentication authentication=new Authentication();
        authentication.setPassword("admin");
        authentication.setUsername("admin123");
        WRPLoginService wrpLoginService=new WRPLoginService();
        AccessToken accessToken=wrpLoginService.loginDetails();
        token=accessToken.getAccessToken();
    }
    @BeforeMethod
    public void createService()
    {
        wrpStudentService=new WRPStudentService();
    }
    @Test
    public void createStudent() {
        Student student=new Student();
        student.setName("david");
        student.setEmail("davidalex@gmail.com");
        student.setPhoneno(123456789);

        Student createStudent=wrpStudentService.createStudent(token);
        Assert.assertNotNull(createStudent);
        Assert.assertEquals(createStudent.getName(),student.getName());
        Assert.assertEquals(createStudent.getPhoneno(),student.getPhoneno());
        Assert.assertEquals(createStudent.getEmail(),student.getEmail());
    }
    @Test
    public  void updateStudent(){
        Student student=new Student();
        student.setName("mani");
        student.setEmail("mani@gmail.com");
        student.setPhoneno(123456789);
        student.setId(10);
        Responce update=wrpStudentService.updateStudent(token);
        Assert.assertNotNull(update);
    }
    @Test
    public  void removeStudent(){
        Student student=new Student();
        student.setId(20);
        Responce responce=wrpStudentService.removeStudent(token);
        Assert.assertNotNull(responce);
    }
    @Test
    public void getStudent(){
        Student student= wrpStudentService.getStudent(token);
        student.setId(21);
        Assert.assertNotNull(student);
        Assert.assertEquals(21,student.getId());
        Assert.assertNotNull(student.getName());
        Assert.assertNotNull(student.getEmail());
        Assert.assertNotNull(student.getPhoneno());
    }
    @Test
    public void getAllStudent(){
        List<Student> student= wrpStudentService.getAllStudent(token);
        Assert.assertNotNull(student);
    }
    @AfterMethod
    public  void closeService(){
        wrpStudentService=null;
    }
}
