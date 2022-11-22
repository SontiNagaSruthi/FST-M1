package LMS_Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {

        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

        @Test
        public void verifyLoginPage() {
            driver.findElement(By.xpath("//a[text()='My Account']")).click();

            String pagetitle = driver.getTitle();
            System.out.println("Page title is " + pagetitle);

            Assert.assertEquals(pagetitle, "My Account – Alchemy LMS");

            driver.findElement(By.xpath("//a[text()='Login']")).click();

            driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
            driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");

            driver.findElement(By.xpath("//input[@value='Log In']")).click();

            boolean flag = driver.findElement(By.xpath("//div//h1[contains(text(),'My Account')]")).isDisplayed();

            Assert.assertTrue(flag, "User is in login page");
        }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.close();
    }



    }

