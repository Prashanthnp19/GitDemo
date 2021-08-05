package ApiDemoTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Pref_Dependencies {
	
	public Pref_Dependencies(AppiumDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(className = "android.widget.CheckBox")
	public WebElement wifi_Checkbox;
	
	@AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
	public WebElement wifi_setting;
	
	@AndroidFindBy(id = "android:id/edit")
	public WebElement wifi_name;
	
	@AndroidFindBy(className = "android.widget.Button")
	public List<WebElement> wifi_Submit;
	
}
