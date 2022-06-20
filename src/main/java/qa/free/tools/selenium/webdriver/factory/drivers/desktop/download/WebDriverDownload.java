package qa.free.tools.selenium.webdriver.factory.drivers.desktop.download;

import org.aeonbits.owner.ConfigFactory;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.Getter;
import qa.free.tools.selenium.webdriver.properties.WebDriverProperties;

public abstract class WebDriverDownload {

	@Getter
	private WebClient webClient;

	protected static WebDriverProperties webDriverProperties = ConfigFactory.create(WebDriverProperties.class);
	
	protected WebDriverDownload(String baseUrl) {
		webClient = WebClient.create(baseUrl);
	}
	
	public abstract void download();
	
}
