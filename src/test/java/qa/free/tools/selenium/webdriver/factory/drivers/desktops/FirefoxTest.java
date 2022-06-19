package qa.free.tools.selenium.webdriver.factory.drivers.desktops;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import qa.free.tools.selenium.webdriver.factory.drivers.desktop.Firefox;

class FirefoxTest {
	
	private Firefox underTest;
	
	@BeforeEach
	public void setUp() {
		underTest = new Firefox();
	}
	
	@Test
	void firefox_assertDefaultFirefoxOptions() {
		assertEquals("firefox", underTest.getOptions().getBrowserName());
	}
	
	@Test
	void firefox_assertGetW3cCapabilitiesMethod() {
		assertNull(underTest.getW3cCapabilities());
	}
	
	@Test
	void firefox_getWebDriver() {
		WebDriver webDriver = underTest.getWebDriver();
		assertInstanceOf(FirefoxDriver.class, webDriver);
		webDriver.quit();
	}
	
	@AfterEach
	public void tearDown() {
		underTest = null;
	}
	
}
