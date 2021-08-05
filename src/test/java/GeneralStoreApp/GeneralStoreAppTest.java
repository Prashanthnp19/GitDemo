package GeneralStoreApp;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Appium_Automation.utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class GeneralStoreAppTest extends base {

	static AndroidDriver<AndroidElement> driver;
		@Test
		public void homeScreenTest() throws IOException {
		driver = capabilities("GeneralStoreApp");
		
		FormPage form = new FormPage(driver);
		utilities util = new utilities(driver);
		
		
		form.countryName().click();
		util.scroll_to_text("Aruba");
		form.CountrySelect.click();
		form.getName().sendKeys("Prashanth");
		driver.hideKeyboard();
		form.FemaleOption.get(1).click();
		form.Next.click();
		
		products prod = new products(driver);
		prod.product_select.get(0).click();
		prod.product_select.get(0).click();
		prod.Add_to_cart.click();
		
		CheckoutPage checkOut = new CheckoutPage(driver);

		int count = checkOut.productPrice.size();
		double sum = 0;
		
		for (int i = 0; i < count; i++) {
			String price = checkOut.productPrice.get(i).getText();
			double prod_price = util.price_cal(price);
			sum = sum + prod_price;
		}
		System.out.println("Price of selected products: " + sum);

		String totalamount = checkOut.TotalAmount.getText();
		double Actual_total = util.price_cal(totalamount);
		System.out.println("Price of total : " + Actual_total);

		Assert.assertEquals(Actual_total, sum);
		System.out.println("success");
	}
}