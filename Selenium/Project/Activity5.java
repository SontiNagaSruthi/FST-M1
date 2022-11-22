package LMS_Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {

        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

        @Test
        public void verifyMyAccountPageTitle() {
            driver.findElement(By.xpath("//a[text()='My Account']")).click();

            String pagetitle = driver.getTitle();
            System.out.println("Page title is " + pagetitle);

            Assert.assertEquals(pagetitle, "My Account – Alchemy LMS");
        }

            @AfterMethod
            public void afterMethod() {
            //Close the browser
            driver.close();
        }

    }

