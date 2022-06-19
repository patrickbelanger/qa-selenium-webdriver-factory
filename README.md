# qa-selenium-webdriver-factory
A library to ease the development of Selenium's powered automation framework by instantiating a web driver 
and reducing boilerplate code. The goal is: set WebDriverFactory in your dependencies, and implement it in your
automation framework.

## Features
### Supported Browsers
* Brave Browser (uses ChromeDriver) (* see knowledge base section) - (tested on version 99.0.4844.74 (Windows))
* Chrome Browser (tested on version 99.0.4844.74 (Windows/Linux))
* Microsoft Edge (tested on version 99.0.1150.46 (Windows/Linux))
* Mozilla Firefox (tested on version 98.0.1 (Windows/Linux (* remote only)))
* Opera Browser (tested on version 84.0.4316.42 (WebKit - 98.0.4758.109) (Windows/Linux (*see knowledge base section)))

### Selenium 4.2.x W3C compliant (ready for Selenium 4.3)
* The goal is creating a WebDriverFactory library that follows closely the latest Selenium WebDriver/W3C standards.

### Supported Platform
* Linux (tested on Ubuntu 21.10)
* Windows (tested on Windows 10)

### Supported Third-party provider (Grid - Desktop)
* BrowserStack
* Perforce Perfecto (planned)
* Sauce Labs (in progress)

# Prerequisites

* Java Development Kit / Runtime Environment (Java 11)
* Lombok (**IMPORTANT** please follow the instruction to install Lombok on [Eclipse, Spring Tool Suite, (Red Hat) JBoss Developer Studio, MyEclipse](https://projectlombok.org/setup/eclipse), [IntelliJ IDEA](https://projectlombok.org/setup/intellij), [Netbean](https://projectlombok.org/setup/netbeans), 
and [Visual Studio Code](https://projectlombok.org/setup/vscode).
* Selenium Webdriver (uses version 4.1.2)

# How to use WebDriverFactory?

* A documentation will be available in the Wiki section. Meanwhile, you can take a look at the WebDriverFactoryTest.java
class to get an idea how to implement the WebDriverFactory in your automation framework.

* The WebDriverFactory should be called from a BaseTest class (that needs to be created from your end) which will 
instantiate the desired WebDriver you want. You can bind Junit or TestNg, get parameters to set up the WebDriverFactory
to return the wanted driver instance.
 
# Developer(s)

* [Patrick Bélanger](https://github.com/patrickbelanger)

# Knowledge Base

* If you get Java error(s) on getters/setters when cloning the repository, this means you haven't installed the Lombok plugin on your IDE. This library is required to compile. After installing the plugin, make sure to perform a Maven update to clean up projects.
* Brave Browser on Linux (local): Not supported. I recommend executing Brave Browser on a Windows host or remotely (through Selenium Grid hosted on Windows (* tested and works fine)).
* Opera Browser: Since Selenium deprecated the OperaDriver/OperaOptions, WebDriverFactory is unable to instanciate Opera Driver for now.

# Contribute

* This is an active open-source project. We are always open to people who want to use the system or contribute to it. 
Contact us if you are looking for implementation tasks that fit your skills. An article will be available how to 
contribute to qa-selenium-webdriver-factory.
* For developers using Eclipse IDE, use the provided code-formatter in src/main/resources.
* For Mac developers, I need help to test this library to make it available on MacOS.