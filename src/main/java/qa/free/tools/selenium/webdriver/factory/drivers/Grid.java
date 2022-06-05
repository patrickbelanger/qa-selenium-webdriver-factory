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

package qa.free.tools.selenium.webdriver.factory.drivers;

import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.free.tools.selenium.webdriver.base.GridThirdParty;
import qa.free.tools.selenium.webdriver.properties.WebDriverProperties;

public abstract class Grid {

	protected static final String ARGUMENT_USERNAME = "username";
	protected static final String ARGUMENT_ACCESS_KEY = "accessKey";
	
	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PRIVATE)
	String username;

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PRIVATE)
	String accessToken;
	
	@Getter(AccessLevel.PROTECTED)
	WebDriverProperties webDriverProperties = ConfigFactory.create(WebDriverProperties.class);

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected boolean isCloudBasedGrid(boolean remote) {
		return remote && !getWebDriverProperties().getGridThidParty().equals(GridThirdParty.SELENIUM_GRID);
	}
	
	protected String getHostUrl() {
		return String.format("%s:%s%s", getWebDriverProperties().getGridUrl(), getWebDriverProperties().getGridPort(),
		    WebDriverProperties.GRID_HUB_ENDPOINT);
	}

}
