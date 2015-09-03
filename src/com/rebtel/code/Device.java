package com.rebtel.code;

import java.util.Map;
import java.util.HashMap;

public class Device {
	
	public static Map<String, Device> device;
	private String _platformName;
	private String _platformVersion;
	private String _udid;
	private String _deviceName;
	private String _app;
	private String _appPackage;
	private String _appActivity;
	
	
	public Device() {	}
	
	
	public Device(String platformName, String platformVersion, String udid, String deviceName, String app, String appPackage, String appActivity) {
			this._platformName = platformName;
			this._platformVersion = platformVersion;
			this._udid = udid;
			this._deviceName = deviceName;
			this._app = app;
			this._appPackage = appPackage;
			this._appActivity = appActivity;
	}
	
	
	public void setDevice(String suite, String platformName, String platformVersion, String udid, String deviceName, String app, String appPackage, String appActivity) {
		Device.device = new HashMap<String, Device>();
		Device.device.put(suite, new Device(platformName, platformVersion, udid, deviceName, app, appPackage, appActivity));		
	}
	
	
	public Device getDevice(String suite) {
		return Device.device.get(suite);
	}
	
	
	public String getPlatformName() {
		return this._platformName;
	}
	
	
	public String getPlatformVersion() {
		return this._platformVersion;
	}
	
	
	public String getUdid() {
		return this._udid;
	}
	
	
	public String getDeviceName() {
		return this._deviceName;
	}
	
	
	public String getApp() {
		return this._app;
	}
	
	
	public String getAppPackage() {
		return this._appPackage;
	}
	
	
	public String getAppActivity() {
		return this._appActivity;
	}

}
