package qa.free.tools.selenium.webdriver.factory.drivers.desktops;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import qa.free.tools.selenium.webdriver.factory.drivers.desktop.Brave;

class OperaTest {
	
	private Brave underTest;
	
	@BeforeEach
	public void setUp() {
		underTest = new Brave();
	}
	
	@Test
	void chrome_assertDefaultChromeOptions() {
		assertEquals("chrome", underTest.getOptions().getBrowserName());
	}
	
	@Test
	void chrome_assertGetW3cCapabilitiesMethod() {
		assertInstanceOf(Map.class, underTest.getW3cCapabilities());
	}
	
	@Test
	void chrome_getWebDriver() {
		WebDriver webDriver = underTest.getWebDriver();
		assertInstanceOf(ChromeDriver.class, webDriver);
		webDriver.quit();
	}
	
	@AfterEach
	public void tearDown() {
		underTest = null;
	}
	
}
