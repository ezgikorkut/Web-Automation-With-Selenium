package com.test;

import com.main.BaseTest;
import com.main.Home;
import org.junit.Test;

public class N11Test extends BaseTest
{
           @Test
           public void successLogin() {

              new Home(driver).callLoginPage().login("ezgi-korkut@hotmail.com", "123456a");

           }
           @Test
           public void successSearching() throws InterruptedException {
               new Home(driver).callSearching().search();
           }
           @Test
            public void successBasket() throws InterruptedException {
               new Home(driver).callAddBasket().basket();
           }
           @Test
           public void successClearBasket() throws InterruptedException{
               new Home(driver).callclearBasket().clear();
           }
}
