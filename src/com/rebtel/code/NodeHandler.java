package com.rebtel.code;

import com.rebtel.test.TestRebtelAndroid;

public class NodeHandler {
	
	public NodeHandler(String configFile) {
		// ToDo:
	}
	
	public void collectDeviceInfo() {
		// ToDo:
	}
	
	public Class getSuite(String suiteCase) {
		if (suiteCase == "TestRebtelAndroid") {
			return TestRebtelAndroid.class;
		}
		else if (suiteCase == "TestRebteliOS") {
			// return TestRebteliOS.class;
		}
		
		return TestRebtelAndroid.class;
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
