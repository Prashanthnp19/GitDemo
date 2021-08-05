package cloud;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class utilities {
	AndroidDriver<AndroidElement> driver;
	
	public utilities(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}

	public void scroll_to_text(String name) {		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+name+"\"));");	
		
	}
	
	public double price_cal(String value) {
		value = value.substring(1);
		double amount2value = Double.parseDouble(value);
		return amount2value;
	}
}
