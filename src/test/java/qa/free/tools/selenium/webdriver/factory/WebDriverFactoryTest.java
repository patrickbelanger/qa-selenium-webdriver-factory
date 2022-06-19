// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package qa.free.tools.selenium.webdriver.factory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import qa.free.tools.selenium.webdriver.base.Driver;
import qa.free.tools.selenium.webdriver.base.GridThirdParty;
import qa.free.tools.selenium.webdriver.utils.OperatingSystem;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
class WebDriverFactoryTest {

	private WebDriver underTest;

	@BeforeEach
	public void setUp() {
		//
	}

	@Test
	void braveBrowser_shouldBeAbleToInstantiateChromeDriverLocally() {
		Assumptions.assumeTrue(OperatingSystem.isExecutionHostWindows()); // Only works on Windows host
		underTest = WebDriverFactory.getDriver(Driver.BRAVE, false);
		assertNotNull(underTest);
		assertTrue(underTest instanceof ChromeDriver);
		underTest.navigate().to("https://www.google.com");
		assertTrue(underTest.getCurrentUrl().contains("google"));
	}

	@Test()
	void braveBrowser_shouldBeAbleToInstantiateChromeDriverRemotely() {
		underTest = WebDriverFactory.getDriver(Driver.BRAVE, true);
		assertNotNull(underTest);
		assertTrue(underTest instanceof RemoteWebDriver);
		assertTrue(((RemoteWebDriver) underTest).getCapabilities().getBrowserName().equalsIgnoreCase("chrome"));
		underTest.navigate().to("https://www.google.com");
		assertTrue(underTest.getCurrentUrl().contains("google"));
	}

	@Test
	void chromeBrowser_shouldBeAbleToInstantiateChromeDriverLocally() {
		underTest = WebDriverFactory.getDriver(Driver.CHROME, false);
		assertNotNull(underTest);
		assertTrue(underTest instanceof ChromeDriver);
		underTest.navigate().to("https://www.google.com");
		assertTrue(underTest.getCurrentUrl().contains("google"));
	}

	@Test
	void chromeBrowser_shouldBeAbleToInstantiateChromeDriverRemotely() {
		underTest = WebDriverFactory.getDriver(Driver.CHROME, true);
		assertNotNull(underTest);
		assertTrue(underTest instanceof RemoteWebDriver);
		assertTrue(((RemoteWebDriver) underTest).getCapabilities().getBrowserName().equalsIgnoreCase("chrome"));
		underTest.navigate().to("https://www.google.com");
		assertTrue(underTest.getCurrentUrl().contains("google"));
	}

	@Test
	void edgeBrowser_shouldBeAbleToInstantiateEdgeDriverLocally() {
		underTest = WebDriverFactory.getDriver(Driver.EDGE, false);
		assertNotNull(underTest);
		assertTrue(underTest instanceof EdgeDriver);
		underTest.navigate().to("https://www.google.com");
		assertTrue(underTest.getCurrentUrl().contains("google"));
	}

	@Test
	void edgeBrowser_shouldBeAbleToInstantiateEdgeDriverRemotely() {
		underTest = WebDriverFactory.getDriver(Driver.EDGE, true);
		assertNotNull(underTest);
		assertTrue(underTest instanceof RemoteWebDriver);
		assertTrue(((RemoteWebDriver) underTest).getCapabilities().getBrowserName().equalsIgnoreCase("msedge"));
		underTest.navigate().to("https://www.google.com");
		assertTrue(underTest.getCurrentUrl().contains("google"));
	}
	
	@Test
	void firefoxBrowser_shouldBeAbleToInstantiateFirefoxDriverLocally() {
		underTest = WebDriverFactory.getDriver(Driver.FIREFOX, false);
		assertNotNull(underTest);
		assertTrue(underTest instanceof FirefoxDriver);
		underTest.navigate().to("https://www.google.com");
		assertTrue(underTest.getCurrentUrl().contains("google"));
	}

	@Test
	void firefoxBrowser_shouldBeAbleToInstantiateFirefoxDriverRemotely() {
		underTest = WebDriverFactory.getDriver(Driver.FIREFOX, true);
		assertNotNull(underTest);
		assertTrue(underTest instanceof RemoteWebDriver);
		assertTrue(((RemoteWebDriver) underTest).getCapabilities().getBrowserName().equalsIgnoreCase("firefox"));
		underTest.navigate().to("https://www.google.com");
		assertTrue(underTest.getCurrentUrl().contains("google"));
	}

	@Disabled("Deprecated - This test needs to be updated since Opera uses ChromeDriver now")
	@Test
	void operaBrowser_shouldBeAbleToInstantiateOperaDriverLocally() {
		Assumptions.assumeTrue(OperatingSystem.isExecutionHostWindows()); // Only works on Windows host
		underTest = WebDriverFactory.getDriver(Driver.OPERA, false);
		assertNotNull(underTest);
		assertTrue(underTest instanceof ChromeDriver);
		underTest.navigate().to("https://www.google.com");
		assertTrue(underTest.getCurrentUrl().contains("google"));
	}
	
	@Disabled("Deprecated - This test needs to be updated since Opera uses ChromeDriver now")
	@Test
	void operaBrowser_shouldBeAbleToInstantiateOperaDriverRemotely() {
		underTest = WebDriverFactory.getDriver(Driver.OPERA, true);
		assertNotNull(underTest);
		assertTrue(underTest instanceof RemoteWebDriver);
		assertTrue(((RemoteWebDriver) underTest).getCapabilities().getBrowserName().equalsIgnoreCase("opera"));
		underTest.navigate().to("https://www.google.com");
		assertTrue(underTest.getCurrentUrl().contains("google"));
	}
	
	@Disabled("Passed (05-06-2022) - You need a BrowserStack account to enable this test")
	@Test
	void cloudBasedGrid_browserStack_shouldBeAbleToInstantiateChromeOnMacOSRemotely() {
		cloudBasedGrid_shouldBeAbleToInstantiateChromeRemotely(GridThirdParty.BROWSERSTACK, "OS X", "Sierra");
	}

	@Disabled("Passed (05-06-2022) - You need a BrowserStack account to enable this test")
	@Test
	void cloudBasedGrid_browserStack_shouldBeAbleToInstantiateChromeOnWindows8Remotely() {
		cloudBasedGrid_shouldBeAbleToInstantiateChromeRemotely(GridThirdParty.BROWSERSTACK, "Windows", "8");
	}

	@Disabled("Passed (05-06-2022) - You need a BrowserStack account to enable this test")
	@Test
	void cloudBasedGrid_browserStack_shouldBeAbleToInstantiateChromeOnWindowsTenRemotely() {
		cloudBasedGrid_shouldBeAbleToInstantiateChromeRemotely(GridThirdParty.BROWSERSTACK, "Windows", "10");
	}

	@Disabled("Passed (05-06-2022) - You need a BrowserStack account to enable this test")
	@Test
	void cloudBasedGrid_browserStack_shouldBeAbleToInstantiateChromeOnWindowsElevenRemotely() {
		cloudBasedGrid_shouldBeAbleToInstantiateChromeRemotely(GridThirdParty.BROWSERSTACK, "Windows", "11");
	}
	
	@Disabled("Connection works, but I need to investigate")
	@Test
	void cloudBasedGrid_sauceLabs_shouldBeAbleToInstantiateChromeOnWindowsTenRemotely() {
		cloudBasedGrid_shouldBeAbleToInstantiateChromeRemotely(GridThirdParty.SAUCELABS, "Windows", "10");
	}
	
	@Disabled("Connection works, but I need to investigate")
	@Test
	void cloudBasedGrid_sauceLabs_shouldBeAbleToInstantiateChromeOnWindowsElevenRemotely() {
		cloudBasedGrid_shouldBeAbleToInstantiateChromeRemotely(GridThirdParty.SAUCELABS, "Windows", "11");
	}
	
	private void cloudBasedGrid_shouldBeAbleToInstantiateChromeRemotely(GridThirdParty gridThirdParty, 
			String os, String osVersion) {
		Map<String, Object> w3cCapabilities = new HashMap<>();
		w3cCapabilities.put(CapabilityType.BROWSER_NAME, "chrome");
		w3cCapabilities.put(CapabilityType.BROWSER_VERSION, "latest");
		if (gridThirdParty.equals(GridThirdParty.BROWSERSTACK)) {
			w3cCapabilities.put("os", os);
			w3cCapabilities.put("osVersion", osVersion);
			underTest = WebDriverFactory.getDriver(Driver.CHROME, gridThirdParty, w3cCapabilities);
		} else if (gridThirdParty.equals(GridThirdParty.SAUCELABS)) {
			String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			w3cCapabilities.put("build", String.format("WebDriverFactory integration test %s", currentDate));
			w3cCapabilities.put("name", String.format("WebDriverFactory integration test %s", currentTime));
			MutableCapabilities capabilities = WebDriverFactory.getDefaultBrowserOptions(Driver.CHROME);
			((ChromeOptions) capabilities).setPlatformName(os);
			capabilities.setCapability("platformVersion", osVersion);			
			underTest = WebDriverFactory.getDriver(Driver.CHROME, gridThirdParty, w3cCapabilities, capabilities);
		}
		assertNotNull(underTest);
		underTest.navigate().to("https://www.google.com");
		assertTrue(underTest.getCurrentUrl().contains("google"));
		underTest.findElement(By.name("q")).sendKeys("selenium webdriver is the best" + Keys.ENTER);
	}
	
	@AfterEach
	public void tearDown() {
		if (underTest != null) {
			underTest.quit();
		}
	}

}
