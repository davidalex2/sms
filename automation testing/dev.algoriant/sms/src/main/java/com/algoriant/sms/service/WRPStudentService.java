package com.algoriant.sms.service;

import com.algoriant.sms.model.Responce;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.algoriant.sms.model.Student;

import java.util.Arrays;
import java.util.List;

//sudo kill -9 $(sudo kill lsof -t -i:8080) to stop the server
public class WRPStudentService {
    /*  static String token=null;
   public static void main(String[] args) {
        WRPLoginService loginService=new WRPLoginService();
        AccessToken accessToken=loginService.loginDetails();
        token= accessToken.getAccessToken();
        WRPStudentService studentService = new WRPStudentService();
        studentService.createStudent(token);
        studentService.updateStudent(token);
        studentService.getStudent(token);
        studentService.getAllStudent(token);
        studentService.removeStudent(token);


    }*/
    public Student createStudent(String token) {
        Student student=new Student();
        student.setName("david");
        student.setEmail("davidalex@gmail.com");
        student.setPhoneno(123456789);

        try {
            String  studentDetails = new ObjectMapper().writeValueAsString(student);
            HttpResponse<JsonNode> jsonNodeHttpResponse= Unirest.post("http://192.168.1.40:8080/student/createStudent")
                    .header("Content-Type","application/json").header("Authorization","Bearer "+token).body(studentDetails).asJson();
            //System.out.println(jsonNodeHttpResponse.getBody());
            return new ObjectMapper().readValue(jsonNodeHttpResponse.getBody().toString(),Student.class);
        } catch (JsonProcessingException | UnirestException exception) {
            throw new RuntimeException(exception);
        }
    }
    public Responce updateStudent(String token)  {
        Student student=new Student();
        student.setName("mani");
        student.setEmail("mani@gmail.com");
        student.setPhoneno(123456789);
        student.setId(10);
        String studentDetails= null;
        try {
            studentDetails = new ObjectMapper().writeValueAsString(student);
            HttpResponse<JsonNode> jsonNodeHttpResponse= Unirest.put("http://192.168.1.40:8080/student/modifyStudentRecord/10")
                    .header("Content-Type","application/json").header("Authorization","Bearer "+token).body(studentDetails).asJson();
            //System.out.println(jsonNodeHttpResponse.getBody());
            return  new ObjectMapper().readValue(jsonNodeHttpResponse.getBody().toString(),Responce.class);
        } catch (JsonProcessingException | UnirestException exception) {
            throw new RuntimeException(exception);
        }

    }
    public Responce removeStudent(String token)  {
        try {
            HttpResponse<JsonNode> jsonNodeHttpResponse= Unirest.delete("http://192.168.1.40:8080/student/removeStudent/20")
                    .header("Content-Type","application/json").header("Authorization","Bearer "+token).asJson();
            return new ObjectMapper().readValue(jsonNodeHttpResponse.getBody().toString(),Responce.class);
        } catch (UnirestException | JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }
    public Student getStudent(String token) {
        try {
            HttpResponse<JsonNode> jsonNodeHttpResponse= Unirest.get("http://192.168.1.40:8080/student/getStudent/21")
                    .header("Content-Type","application/json").header("Authorization","Bearer "+token).asJson();
           String value= String.valueOf(jsonNodeHttpResponse.getBody());
           return new ObjectMapper().readValue(value,Student.class);
        } catch (UnirestException | JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }
    public List<Student> getAllStudent(String token) {
        try {
         HttpResponse<JsonNode> jsonNodeHttpResponse= Unirest.get("http://192.168.1.40:8080/student/getAllStudent")
                .header("Content-Type","application/json").header("Authorization","Bearer "+token).asJson();
         ObjectMapper mapper=new ObjectMapper();
         //System.out.println(jsonNodeHttpResponse.getBody());
            String details=jsonNodeHttpResponse.getBody().toString();

         return mapper.readValue(details, new TypeReference<List<Student>>() {
         });
        } catch (UnirestException | JsonProcessingException exception) {
        throw new RuntimeException(exception);
    }
    }
}


