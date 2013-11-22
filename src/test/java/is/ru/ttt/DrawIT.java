package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class DrawIT {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://kumalostaging.herokuapp.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testDrawIT() throws Exception {
		selenium.open("/");
		selenium.type("id=player1", "Axel");
		selenium.type("id=player2", "Halli");
		selenium.click("css=#lobby > button.btn.btn-default");
		Thread.sleep(1000);
		selenium.click("id=cell2");
		Thread.sleep(1000);
		selenium.click("id=cell8");
		Thread.sleep(1000);
		selenium.click("id=cell0");
		Thread.sleep(1000);
		selenium.click("id=cell1");
		Thread.sleep(1000);
		selenium.click("id=cell5");
		Thread.sleep(1000);
		selenium.click("id=cell3");
		Thread.sleep(1000);
		selenium.click("id=cell4");
		Thread.sleep(1000);
		selenium.click("id=cell6");
		Thread.sleep(1000);
		selenium.click("id=cell7");
		Thread.sleep(1000);
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Draw!".equals(selenium.getText("css=p.red"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		assertEquals("Draw!", selenium.getText("css=p.red"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
