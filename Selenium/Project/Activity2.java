package LMS_Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {

        driver = new FirefoxDriver();


        driver.get("https://alchemy.hguy.co/lms");
    }



        @Test
        public void verifyWebsiteHeading() {
            String header = driver.findElement(By.xpath("//div//h1")).getText();

            Assert.assertEquals(header, "Learn from Industry Experts");
        }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.close();
    }


    }

