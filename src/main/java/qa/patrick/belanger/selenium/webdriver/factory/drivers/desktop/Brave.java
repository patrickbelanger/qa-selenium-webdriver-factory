package qa.patrick.belanger.selenium.webdriver.factory.drivers.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

import qa.patrick.belanger.selenium.webdriver.base.Driver;
import qa.patrick.belanger.selenium.webdriver.utils.OperatingSystem;


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
	
	/**
	 * Creates a new ChromeDriver instance with the specified options.
	 */
	@Override
	public WebDriver getWebDriver() {
		if (OperatingSystem.isExecutionHostLinux()) {
			StringBuilder sb = new StringBuilder()
					.append("Brave Browser support on Linux is experimental.\n")
					.append("In local, you may get a 'org.openqa.selenium.concurrent.ExecutorServices shutdownGracefully ' ")
					.append("[pid=xxxxx, exitValue=0] SEVERE status when calling webDriver.quit();\n")
					.append("If you get this SEVERE status, you need to kill Brave Browser process by your own.\n");
			logger.warn(sb.toString());
		}
		return new ChromeDriver((ChromeOptions) getOptions());
	}
	
}
