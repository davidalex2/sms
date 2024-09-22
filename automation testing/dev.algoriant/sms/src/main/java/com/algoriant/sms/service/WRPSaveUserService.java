package com.algoriant.sms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.algoriant.sms.model.Responce;
import com.algoriant.sms.model.Role;
import com.algoriant.sms.model.RolePojo;
import java.util.HashSet;
import java.util.Set;

import static com.mashape.unirest.http.Unirest.*;

public class WRPSaveUserService {
    public static void main(String[] args) throws UnirestException, JsonProcessingException {
        WRPSaveUserService credentialService=new WRPSaveUserService();
        WRPCreateRoleService wrpCreateRoleService=new WRPCreateRoleService();
        Responce responce=credentialService.getUsername_Password(wrpCreateRoleService.getRole_RoleDesc());
        System.out.println(responce.getUsername());
        System.out.println(responce.getPassword());
        System.out.println();
    }
    public Responce getUsername_Password(Role role) {
       RolePojo rolePojo = new RolePojo();
        rolePojo.setPassword("admin");
        rolePojo.setUsername("admin123");
        Set<Role> set = new HashSet<>();
        role.getRole();
        role.getRoleDesc();
        set.add(role);
        rolePojo.setRoles(set);
        try {
            String roleJson = new ObjectMapper().writeValueAsString(rolePojo);
            HttpResponse<JsonNode> jsonNodeHttpResponse1 = post("http://192.168.1.40:8080/saveUser").header("Content-Type", "application/json").body(roleJson).asJson();
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(jsonNodeHttpResponse1.getBody());
            return mapper.readValue(jsonNodeHttpResponse1.getBody().toString(), Responce.class);
        } catch (JsonProcessingException | UnirestException e) {
            throw new RuntimeException(e);
        }
    }
    }
