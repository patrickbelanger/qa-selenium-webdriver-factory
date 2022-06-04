package qa.patrick.belanger.selenium.webdriver.factory.drivers.options;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.MutableCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AccessLevel;
import lombok.Getter;
import qa.patrick.belanger.selenium.webdriver.properties.WebDriverProperties;

public abstract class DefaultOptions {

	@Getter(AccessLevel.PROTECTED)
	WebDriverProperties webDriverProperties = ConfigFactory.create(WebDriverProperties.class);
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public abstract MutableCapabilities getOptions();
	
	
}
