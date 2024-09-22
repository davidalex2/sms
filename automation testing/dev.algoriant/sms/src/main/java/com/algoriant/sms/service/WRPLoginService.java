package com.algoriant.sms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.algoriant.sms.model.AccessToken;
import com.algoriant.sms.model.Authentication;

public class WRPLoginService {
   /* public  static void main(String[] arg) throws UnirestException, IOException {
        WRPLoginService loginService=new WRPLoginService();
        AccessToken accessToken=loginService.loginDetails();
        System.out.println("Token "+accessToken.getAccessToken());
        System.out.println("UserName "+accessToken.getUsername());
    }*/
    public AccessToken loginDetails() {
        Authentication authentication=new Authentication();
        authentication.setPassword("admin");
        authentication.setUsername("admin123");

        String details= null;
        try {
            details = new ObjectMapper().writeValueAsString(authentication);
            HttpResponse<JsonNode> jsonNodeHttpResponse= Unirest.post("http://192.168.1.40:8080/auth/login")
                    .header("Content-type","application/json").body(details).asJson();
            ObjectMapper mapper=new ObjectMapper();
            return mapper.readValue((jsonNodeHttpResponse.getBody()).toString(), AccessToken.class);
        } catch (JsonProcessingException | UnirestException e) {
            throw new RuntimeException(e);
        }


    }
}
