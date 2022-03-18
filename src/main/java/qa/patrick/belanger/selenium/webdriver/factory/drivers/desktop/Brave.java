package qa.patrick.belanger.selenium.webdriver.factory.drivers.desktop;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

import qa.patrick.belanger.selenium.webdriver.base.Driver;


/**
 * Brave Browser class
 * Returns a ChromeDriver/RemoteWebDriver (using the binary location of Brave Browser)
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class Brave extends Chrome {

	public Brave() {
		super(Driver.BRAVE);
	}
	
	/**
   * Get ChromeOptions (with the binary location of Brave Browser)
   */
	@Override
	public AbstractDriverOptions<?> getOptions() {
		ChromeOptions chromeOptions = (ChromeOptions) super.getOptions();
		chromeOptions.setBinary(getWebDriverProperties().getBraveBrowserBinaryPath());
		return chromeOptions;
	}
	
}
