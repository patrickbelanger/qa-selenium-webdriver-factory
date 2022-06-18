package qa.free.tools.selenium.webdriver.base;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class GridThirdPartyTest {
	
	@Test
	void seleniumGrid_assertGridThirdPartyProperties() {
		assertNull(GridThirdParty.SELENIUM_GRID.getThirdPartyName());
		assertNull(GridThirdParty.SELENIUM_GRID.getClassName());
	}
	
	@Test
	void browserStack_assertGridThirdPartyProperties() {
		assertEquals("BrowserStack", GridThirdParty.BROWSERSTACK.getThirdPartyName());
		assertEquals(".drivers.cloud.BrowserStack", GridThirdParty.BROWSERSTACK.getClassName());
	}
	
	@Test
	void sauceLabs_assertGridThirdPartyProperties() {
		assertEquals("SauceLabs", GridThirdParty.SAUCELABS.getThirdPartyName());
		assertEquals(".drivers.cloud.SauceLabs", GridThirdParty.SAUCELABS.getClassName());
	}
	
}
