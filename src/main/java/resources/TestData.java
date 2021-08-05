package resources;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name="InputData")
	public Object[][] getDataForEditBox() {
		Object[][] data = new Object[][] {
			{"hello"}, {"@#$%^"}
		};
		return data;
	}
}
