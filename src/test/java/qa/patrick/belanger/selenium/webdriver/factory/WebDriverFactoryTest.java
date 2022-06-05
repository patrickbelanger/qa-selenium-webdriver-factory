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

package qa.patrick.belanger.selenium.webdriver.factory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import qa.patrick.belanger.selenium.webdriver.base.Driver;
import qa.patrick.belanger.selenium.webdriver.base.GridThirdParty;
import qa.patrick.belanger.selenium.webdriver.utils.OperatingSystem;

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
	
	@Test
	public void cloudBasedGrid_browserStack_shouldBeAbleToInstantiateChromeOnMacOSRemotely() {
		cloudBasedGrid_browserStack_shouldBeAbleToInstantiateChromeRemotely("OS X", "Sierra");
	}

	@Test
	public void cloudBasedGrid_browserStack_shouldBeAbleToInstantiateChromeOnWindows8Remotely() {
		cloudBasedGrid_browserStack_shouldBeAbleToInstantiateChromeRemotely("Windows", "8");
	}

	@Test
	public void cloudBasedGrid_browserStack_shouldBeAbleToInstantiateChromeOnWindowsTenRemotely() {
		cloudBasedGrid_browserStack_shouldBeAbleToInstantiateChromeRemotely("Windows", "10");
	}
	
	@Test
	public void cloudBasedGrid_browserStack_shouldBeAbleToInstantiateChromeOnWindowsElevenRemotely() {
		cloudBasedGrid_browserStack_shouldBeAbleToInstantiateChromeRemotely("Windows", "11");
	}
	
	private void cloudBasedGrid_browserStack_shouldBeAbleToInstantiateChromeRemotely(String os, String osVersion) {
		Map<String, Object> w3cCapabilities = new HashMap<>();
		w3cCapabilities.put(CapabilityType.BROWSER_NAME, "chrome");
		w3cCapabilities.put(CapabilityType.BROWSER_VERSION, "latest");
		w3cCapabilities.put("os", os);
		w3cCapabilities.put("osVersion", osVersion);
		webDriver = WebDriverFactory.getDriver(Driver.CHROME, GridThirdParty.BROWSERSTACK, w3cCapabilities);
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
