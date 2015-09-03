package com.rebtel.test;

import org.junit.*;
import java.net.URL;
import java.io.File;
import junit.framework.TestCase;
import com.rebtel.code.Device;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TestRebtelAndroid extends TestCase {
	
	private Device device;
	private AndroidDriver driver;
	
	@Before
	public void setUp() throws Exception {
		device = Device.device.get("TestRebtelAndroid");
		File app = new File(device.getApp());
		
		// set up appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, ""); // Should be left empty when working on an app.
		capabilities.setCapability(CapabilityType.PLATFORM, device.getPlatformName());
		capabilities.setCapability(CapabilityType.VERSION, device.getPlatformVersion());
		capabilities.setCapability("deviceName", device.getDeviceName());
		capabilities.setCapability("udid", device.getUdid());
		capabilities.setCapability("app",  app.getAbsolutePath());
		capabilities.setCapability("appPackage", device.getAppPackage());
		capabilities.setCapability("appActivity", device.getAppActivity());
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testRecentMenu() {
		
	}
	
}
