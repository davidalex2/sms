package com.algoriant.sms.test;

import com.algoriant.sms.model.Responce;
import com.algoriant.sms.model.Role;
import com.algoriant.sms.model.RolePojo;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.algoriant.sms.service.WRPSaveUserService;

import java.util.HashSet;
import java.util.Set;

public class TestSaveUserService {
    private WRPSaveUserService wrpSaveUserService;
    @BeforeMethod
    public void createService()
    {
        wrpSaveUserService=new WRPSaveUserService();
    }
    @Test
    public void testSaveUser() {
        RolePojo rolePojo = new RolePojo();
        rolePojo.setPassword("admin");
        rolePojo.setUsername("admin123");
        Set<Role> set = new HashSet<>();
        Role role=new Role();
        role.setRole("admin");
        role.setRoleDesc("for admin");
        set.add(role);
        rolePojo.setRoles(set);

        Responce responce=wrpSaveUserService.getUsername_Password(role);
        Assert.assertNotNull(responce);
        Assert.assertNotNull(role);
        Assert.assertEquals(responce.getUsername(),rolePojo.getUsername());

    }
    @AfterMethod
    public  void closeService(){
        wrpSaveUserService=null;
    }
}
