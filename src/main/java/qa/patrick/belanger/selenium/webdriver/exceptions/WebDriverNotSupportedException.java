package qa.patrick.belanger.selenium.webdriver.exceptions;

/**
 * WebDriverNotSupportedException
 * Indicates that the WebDriver is not supported on the execution host
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class WebDriverNotSupportedException extends RuntimeException {

	private static final long serialVersionUID = -2720761797589285619L;

	public WebDriverNotSupportedException(String message) {
    super(message);
  }

  public WebDriverNotSupportedException(String message, Throwable cause) {
    super(message, cause);
  }
	
}
