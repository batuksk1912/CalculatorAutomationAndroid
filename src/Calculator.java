import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calculator {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_XL_API_28"); // Android Emulator

        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");

        dc.setCapability("appPackage", "com.android.calculator2");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        AndroidDriver driver = new AndroidDriver(url, dc);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // locate the Text on the calculator by using By.name()
        WebElement seven = driver.findElementById("com.android.calculator2:id/digit_7");
        seven.click();
        WebElement plus = driver.findElementById("com.android.calculator2:id/op_add");
        plus.click();
        WebElement three = driver.findElementById("com.android.calculator2:id/digit_3");
        three.click();
        WebElement equalTo = driver.findElementById("com.android.calculator2:id/eq");
        equalTo.click();

        Thread.sleep(3000);

        // locate the edit box
        WebElement results = driver.findElementById("com.android.calculator2:id/result");

        if(results.getText().equals("10"))
        {
            System.out.println("Test Passed.");
        }
        else
        {
            System.out.println("Test Failed.");
        }
        driver.quit();
    }

}