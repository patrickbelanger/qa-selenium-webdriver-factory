package qa.patrick.belanger.selenium.webdriver.factory.drivers.options;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;

import qa.patrick.belanger.selenium.webdriver.factory.drivers.desktop.Chrome;
import qa.patrick.belanger.selenium.webdriver.factory.drivers.desktop.ChromiumBasedBrowser;

public class ChromeDefaultOptions extends DefaultOptions {

	@Override
	public MutableCapabilities getOptions() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments(ChromiumBasedBrowser.ARGUMENT_START_MAXIMIZED);
		if (getWebDriverProperties().isBrowserPrivateMode()) {
			chromeOptions.addArguments(Chrome.ARGUMENT_INCOGNITO_MODE);
		}
		return chromeOptions;
	}

}
