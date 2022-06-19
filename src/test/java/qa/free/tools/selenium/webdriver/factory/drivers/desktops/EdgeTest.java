package qa.free.tools.selenium.webdriver.factory.drivers.desktops;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import qa.free.tools.selenium.webdriver.factory.drivers.desktop.Edge;

class EdgeTest {
	
	private Edge underTest;
	
	@BeforeEach
	public void setUp() {
		underTest = new Edge();
	}
	
	@Test
	void edge_assertDefaultEdgeOptions() {
		assertEquals("MicrosoftEdge", underTest.getOptions().getBrowserName());
	}
	
	@Test
	void edge_assertGetW3cCapabilitiesMethod() {
		assertInstanceOf(Map.class, underTest.getW3cCapabilities());
	}
	
	@Test
	void edge_getWebDriver() {
		WebDriver webDriver = underTest.getWebDriver();
		assertInstanceOf(EdgeDriver.class, webDriver);
		webDriver.quit();
	}
	
	@AfterEach
	public void tearDown() {
		underTest = null;
	}
	
}
