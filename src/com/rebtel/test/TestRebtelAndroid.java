package com.rebtel.test;

import org.junit.*;
import junit.framework.TestCase;
import com.rebtel.code.Device;

public class TestRebtelAndroid extends TestCase {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testRecentMenu() {
		Device device = Device.device.get("TestRebtelAndroid");
		System.out.print("info: "+device.getPlatformName());
	}
	
}
