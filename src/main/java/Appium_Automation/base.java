package Appium_Automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	public static AndroidDriver<AndroidElement> driver;
	public static AppiumDriverLocalService service;
	
	public AppiumDriverLocalService startServer() {
		boolean flag =checkIfServerIsRunning(4723);
		if(!flag) {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service;
	}
	
	public static boolean checkIfServerIsRunning(int port){
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try{
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		}catch (IOException e){
			//If control comes here, then it means that port is in use
			isServerRunning = true;
		}finally{
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	public static void StartEmulator() throws IOException, InterruptedException {
		//Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\ressource\\emulator.bat");
		Runtime.getRuntime().exec("cmd /C emulator.bat", null, new File("C:\\Users\\test\\Desktop\\"));
		Thread.sleep(7000);
	}
	
	public static void stopEmulator() throws IOException, InterruptedException {
		Thread.sleep(5000);
		Runtime.getRuntime().exec("adb emu kill");
		//Runtime.getRuntime().exec("C:\\Users\\prashant\\Desktop\\QA1.bat");		
	}

	public static AndroidDriver<AndroidElement> capabilities(String App) throws IOException, InterruptedException {
			
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);		
		
				
		
		File appDir = new File("src");
		File app = new File(appDir, (String) prop.get(App));

		DesiredCapabilities cap = new DesiredCapabilities();

		String device_name = (String) prop.get("device");
		if(device_name.contains("tes")){
			StartEmulator();
		}
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);	
		
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		cap.setCapability(AndroidMobileCapabilityType.APP_WAIT_DURATION, "20000");

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
	
	public static void screenShot(String methoderror) throws IOException {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("D:\\defects\\" + methoderror + ".png"));
	}

}
