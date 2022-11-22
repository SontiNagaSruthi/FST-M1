package LMS_Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {

        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

        @Test
        public void verifySecondMostPopularCourseTitle() {
            String coursetitle = driver.findElement(By.xpath("(//div[@class='caption']//h3)[2]")).getText();

            Assert.assertEquals(coursetitle, "Email Marketing Strategies");
        }
            @AfterMethod
            public void afterMethod() {
            //Close the browser
            driver.close();
        }

    }

