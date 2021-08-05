package GeneralStoreApp;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	public FormPage(AppiumDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement name;
	
	@AndroidFindBy(className="android.widget.RadioButton")
	public List<WebElement> FemaleOption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countryList;
	
	@AndroidFindBy(xpath="//*[@text='Aruba']")
	public WebElement CountrySelect;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement Next;
	
	
	public WebElement getName() {
		System.out.println(">>>>>>>>>Entering the name");
		return name;
	}
	
	public WebElement countryName() {
		System.out.println(">>>>>>>>>Selecting the country name");
		return countryList;
	}
	
	
}
