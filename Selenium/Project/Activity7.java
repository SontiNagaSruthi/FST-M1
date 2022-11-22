package LMS_Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Activity7 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {

        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

        @Test
        public void verifyNoOfCourses() {
            driver.findElement(By.xpath("//a[text()='All Courses']")).click();

            List<WebElement> list = driver.findElements(By.xpath("//div[@class='caption']//h3"));

            System.out.println("Number of courses available on the page " + list.size());
        }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.close();
    }




}

