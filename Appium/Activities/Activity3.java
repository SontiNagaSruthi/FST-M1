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

public class Activity3 {
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
    public void add() {
        driver.findElementById("calc_keypad_btn_05").click();
        driver.findElementById("calc_keypad_btn_add").click();
        driver.findElementById("calc_keypad_btn_09").click();
        // Perform Calculation
        driver.findElementById("calc_keypad_btn_equal").click();

        // Display Result
        String result = driver.findElementById("calc_edt_formula").getText();
        System.out.println(result);
        Assert.assertEquals(result, "14");
    }

    @Test
    public void subtract() {
        driver.findElementById("calc_keypad_btn_01").click();
        driver.findElementById("calc_keypad_btn_00").click();
        driver.findElementById("calc_keypad_btn_sub").click();
        driver.findElementById("calc_keypad_btn_05").click();
        // Perform Calculation
        driver.findElementById("calc_keypad_btn_equal").click();

        // Display Result
        String result = driver.findElementById("calc_edt_formula").getText();
        System.out.println(result);
        Assert.assertEquals(result, "5");
    }

    @Test
    public void multiply() {
        driver.findElementById("calc_keypad_btn_05").click();
        driver.findElementById("calc_keypad_btn_mul").click();
        driver.findElementById("calc_keypad_btn_01").click();
        driver.findElementById("calc_keypad_btn_00").click();
        driver.findElementById("calc_keypad_btn_00").click();
        // Perform Calculation
        driver.findElementById("calc_keypad_btn_equal").click();

        // Display Result
        String result = driver.findElementById("calc_edt_formula").getText();
        System.out.println(result);
        Assert.assertEquals(result, "500");
    }

    @Test
    public void divide() {
        driver.findElementById("calc_keypad_btn_05").click();
        driver.findElementById("calc_keypad_btn_00").click();
        driver.findElementById("calc_keypad_btn_div").click();
        driver.findElementById("calc_keypad_btn_02").click();
        // Perform Calculation
        driver.findElementById("calc_keypad_btn_equal").click();

        // Display Result
        String result = driver.findElementById("calc_edt_formula").getText();
        System.out.println(result);
        Assert.assertEquals(result, "25");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
