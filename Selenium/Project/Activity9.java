package LMS_Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {

        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void verifyCoursePage() {
        driver.findElement(By.xpath("//a[text()='My Account']")).click();
        driver.findElement(By.xpath("//a[text()='Login']")).click();

        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");

        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        driver.findElement(By.xpath("//a[text()='All Courses']")).click();

        driver.findElement(By.xpath("//h3[contains(text(),'Social Media Marketing')]/parent::div//p[2]//a")).click();


        driver.findElement(By.xpath("//div[contains(text(),'Developing Strategy')] ")).click();

        String coursePageTitle = driver.getTitle();

        Assert.assertTrue(coursePageTitle.contains("Developing Strategy"), "the course page opened successfully");

        System.out.println("Mark complete button is not available");
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.close();
    }





    }

