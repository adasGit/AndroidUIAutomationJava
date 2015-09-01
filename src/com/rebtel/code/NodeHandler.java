package com.rebtel.code;

import junit.framework.TestSuite;
import com.rebtel.test.TestRebtelAndroid;

public class NodeHandler {
	
	public NodeHandler(String configFile) {
		// ToDo:
	}
	
	public void collectDeviceInfo() {
		// ToDo:
	}
	
	public TestSuite getSuite(String suiteCase) {
		if (suiteCase == "TestRebtelAndroid") {
			return new TestSuite(TestRebtelAndroid.class);
		}
		else if (suiteCase == "TestRebteliOS") {
			// return new TestSuite(TestRebteliOS.class);
		}
		
		return new TestSuite(TestRebtelAndroid.class);
	}
	
	public void runTest() {
		junit.textui.TestRunner.run(this.getSuite("TestRebtelAndroid"));
	}
	
	public static void main(String[] args) {
		NodeHandler n = new NodeHandler("../test.config");
		n.collectDeviceInfo();
		n.runTest();
	}

}
