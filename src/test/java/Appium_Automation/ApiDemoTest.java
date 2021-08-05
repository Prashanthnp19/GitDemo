package Appium_Automation;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import resources.TestData;

public class ApiDemoTest extends base {

	@Test(dataProvider="InputData", dataProviderClass=TestData.class)
	public void ApiDemosApp(String inputData) throws IOException, InterruptedException {
		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("ApiDemosApp");

		HomeScreen home = new HomeScreen(driver);
		home.Preferences.click();

		Preferences pref = new Preferences(driver);
		pref.Dependencies.click();

		Pref_Dependencies pref_depend = new Pref_Dependencies(driver);
		pref_depend.wifi_Checkbox.click();
		pref_depend.wifi_setting.click();
		pref_depend.wifi_name.sendKeys(inputData);
		pref_depend.wifi_Submit.get(1).click();
		service.stop();

	}

	@AfterSuite
	public void closeEmulator() throws IOException, InterruptedException {
		stopEmulator();
	}
}
