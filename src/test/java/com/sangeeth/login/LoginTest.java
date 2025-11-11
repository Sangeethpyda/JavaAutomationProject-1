package com.sangeeth.login;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest{

    @Test
    public void verifyValidLogin() {
        LoginPage loginpage = new LoginPage(driver);

        //Fetch username and password from config.properties
        String username = ConfigManager.getProperty("username");
        String password = ConfigManager.getProperty("password");

        //perform login
        loginpage.login(username, password);

        //Verify success message
        String actualMessage = loginpage.getSuccessMessage();
        Assert.assertTrue(actualMessage.contains("Logged In succesfully"),
                "Loginfailed! Expected message not found.");
    }
}
