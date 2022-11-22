package examples;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("deviceId","RZ8N91WNQYW");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.sec.android.app.popupcalculator");
        caps.setCapability("appActivity",".Calculator");
        caps.setCapability("noReset",true);

        //Appium server URL
        URL serverURL=new URL("http://localhost:4723/wd/hub");

        //Driver initialization
        driver=new AndroidDriver<MobileElement>(serverURL,caps);

    }

    @Test
    public void additionTest()
    {
        driver.findElementById("calc_keypad_btn_03").click();
        driver.findElementByAccessibilityId("Multiplication").click();
        driver.findElementById("calc_keypad_btn_05").click();
        driver.findElementByAccessibilityId("Equal").click();
        String result= driver.findElementById("calc_edt_formula").getText();
        System.out.println("result is "+ result);

        Assert.assertEquals(result,"15");
    }

    @AfterClass
    public void tearDown()
    {

        driver.quit();
    }
}
