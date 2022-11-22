package LMS_Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {

        driver = new FirefoxDriver();


        driver.get("https://alchemy.hguy.co/lms");
    }

        @Test
        public void verifyInfoBoxTitle() {
            String infoboxtitle = driver.findElement(By.xpath("(//div[contains(@class,'uagb-ifb-title')]//h3)[1]")).getText();
            Assert.assertEquals(infoboxtitle, "Actionable Training");
        }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.close();
    }



    }

