package LMS_Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {
    WebDriver driver;


    @BeforeMethod
    public void beforeMethod() {

        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

        @Test
        public void verifyContactScreen() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.findElement(By.xpath("//a[text()='Contact']")).click();

            driver.findElement(By.xpath("//label[text()='Full Name ']/parent::div//input")).sendKeys("Pratiti Lahiri");
            driver.findElement(By.xpath("//label[text()='Email ']/parent::div//input")).sendKeys("abc@gmail.com");
            driver.findElement(By.xpath("//label[text()='Subject']/parent::div//input")).sendKeys("Unable to open course material");
            driver.findElement(By.xpath("//label[text()='Comment or Message ']/parent::div//textarea")).sendKeys("Please help to find the material");

            driver.findElement(By.xpath("//button[text()='Send Message']")).click();

            WebElement confirmMsg = driver.findElement(By.xpath("//div[contains(@id,'wpforms-confirmation')]//p"));

            wait.until(ExpectedConditions.visibilityOf(confirmMsg));

            String message = driver.findElement(By.xpath("//div[contains(@id,'wpforms-confirmation')]//p")).getText();

            System.out.println("message is " + message);
        }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.close();
    }





    }

