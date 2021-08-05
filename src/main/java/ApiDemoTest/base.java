package ApiDemoTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {

	public static AndroidDriver<AndroidElement> capabilities(String App) throws IOException {
			
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Appium_Automation\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);		
		
		AndroidDriver<AndroidElement> driver;		
		
		File appDir = new File("src");
		File app = new File(appDir, (String) prop.get(App));

		DesiredCapabilities cap = new DesiredCapabilities();

		String device_name = (String) prop.get("device");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
		
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		cap.setCapability(AndroidMobileCapabilityType.APP_WAIT_DURATION, "20000");

		driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

}
