package com.algoriant.sms.test;

import com.algoriant.sms.service.WRPLoginService;
import com.algoriant.sms.model.AccessToken;
import com.algoriant.sms.model.Authentication;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginService {
   private WRPLoginService wrpLoginService;
    @BeforeMethod
    public void createService(){
         wrpLoginService=new WRPLoginService();
    }
    @Test
    public void testLoginService(){
        Authentication authentication=new Authentication();
        authentication.setPassword("admin");
        authentication.setUsername("admin123");
        AccessToken accessToken= wrpLoginService.loginDetails();
        Assert.assertNotNull(accessToken);
        Assert.assertEquals(accessToken.getUsername(),authentication.getUsername());
    }
    @AfterMethod
    public void closeService(){
        wrpLoginService=null;
    }
}
