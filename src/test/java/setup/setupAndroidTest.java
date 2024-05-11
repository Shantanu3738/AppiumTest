package setup;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class setupAndroidTest {

    public void setupDriver(String appPath)
    {
        AppiumDriverLocalService service = new AppiumServiceBuilder().usingAnyFreePort().build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp(appPath);
        AndroidDriver driver = new AndroidDriver(service.getUrl(), options);
    }

    public static void main(String[] args) {
        new setupAndroidTest().setupDriver("D:\\Study\\MaterialLoginExample.apk");
    }
}
