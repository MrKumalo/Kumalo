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

public class Win2IT {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://mrkumalo.herokuapp.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testWin2IT() throws Exception {
		selenium.open("/");
		selenium.type("id=player1", "Axel");
		selenium.type("id=player2", "Halli");
		selenium.click("css=#lobby > button.btn.btn-default");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("X: Axel".equals(selenium.getText("css=p"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		assertEquals("X: Axel", selenium.getText("css=p"));
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("O: Halli".equals(selenium.getText("css=#p2 > p"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		assertEquals("O: Halli", selenium.getText("css=#p2 > p"));
		selenium.click("id=cell2");
		selenium.click("id=cell0");
		selenium.click("id=cell1");
		selenium.click("id=cell3");
		selenium.click("id=cell4");
		selenium.click("id=cell6");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Halli has won!!".equals(selenium.getText("css=#playernames > p"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
