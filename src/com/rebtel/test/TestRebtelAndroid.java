package com.rebtel.test;

import org.junit.*;

import java.net.URL;
import java.io.File;
import java.util.List;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import com.rebtel.code.Device;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.TouchAction;

public class TestRebtelAndroid extends TestCase {
	
	private Device device;
	private AndroidDriver driver;
	private TouchAction ta;
	private WebElement el, el0, el1;
	
	
	public void sleep(int s) {
		try {
			TimeUnit.SECONDS.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void logIn() throws Exception {
		el = driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.rebtel.android:id/loginFlowButton']"));
		el.click();
		sleep(3);
		el = driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='com.rebtel.android:id/countrySpinner']"));
		el.click();
		sleep(3);
		el0 = driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina (+54)']"));
		el1 = driver.findElement(By.xpath("//android.widget.TextView[@text='Ascension (+247)']"));
		ta.press(el0).moveTo(el1).release();
		sleep(3);
		el = driver.findElement(By.xpath("//android.widget.TextView[@text='Bangladesh (+880)']"));
		el.click();
		sleep(3);
		el = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.rebtel.android:id/loginPhoneNumber']"));
		el.sendKeys("1713185052");
		el = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.rebtel.android:id/loginEnterPin']"));
		el.sendKeys("3987");
		el = driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.rebtel.android:id/btnLoginFragmentNext']"));
		el.click();
		sleep(10);
	}
	
	
	public void logOut() throws Exception {
		el = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']"));
		el.click();
		sleep(3);
		el = driver.findElement(By.xpath("//android.widget.TextView[@text='Account']"));
		el.click();
		sleep(3);
		el = driver.findElement(By.xpath("//android.widget.TextView[@text='Log Out']"));
		el.click();
		sleep(3);
		el = driver.findElement(By.xpath("//android.widget.Button[@text='OK']"));
		el.click();
	}
	
	
	public void nevigateTo(String label) throws Exception {
		el = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']"));
		el.click();
		sleep(3);
		el = driver.findElement(By.xpath("//android.widget.TextView[@text='"+ label +"']"));
		el.click();
		sleep(3);
	}
	
	
	public void dialDigit(String digit) throws Exception {
		el = driver.findElement(By.xpath("//android.widget.TextView[@text='"+ digit +"']"));
		el.click();
	}
	
	
	@Before
	public void setUp() throws Exception {
		device = Device.device.get("TestRebtelAndroid");
		File app = new File(device.getApp());
		
		// Setting up device ...
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, ""); // Should be left empty when working on an app.
		capabilities.setCapability(CapabilityType.PLATFORM, device.getPlatformName());
		capabilities.setCapability(CapabilityType.VERSION, device.getPlatformVersion());
		capabilities.setCapability("deviceName", device.getDeviceName());
		capabilities.setCapability("udid", device.getUdid());
		capabilities.setCapability("app",  app.getAbsolutePath());
		capabilities.setCapability("appPackage", device.getAppPackage());
		capabilities.setCapability("appActivity", device.getAppActivity());
		
		// Connect to Rebtel ...
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	
	@After
	public void tearDown() throws Exception {
		// Shutting down Rebtel ...
		driver.quit();
	}
	
	
	@Test
	public void testRecentMenu() throws Exception {
		// Log in ...
		this.logIn();
		
		this.nevigateTo("Dial Pad");
		
		// Dial a phone number ...
		List<String> digits = Arrays.asList("0", "1", "7", "1", "7", "3", "7", "9", "4", "8", "0");
		for (String each : digits) {
			this.dialDigit(each);
		}
		
		// Make a Call ...
		el = driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.rebtel.android:id/button14']"));
		el.click();
		sleep(1);
		el = driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.rebtel.android:id/next_button']"));
		el.click();
		sleep(1);
		
		// Hang up ...
		el = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.rebtel.android:id/hangupButton']"));
		el.click();
		sleep(3);
		
		this.nevigateTo("Recent");
		
		String phoneNumber;
		try {
			el = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.rebtel.android:id/phoneNumber']"));
			phoneNumber = el.getText();
			
		}catch (Exception e) {
			phoneNumber = null;
		}
		
		// Verify the call in Recent menu ...
		this.assertEquals("Dialed phone number doesn't exist in the Recent menu!", "+8801717379480", phoneNumber);
		
		// Log out ...
		this.logOut();
	}
	
}
