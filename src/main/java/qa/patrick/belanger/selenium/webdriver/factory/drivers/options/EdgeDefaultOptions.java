package qa.patrick.belanger.selenium.webdriver.factory.drivers.options;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.edge.EdgeOptions;

import qa.patrick.belanger.selenium.webdriver.factory.drivers.desktop.ChromiumBasedBrowser;
import qa.patrick.belanger.selenium.webdriver.factory.drivers.desktop.Edge;

public class EdgeDefaultOptions extends DefaultOptions {

	@Override
	public MutableCapabilities getOptions() {
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments(ChromiumBasedBrowser.ARGUMENT_START_MAXIMIZED);
		if (getWebDriverProperties().isBrowserPrivateMode()) {
			edgeOptions.addArguments(Edge.ARGUMENT_INPRIVATE_MODE);
		}
		if (getWebDriverProperties().useEdgeBrowserBinaryPath()) {
			edgeOptions.setBinary(getWebDriverProperties().getEdgeBrowserBinaryPath());
		}
		return edgeOptions;
	}

}
