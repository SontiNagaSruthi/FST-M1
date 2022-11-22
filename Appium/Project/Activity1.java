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
import java.util.List;

public class Activity1 {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("deviceId","RZ8N91WNQYW");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.google.android.apps.tasks");
        caps.setCapability("appActivity",".ui.TaskListsActivity");
        caps.setCapability("noReset",true);

        //Appium server URL
        URL serverURL=new URL("http://localhost:4723/wd/hub");

        //Driver initialization
        driver=new AndroidDriver<MobileElement>(serverURL,caps);
        wait = new WebDriverWait(driver, 5);

    }

    @Test
    public void TaskAddition()
    {

        driver.findElementByAccessibilityId("Create new task").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.className("android.widget.EditText")));
        WebElement task1= driver.findElementByClassName("android.widget.EditText");
        task1.sendKeys("Complete Activity with Google Tasks");
        driver.findElementById("add_task_done").click();
        driver.findElementByAccessibilityId("Create new task").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.className("android.widget.EditText")));
        WebElement task2= driver.findElementByClassName("android.widget.EditText");
        task2.sendKeys("Complete Activity with Google Keep");
        driver.findElementById("add_task_done").click();
        driver.findElementByAccessibilityId("Create new task").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.className("android.widget.EditText")));
        WebElement task3= driver.findElementByClassName("android.widget.EditText");
        task3.sendKeys("Complete the second Activity Google Keep");
        driver.findElementById("add_task_done").click();

        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.className("android.widget.TextView")));
        List<MobileElement> TaskList=driver.findElementsById("task_name");

        for(WebElement e: TaskList)
        {
            String taskname=e.getText();
            if(taskname.equalsIgnoreCase("Complete Activity with Google Tasks")||taskname.equalsIgnoreCase("Complete Activity with Google Keep")||taskname.equalsIgnoreCase("Complete the second Activity Google Keep"))
            {
                Assert.assertTrue(true,"All the tasks are present in the list");
            }
        }
        int allTasks=TaskList.size();


        Assert.assertEquals(allTasks,3,"all the added tasks are displayed successfully");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
