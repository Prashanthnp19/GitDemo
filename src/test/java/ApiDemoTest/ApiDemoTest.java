package ApiDemoTest;

import java.io.IOException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ApiDemoTest extends base{

	public static void main(String[] args) throws IOException {
		
		AndroidDriver<AndroidElement> driver = capabilities("ApiDemosApp");
		
		HomeScreen home= new HomeScreen(driver);		
		home.Preferences.click();
		
		
		Preferences pref = new Preferences(driver);
		pref.Dependencies.click();
		
		Pref_Dependencies pref_depend = new Pref_Dependencies(driver);
		pref_depend.wifi_Checkbox.click();
		pref_depend.wifi_setting.click();
		pref_depend.wifi_name.sendKeys("Prashanth");
		pref_depend.wifi_Submit.get(1).click();	
		
		
	}

}
