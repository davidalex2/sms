package com.algoriant.sms.test;

import com.algoriant.sms.model.Role;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.algoriant.sms.service.WRPCreateRoleService;

public class TestCreateRoleService {
   private WRPCreateRoleService wrpCreateRoleService;
    @BeforeMethod
    public void createService() {
        wrpCreateRoleService=new WRPCreateRoleService();
    }
    @Test
    public void createRole() {
        Role role=new Role();
        role.setRole("admin");
        role.setRoleDesc("for admin");
        Role newRole=wrpCreateRoleService.getRole_RoleDesc();
        Assert.assertNotNull(newRole);
        Assert.assertEquals("admin",newRole.getRole());
        Assert.assertEquals("for admin",newRole.getRoleDesc());
    }
    @AfterMethod
    public void clearService() {
        wrpCreateRoleService=null;
    }
}
