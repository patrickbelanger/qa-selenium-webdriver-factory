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

package qa.patrick.belanger.selenium.webdriver.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.patrick.belanger.selenium.webdriver.utils.OperatingSystem;

/**
 * List of supported WebDrivers
 * 
 * BRAVE (through ChromeDriver)
 * CHROME
 * EDGE
 * FIREFOX
 * OPERA (through ChromeDriver since OperaDriver has been deprecated)
 * 
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public enum Driver {

	/**
	 * Brave Browser Remark: Binary location needs to be specified in
	 * webdriver.properties file. (This browser uses ChromeDriver)
	 */
	BRAVE("Brave", ".drivers.desktop.Brave", ".drivers.options.Chrome", "webdriver.chrome.driver", 
			"chromedriver.exe", "chromedriver"),
	CHROME("Chrome", ".drivers.desktop.Chrome", ".drivers.options.Chrome", "webdriver.chrome.driver", 
			"chromedriver.exe", "chromedriver"),
	EDGE("Edge", ".drivers.desktop.Edge", ".drivers.options.Edge", "webdriver.edge.driver", 
			"msedgedriver.exe", "msedgedriver"),
	FIREFOX("firefox", ".drivers.desktop.Firefox", ".drivers.options.Firefox", "webdriver.gecko.driver", 
			"geckodriver.exe", "geckodriver"),
	/**
	 * Opera Browser Remark: Binary location needs to be specified in
	 * webdriver.properties file. (This browser uses ChromeDriver)
	 */
	OPERA("Opera", ".drivers.desktop.Opera", ".drivers.options.Chrome", "webdriver.opera.driver", 
			"operadriver.exe", "operadriver"),
	;

	@Getter
	@Setter(AccessLevel.PRIVATE)
	String browserName;

	/**
	 * Get/set class name (including part of the package as prefix)
	 */
	@Getter
	@Setter(AccessLevel.PRIVATE)
	private String className;

	/**
	 * Get/set browser options class name (including part of the package as prefix)
	 */
	@Getter
	@Setter(AccessLevel.PRIVATE)
	private String optionsClassName;
	
	/**
	 * Get/set system property for this webdriver
	 */
	@Getter
	@Setter(AccessLevel.PRIVATE)
	private String property;

	/**
	 * Get/set driver executable for Windows-based platform (Arm64, x64, x86)
	 */
	@Getter(AccessLevel.PRIVATE)
	@Setter(AccessLevel.PRIVATE)
	String executableWindowsArm64;

	/**
	 * Get/set driver executable for Unix-based platform (including MacOS)
	 */
	@Getter(AccessLevel.PRIVATE)
	@Setter(AccessLevel.PRIVATE)
	String executableUnix;

	/**
	 * Get/set driver executable for Windows (Arm64, x64, x86)
	 */
	@Getter
	@Setter(AccessLevel.PRIVATE)
	String executable;

	private Driver() { }
	
	private Driver(String browserName, String className, String optionsClassName, 
			String property, String executableWindowsArm64, String executableUnix) {
		setBrowserName(browserName);
		setClassName(className);
		setOptionsClassName(optionsClassName);
		setProperty(property);
		setExecutableWindowsArm64(executableWindowsArm64);
		setExecutableUnix(executableUnix);
		setExecutable(OperatingSystem.isExecutionHostWindows() ? executableWindowsArm64 : executableUnix);
	}

}
