package qa.free.tools.selenium.webdriver.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DriverTest {
	
	@Test
	void brave_assertBrowserProperties() {
		assertEquals("Brave", Driver.BRAVE.getBrowserName());
		assertEquals(".drivers.desktop.Brave", Driver.BRAVE.getClassName());
		assertEquals(".drivers.options.Chrome", Driver.BRAVE.getOptionsClassName());
		assertEquals("webdriver.chrome.driver", Driver.BRAVE.getProperty());
		assertEquals("chromedriver.exe", Driver.BRAVE.getExecutable());
	}
	
	@Test
	void chrome_assertBrowserProperties() {
		assertEquals("Chrome", Driver.CHROME.getBrowserName());
		assertEquals(".drivers.desktop.Chrome", Driver.CHROME.getClassName());
		assertEquals(".drivers.options.Chrome", Driver.CHROME.getOptionsClassName());
		assertEquals("webdriver.chrome.driver", Driver.CHROME.getProperty());
		assertEquals("chromedriver.exe", Driver.CHROME.getExecutable());
	}
	
	@Test
	void edge_assertBrowserProperties() {
		assertEquals("Edge", Driver.EDGE.getBrowserName());
		assertEquals(".drivers.desktop.Edge", Driver.EDGE.getClassName());
		assertEquals(".drivers.options.Edge", Driver.EDGE.getOptionsClassName());
		assertEquals("webdriver.edge.driver", Driver.EDGE.getProperty());
		assertEquals("msedgedriver.exe", Driver.EDGE.getExecutable());
	}
	
	@Test
	void firefox_assertBrowserProperties() {
		assertEquals("Firefox", Driver.FIREFOX.getBrowserName());
		assertEquals(".drivers.desktop.Firefox", Driver.FIREFOX.getClassName());
		assertEquals(".drivers.options.Firefox", Driver.FIREFOX.getOptionsClassName());
		assertEquals("webdriver.gecko.driver", Driver.FIREFOX.getProperty());
		assertEquals("geckodriver.exe", Driver.FIREFOX.getExecutable());
	}
	
	@Test
	void opera_assertBrowserProperties() {
		assertEquals("Opera", Driver.OPERA.getBrowserName());
		assertEquals(".drivers.desktop.Opera", Driver.OPERA.getClassName());
		assertEquals(".drivers.options.Chrome", Driver.OPERA.getOptionsClassName());
		assertEquals("webdriver.chrome.driver", Driver.OPERA.getProperty());
		assertEquals("chromedriver.exe", Driver.OPERA.getExecutable());
	}
	
}
