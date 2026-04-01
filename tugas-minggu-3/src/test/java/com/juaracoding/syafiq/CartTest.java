package com.juaracoding.syafiq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.juaracoding.syafiq.utils.Utils;

public class CartTest extends BaseTest { 

    @Test(priority = 3) 
    public void testAddToCart() {
        System.out.println("STEP: Menambahkan produk (Melanjutkan sesi Login)");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(cartBadge.getText(), "2");
        Utils.delay(5);
    }

    @Test(priority = 4)
    public void testCheckCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
        WebElement txtTitle = driver.findElement(By.className("title"));
        Assert.assertEquals(txtTitle.getText(), "Your Cart");
        
        Utils.delay(3);
        driver.findElement(By.id("checkout")).click();
        Utils.delay(5);

    }




}