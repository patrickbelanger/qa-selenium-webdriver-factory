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

/**
 * List of Grid provider (i.e., third-party companies providing cloud-based Selenium grid solutions to
 * execute test cases in parallel).
 * 
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public enum GridThirdParty {
	
	SELENIUM_GRID,
	BROWSERSTACK("BrowserStack", ".drivers.cloud.BrowserStack"),
	SAUCELABS("SauceLabs", ".drivers.cloud.SauceLabs")
	;
	
	/**
	 * Get/set third-party name
	 */
	@Getter
	@Setter(AccessLevel.PRIVATE)
	String thirdPartyName;

	/**
	 * Get/set class name (including part of the package as prefix)
	 */
	@Getter
	@Setter(AccessLevel.PRIVATE)
	private String className;
	
	@Getter
	@Setter(AccessLevel.PRIVATE)
	String gridUrl;
	
	@Getter
	@Setter(AccessLevel.PRIVATE)
	boolean userPasswordRequiredUrl;
	
	private GridThirdParty() { }
	
	private GridThirdParty(String thirdPartyName, String className) { 
		setThirdPartyName(thirdPartyName);
		setClassName(className);
	}
	

}
