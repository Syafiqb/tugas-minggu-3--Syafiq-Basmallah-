package com.juaracoding.syafiq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.juaracoding.syafiq.utils.Utils;

public class CheckoutTest extends BaseTest {

    

    @Test(priority = 5)
    public void testEmptyInformation() {
        System.out.println("STEP: Negative Test - Checkout field kosong");

        driver.findElement(By.id("first-name")).clear();
        driver.findElement(By.id("last-name")).clear();
        driver.findElement(By.id("postal-code")).clear();

        Utils.delay(3);
        driver.findElement(By.id("continue")).click();

        // Validasi pesan error field kosong
        WebElement errorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String txtError = errorMsg.getText();
        System.out.println("Error Text: " + txtError);

        Assert.assertTrue(txtError.contains("First Name is required"));

        // Kembali bersih untuk test berikutnya
        driver.findElement(By.className("error-button")).click();
        Utils.delay(5);
}

    @Test(priority = 6)
    public void testCheckoutInformation() {
        System.out.println("STEP: Mengisi informasi checkout");

        driver.findElement(By.id("first-name")).sendKeys("Syafiq");
        driver.findElement(By.id("last-name")).sendKeys("Ahmad");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        
        Utils.delay(1);
        driver.findElement(By.id("continue")).click();

        WebElement txtOverview = driver.findElement(By.className("title"));
        Assert.assertEquals(txtOverview.getText(), "Checkout: Overview");
        Utils.delay(5);
    }

    @Test(priority = 7)
    public void testFinishCheckout() {
        System.out.println("STEP: Menyelesaikan pesanan");
        
        // Klik finish
        driver.findElement(By.id("finish")).click();

        // Validasi pesan sukses
        WebElement txtComplete = driver.findElement(By.className("complete-header"));
        Assert.assertEquals(txtComplete.getText(), "Thank you for your order!");
        
        Utils.delay(2);
    }

    @AfterClass
    public void tearDown() {
        // Karena ini class terakhir dalam alur, kita tutup driver di sini
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}