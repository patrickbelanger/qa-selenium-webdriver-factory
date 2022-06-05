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

package qa.free.tools.selenium.webdriver.utils;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class Environment {

	/** 
	 * Gets Java Runtime Environment argument (i.e., argument provided in command-line)
	 * @param argument
	 * @return
	 */
	public static String getJreArgument(String argument) {
		return System.getProperty(argument);
	}
	
	/**
	 * Gets the value of the specified environment variable. 
	 * @param variable
	 * @return
	 */
	public static String getEnvironmentValue(String variable) {
		return System.getenv(variable);
	}
	
	public static String getEnvironmentOrArgument(String variable, String argument) {
		if (getEnvironmentValue(variable) != null) {
			return getEnvironmentValue(variable);
		} 
		return getJreArgument(argument);
	}
	
}
