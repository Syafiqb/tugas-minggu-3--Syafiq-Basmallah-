package com.juaracoding.syafiq;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.juaracoding.syafiq.utils.Utils;
import java.time.Duration;

public class LoginTest extends BaseTest {

    
    @BeforeClass
    public void setUp() {
        setupDriver(); 
        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void testLoginEmptyField() {
    driver.findElement(By.id("user-name")).clear();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("login-button")).click();

    WebElement errorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
    Assert.assertTrue(errorMsg.getText().contains("Username is required"));

    driver.navigate().refresh();
    Utils.delay(5);
}

    @Test(priority = 2)
    public void testLoginSuccessful() {
        System.out.println("STEP: Running Positive Login Test");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        
        WebElement txtProduct = driver.findElement(By.className("title"));
        System.out.println("Dashboard Text: " + txtProduct.getText());
        
        Assert.assertEquals(txtProduct.getText(), "Products");

        Utils.delay(5);
    }

    
}