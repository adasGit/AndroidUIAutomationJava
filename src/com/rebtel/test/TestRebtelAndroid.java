package com.rebtel.test;

import org.junit.*;
import junit.framework.TestCase;
import com.rebtel.code.Device;

public class TestRebtelAndroid extends TestCase {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Device d = new Device();
		Device device = d.getDevice("TestRebtelAndroid");
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
		
	}
	
}
