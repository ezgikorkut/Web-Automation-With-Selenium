package com.main;

import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.List;
import java.util.Random;

public class addBasket extends BasePageUtil{

    public addBasket(WebDriver driver) {
        super(driver);
    }
    public void basket() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("searchData")).sendKeys("Bilgisayar");
        Thread.sleep(2000);
        driver.findElement(By.className("searchBtn")).click();

    /*  Thread.sleep(2000);
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

        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/div[4]/a/i")).click();}
        Thread.sleep(5000);*/


        JavascriptExecutor scroll = (JavascriptExecutor) driver;

        int offset = 0;
        while(true) {
            try {
                scroll.executeScript("window.scrollTo(0, document.body.scrollHeight - " + offset + ")");
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@id=\"contentListing\"]/div/div/div[2]/div[4]/a[2]")).click();
                break;
            } catch (ElementClickInterceptedException e) {
                offset += 500;
            }
        }

        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().contains("Bilgisayar - n11.com - 2/"));
        System.out.println("2. Sayfa Gösterimde ...");

        List<WebElement> links = driver.findElements(By.cssSelector("a.plink"));

        links.subList(0, 10).clear();

        Random rand = new Random();
        int randIndex = rand.nextInt(links.size());

        offset = 0;
        while(true) {
            try {
                scroll.executeScript("window.scrollTo(0, " + offset + ")");
                Thread.sleep(2000);
                links.get(randIndex).click();
                break;
            } catch (ElementClickInterceptedException e) {
                offset += 500;
            }
        }


        Thread.sleep(2000);

        // urun fiyati
        String productPrice = driver.findElement(By.xpath("//*[@id=\"contentProDetail\"]/div/div[3]/div[2]/div[3]/div[2]/div/div[1]/div/ins"))
                .getAttribute("content");

        // sepete ekle
        links = driver.findElements(By.cssSelector("a.btnAddBasket"));
        links.get(0).click();

        Thread.sleep(2000);

        // sepete git
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/div[4]/a")).click();

        Thread.sleep(2000);

        // fiyat karsilastir
        links = driver.findElements(By.cssSelector("div.priceArea > span"));
        String otherPrice = links.get(0).getText();

        Thread.sleep(2000);

        StringBuilder sb = new StringBuilder(otherPrice);
        sb.deleteCharAt(sb.indexOf("."));
        String newPrice = sb.substring(0, sb.indexOf(" ")).replace(',', '.');

        System.out.println(productPrice + " - " + newPrice);
        Assert.assertEquals(productPrice,newPrice);
        System.out.println("Same Price");

        // urun sayisi arttir
        links = driver.findElements(By.cssSelector("span.spinnerUp"));
        links.get(0).click();

        Thread.sleep(2000);


        System.out.println("successful");


    }}