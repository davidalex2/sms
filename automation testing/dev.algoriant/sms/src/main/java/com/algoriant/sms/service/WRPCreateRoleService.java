package com.algoriant.sms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.algoriant.sms.model.Role;

import static com.mashape.unirest.http.Unirest.post;

public class WRPCreateRoleService {
   /* public static  void main(String[] args){
        WRPCreateRoleService wrpCreateRoleService=new WRPCreateRoleService();
        wrpCreateRoleService.getRole_RoleDesc();
    }*/
    public Role getRole_RoleDesc() {
        Role roles = new Role();
        roles.setRole("admin");
        roles.setRoleDesc("for admin");

        try {
            String role = new ObjectMapper().writeValueAsString(roles);
            HttpResponse<JsonNode> jsonNodeHttpResponse = post("http://192.168.1.40:8080/createRole").header("Content-Type", "application/json").body(role).asJson();
            //System.out.println(jsonNodeHttpResponse.getBody());
            return new ObjectMapper().readValue(jsonNodeHttpResponse.getBody().toString(),Role.class);


        } catch (JsonProcessingException | UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
