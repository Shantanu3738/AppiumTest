package setup;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class setupAndroidTest {

    public AndroidDriver setupDriver(String appPath)
    {
        AppiumDriverLocalService service = new AppiumServiceBuilder().usingAnyFreePort().build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp(appPath);
        AndroidDriver driver = new AndroidDriver(service.getUrl(), options);
        return driver;
    }

    public static void main(String[] args) {
       AndroidDriver driver = new setupAndroidTest().setupDriver("D:\\Study\\MaterialLoginExample.apk");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       driver.findElement(AppiumBy.id("android:id/button1")).click();
       driver.findElement(AppiumBy.id("com.sourcey.materialloginexample:id/input_email")).sendKeys("abcd@gmail.com");

       driver.findElement(AppiumBy.id("com.sourcey.materialloginexample:id/input_password")).sendKeys("abcdefghi");
       driver.findElement(AppiumBy.id("com.sourcey.materialloginexample:id/btn_login")).click();
       wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.sourcey.materialloginexample:id/action_bar")));

    }
}
