package com.main;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class searchPage extends BasePageUtil {
    public searchPage(WebDriver driver) { super(driver); }
    public  void search() throws InterruptedException{

        Thread.sleep(2000);
        driver.findElement(By.id("searchData")).sendKeys("Bilgisayar");
        Thread.sleep(2000);

        driver.findElement(By.className("searchBtn")).click();

        Thread.sleep(2000);
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0, document.body.scrollHeight)","");
        Thread.sleep(2000);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"contentListing\"]/div/div/div[2]/div[4]/a[2]")).click();

        Assert.assertTrue(driver.getTitle().contains("Bilgisayar - n11.com - 2/"));
        System.out.println("2. Sayfa Gösterimde ...");
    }
}
