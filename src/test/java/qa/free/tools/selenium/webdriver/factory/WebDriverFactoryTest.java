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
public class WebDriverFactoryTest {

	private WebDriver webDriver;

	@BeforeEach
	public void setUp() {
		//
	}

	@Test
	public void braveBrowser_shouldBeAbleToInstantiateChromeDriverLocally() {
		Assumptions.assumeTrue(OperatingSystem.isExecutionHostWindows()); // Only works on Windows host
		webDriver = WebDriverFactory.getDriver(Driver.BRAVE, false);
		assertNotNull(webDriver);
		assertTrue(webDriver instanceof ChromeDriver);
		webDriver.navigate().to("https://www.google.com");
		assertTrue(webDriver.getCurrentUrl().contains("google"));
	}

	@Test()
	public void braveBrowser_shouldBeAbleToInstantiateChromeDriverRemotely() {
		webDriver = WebDriverFactory.getDriver(Driver.BRAVE, true);
		assertNotNull(webDriver);
		assertTrue(webDriver instanceof RemoteWebDriver);
		assertTrue(((RemoteWebDriver) webDriver).getCapabilities().getBrowserName().equalsIgnoreCase("chrome"));
		webDriver.navigate().to("https://www.google.com");
		assertTrue(webDriver.getCurrentUrl().contains("google"));
	}

	@Test
	public void chromeBrowser_shouldBeAbleToInstantiateChromeDriverLocally() {
		webDriver = WebDriverFactory.getDriver(Driver.CHROME, false);
		assertNotNull(webDriver);
		assertTrue(webDriver instanceof ChromeDriver);
		webDriver.navigate().to("https://www.google.com");
		assertTrue(webDriver.getCurrentUrl().contains("google"));
	}

	@Test
	public void chromeBrowser_shouldBeAbleToInstantiateChromeDriverRemotely() {
		webDriver = WebDriverFactory.getDriver(Driver.CHROME, true);
		assertNotNull(webDriver);
		assertTrue(webDriver instanceof RemoteWebDriver);
		assertTrue(((RemoteWebDriver) webDriver).getCapabilities().getBrowserName().equalsIgnoreCase("chrome"));
		webDriver.navigate().to("https://www.google.com");
		assertTrue(webDriver.getCurrentUrl().contains("google"));
	}

	@Test
	public void edgeBrowser_shouldBeAbleToInstantiateEdgeDriverLocally() {
		webDriver = WebDriverFactory.getDriver(Driver.EDGE, false);
		assertNotNull(webDriver);
		assertTrue(webDriver instanceof EdgeDriver);
		webDriver.navigate().to("https://www.google.com");
		assertTrue(webDriver.getCurrentUrl().contains("google"));
	}

	@Test
	public void edgeBrowser_shouldBeAbleToInstantiateEdgeDriverRemotely() {
		webDriver = WebDriverFactory.getDriver(Driver.EDGE, true);
		assertNotNull(webDriver);
		assertTrue(webDriver instanceof RemoteWebDriver);
		assertTrue(((RemoteWebDriver) webDriver).getCapabilities().getBrowserName().equalsIgnoreCase("msedge"));
		webDriver.navigate().to("https://www.google.com");
		assertTrue(webDriver.getCurrentUrl().contains("google"));
	}
	
	@Test
	public void firefoxBrowser_shouldBeAbleToInstantiateFirefoxDriverLocally() {
		webDriver = WebDriverFactory.getDriver(Driver.FIREFOX, false);
		assertNotNull(webDriver);
		assertTrue(webDriver instanceof FirefoxDriver);
		webDriver.navigate().to("https://www.google.com");
		assertTrue(webDriver.getCurrentUrl().contains("google"));
	}

	@Test
	public void firefoxBrowser_shouldBeAbleToInstantiateFirefoxDriverRemotely() {
		webDriver = WebDriverFactory.getDriver(Driver.FIREFOX, true);
		assertNotNull(webDriver);
		assertTrue(webDriver instanceof RemoteWebDriver);
		assertTrue(((RemoteWebDriver) webDriver).getCapabilities().getBrowserName().equalsIgnoreCase("firefox"));
		webDriver.navigate().to("https://www.google.com");
		assertTrue(webDriver.getCurrentUrl().contains("google"));
	}

	@Disabled // I need to investigate further
	@Test
	public void operaBrowser_shouldBeAbleToInstantiateOperaDriverLocally() {
		Assumptions.assumeTrue(OperatingSystem.isExecutionHostWindows()); // Only works on Windows host
		webDriver = WebDriverFactory.getDriver(Driver.OPERA, false);
		assertNotNull(webDriver);
		assertTrue(webDriver instanceof ChromeDriver);
		webDriver.navigate().to("https://www.google.com");
		assertTrue(webDriver.getCurrentUrl().contains("google"));
	}
	
	@Disabled // I need to investigate further
	@Test
	public void operaBrowser_shouldBeAbleToInstantiateOperaDriverRemotely() {
		webDriver = WebDriverFactory.getDriver(Driver.OPERA, true);
		assertNotNull(webDriver);
		assertTrue(webDriver instanceof RemoteWebDriver);
		assertTrue(((RemoteWebDriver) webDriver).getCapabilities().getBrowserName().equalsIgnoreCase("opera"));
		webDriver.navigate().to("https://www.google.com");
		assertTrue(webDriver.getCurrentUrl().contains("google"));
	}
	
	@Disabled // Passed (05-06-2022) - You need a BrowserStack account to enable this test
	@Test
	public void cloudBasedGrid_browserStack_shouldBeAbleToInstantiateChromeOnMacOSRemotely() {
		cloudBasedGrid_shouldBeAbleToInstantiateChromeRemotely(GridThirdParty.BROWSERSTACK, "OS X", "Sierra");
	}

	@Disabled // Passed (05-06-2022) - You need a BrowserStack account to enable this test
	@Test
	public void cloudBasedGrid_browserStack_shouldBeAbleToInstantiateChromeOnWindows8Remotely() {
		cloudBasedGrid_shouldBeAbleToInstantiateChromeRemotely(GridThirdParty.BROWSERSTACK, "Windows", "8");
	}

	@Disabled // Passed (05-06-2022) - You need a BrowserStack account to enable this test
	@Test
	public void cloudBasedGrid_browserStack_shouldBeAbleToInstantiateChromeOnWindowsTenRemotely() {
		cloudBasedGrid_shouldBeAbleToInstantiateChromeRemotely(GridThirdParty.BROWSERSTACK, "Windows", "10");
	}

	@Disabled // Passed (05-06-2022) - You need a BrowserStack account to enable this test
	@Test
	public void cloudBasedGrid_browserStack_shouldBeAbleToInstantiateChromeOnWindowsElevenRemotely() {
		cloudBasedGrid_shouldBeAbleToInstantiateChromeRemotely(GridThirdParty.BROWSERSTACK, "Windows", "11");
	}
	
	@Disabled // Connection works, but I need to investigate
	@Test
	public void cloudBasedGrid_sauceLabs_shouldBeAbleToInstantiateChromeOnWindowsTenRemotely() {
		cloudBasedGrid_shouldBeAbleToInstantiateChromeRemotely(GridThirdParty.SAUCELABS, "Windows", "10");
	}
	
	@Disabled // Connection works, but I need to investigate
	@Test
	public void cloudBasedGrid_sauceLabs_shouldBeAbleToInstantiateChromeOnWindowsElevenRemotely() {
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
			webDriver = WebDriverFactory.getDriver(Driver.CHROME, gridThirdParty, w3cCapabilities);
		} else if (gridThirdParty.equals(GridThirdParty.SAUCELABS)) {
			String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			w3cCapabilities.put("build", String.format("WebDriverFactory integration test %s", currentDate));
			w3cCapabilities.put("name", String.format("WebDriverFactory integration test %s", currentTime));
			MutableCapabilities capabilities = WebDriverFactory.getDefaultBrowserOptions(Driver.CHROME);
			((ChromeOptions) capabilities).setPlatformName(os);
			capabilities.setCapability("platformVersion", osVersion);			
			webDriver = WebDriverFactory.getDriver(Driver.CHROME, gridThirdParty, w3cCapabilities, capabilities);
		}
		assertNotNull(webDriver);
		webDriver.navigate().to("https://www.google.com");
		assertTrue(webDriver.getCurrentUrl().contains("google"));
		webDriver.findElement(By.name("q")).sendKeys("selenium webdriver is the best" + Keys.ENTER);
	}
	
	@AfterEach
	public void tearDown() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}

}