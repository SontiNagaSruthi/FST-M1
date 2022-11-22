package liveProjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("deviceId","RZ8N91WNQYW");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.google.android.keep");
        caps.setCapability("appActivity",".activities.BrowseActivity");
        caps.setCapability("noReset",true);

        //Appium server URL
        URL serverURL=new URL("http://localhost:4723/wd/hub");

        //Driver initialization
        driver=new AndroidDriver<MobileElement>(serverURL,caps);
        wait = new WebDriverWait(driver, 5);

    }

    @Test
    public void addKeeps()
    {
        driver.findElementByAccessibilityId("New text note").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("editable_title")));
        WebElement noteTitle= driver.findElementById("editable_title");
        noteTitle.sendKeys("Appium Activities");
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("edit_note_text")));
        WebElement notedesc= driver.findElementById("edit_note_text");
        notedesc.sendKeys("Completed Appium Activities");

        driver.findElementByAccessibilityId("Open navigation drawer").click();

        String notetitle=driver.findElementById("index_note_title").getText();
        Assert.assertEquals(notetitle,"Appium Activities","Keeps are added successfully");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
