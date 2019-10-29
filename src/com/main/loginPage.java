package com.main;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class  loginPage extends BasePageUtil implements General{

    public loginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        thread(2000);
        click(By.className("btnSignIn"));
        thread(3000);
        sendKey(EMAIL_TEXTBOX, email);
        thread(2000);
        sendKey(PASSWORD_TEXTBOX, password);
        thread(3000);
        click(By.id("loginButton"));
        thread(2000);

        Assert.assertTrue(driver.getTitle().contains("n11.com - Alışverişin Uğurlu Adresi"));
        thread(2000);
    }

}
