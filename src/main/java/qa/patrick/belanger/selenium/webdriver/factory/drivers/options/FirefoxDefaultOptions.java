package qa.patrick.belanger.selenium.webdriver.factory.drivers.options;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.firefox.FirefoxOptions;

import qa.patrick.belanger.selenium.webdriver.factory.drivers.desktop.Firefox;

public class FirefoxDefaultOptions extends DefaultOptions {

	@Override
	public MutableCapabilities getOptions() {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		if (getWebDriverProperties().isBrowserPrivateMode()) {
			firefoxOptions.addArguments(Firefox.ARGUMENT_PRIVATE_MODE);
		}
		return firefoxOptions;
	}

}
