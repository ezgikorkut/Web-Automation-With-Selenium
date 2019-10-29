package com.main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class clearBasket extends BasePageUtil {
    public clearBasket(WebDriver driver) {
        super(driver);
    }

    public void clear () throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.id("searchData")).sendKeys("Bilgisayar");
        Thread.sleep(2000);
        driver.findElement(By.className("searchBtn")).click();

        Thread.sleep(2000);
    JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0, document.body.scrollHeight)", "");

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"contentListing\"]/div/div/div[2]/div[4]/a[2]")).click();
        scroll.executeScript("window.scrollBy(0, 500)", "");

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"p-381305630\"]/div[1]/a/h3")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"contentProDetail\"]/div/div[3]/div[2]/div[3]/div[3]/a[2]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/div[4]/a/i")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"newCheckout\"]/div/div[1]/div[2]/div[1]/section[2]/table[2]/tbody/tr/td[3]/div[1]/div/span[1]")).click();
}}