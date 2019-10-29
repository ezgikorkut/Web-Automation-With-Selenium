package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends BasePageUtil{

	public Home(WebDriver driver) {
            super(driver);
        }
    public loginPage callLoginPage() {

	    thread(2);
        driver.findElement(By.className("btnSignIn"));
        thread(3);
        return new loginPage(driver);
	}
    public searchPage callSearching() {
        thread(3);
        driver.findElement(By.id("searchData")).click();
        return new searchPage(driver);

    }
    public addBasket callAddBasket() {
        thread(3);
        driver.findElement(By.id("searchData")).click();
        return new addBasket(driver);
    }
    public clearBasket callclearBasket(){
        thread(3);
        driver.findElement(By.id("searchData")).click();
        return new clearBasket(driver);
    }


}
