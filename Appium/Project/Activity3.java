package liveProjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("deviceId","RZ8N91WNQYW");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.android.chrome");
        caps.setCapability("appActivity","com.google.android.apps.chrome.Main");
        caps.setCapability("noReset",true);

        //Appium server URL
        URL serverURL=new URL("http://localhost:4723/wd/hub");

        //Driver initialization
        driver=new AndroidDriver<MobileElement>(serverURL,caps);
        wait = new WebDriverWait(driver, 5);

        // Open page
        driver.get("https://www.training-support.net/selenium");

    }

    @Test
    public void TestTodolistPage()
    {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));

        // Scroll element into view and click it
        driver.findElement(
                        MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(7).scrollIntoView(text(\"To-Do List\"))"))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.EditText")));
        WebElement todolist1= driver.findElementByClassName("android.widget.EditText");
        todolist1.sendKeys("Add tasks to list");
        driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
        todolist1.sendKeys("Get number of tasks");
        driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
        todolist1.sendKeys("Clear the list");
        driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();


        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[1]/android.widget.TextView")));
        driver.findElementByXPath("//android.widget.TextView[@text='Add tasks to list']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Get number of tasks']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Clear the list']").click();

        //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[1]/android.widget.TextView")));
        driver.findElementByClassName("android.view.View").click();

        driver.findElementByXPath("//android.widget.TextView[1]").click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
