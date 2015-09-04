package com.rebtel.code;

import java.io.File;
import javax.xml.parsers.*;
import junit.framework.TestSuite;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import com.rebtel.test.TestRebtelAndroid;

public class NodeHandler extends Device{
	
	private Element root;
	
	
	public NodeHandler(String configFile) {
		try {
			File inputFile = new File(configFile);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(inputFile);
			this.root = doc.getDocumentElement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void collectDeviceInfo() {
		Node deviceNode = this.root.getElementsByTagName("device").item(0);
		Element deviceElement = (Element) deviceNode;
		
		String suite = this.root.getAttribute("suite");
		String deviceName = deviceElement.getAttribute("deviceName");
		String platformName = deviceElement.getAttribute("platformName");
		String platformVersion = deviceElement.getAttribute("platformVersion");
		String udid = deviceElement.getAttribute("udid");
		String app = deviceElement.getElementsByTagName("app").item(0).getTextContent();
		String appPackage = deviceElement.getElementsByTagName("appPackage").item(0).getTextContent();
		String appActivity = deviceElement.getElementsByTagName("appActivity").item(0).getTextContent();

		// Initialize a Device.
		super.setDevice(suite, platformName, platformVersion, udid, deviceName, app, appPackage, appActivity);
	}
	
	
	public TestSuite getSuite(String suiteCase) {
		if (suiteCase.equals("TestRebtelAndroid")) {
			return new TestSuite(TestRebtelAndroid.class);
		}
		else if (suiteCase.equals("TestRebteliOS")) {
			// return new TestSuite(TestRebteliOS.class);
		}
		
		return new TestSuite(TestRebtelAndroid.class);
	}
	
	
	public void runTest() {
		String suite = this.root.getAttribute("suite");
		junit.textui.TestRunner.run(this.getSuite(suite));
	}
	
	
	public static void main(String[] args) {
		NodeHandler n = new NodeHandler("test.config");
		n.collectDeviceInfo();
		n.runTest();
	}

}
