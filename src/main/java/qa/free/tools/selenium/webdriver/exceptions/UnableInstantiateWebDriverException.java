package qa.free.tools.selenium.webdriver.exceptions;

public class UnableInstantiateWebDriverException extends RuntimeException {

	private static final long serialVersionUID = 4641396932733870890L;

	public UnableInstantiateWebDriverException(String message) {
		super(message);
	}

	public UnableInstantiateWebDriverException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UnableInstantiateWebDriverException(Throwable cause) {
		super(cause);
	}

}
