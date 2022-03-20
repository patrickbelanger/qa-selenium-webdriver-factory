# qa-selenium-webdriver-factory
A library to ease the development of Selenium's powered automation framework by instantiating a web driver and reducing boilerplate code.

## Features
### Supported Browsers
* Brave Browser (uses ChromeDriver) (* see knowledge base section)
* Chrome Browser

### Supported Platform
* Linux (tested on Ubuntu 21.10)
* Windows (tested on Windows 10)

# Prerequisites

* Java Development Kit / Runtime Environment (Java 11)
* Lombok (**IMPORTANT** please follow the instruction to install Lombok on [Eclipse, Spring Tool Suite, (Red Hat) JBoss Developer Studio, MyEclipse](https://projectlombok.org/setup/eclipse), [IntelliJ IDEA](https://projectlombok.org/setup/intellij), [Netbean](https://projectlombok.org/setup/netbeans), 
and [Visual Studio Code](https://projectlombok.org/setup/vscode).
* Selenium Webdriver (uses version 4.1.2)

# Developer(s)

* [Patrick Bélanger](https://github.com/patrickbelanger)

# Knowledge Base

* If you get Java error(s) on getters/setters, you haven't installed the Lombok plugin on your IDE. This library is required to use qa-selenium-webdriver-factory. After installing the plugin, make sure to perform a Maven update.
* Brave Browser on Linux (local): Not supported. I recommend executing Brave driver on a Windows host or remotely (through Selenium Grid hosted on Windows 
(* tested and works fine)).

# Contribute

* This is an active open-source project. We are always open to people who want to use the system or contribute to it. 
Contact us if you are looking for implementation tasks that fit your skills. An article will be available how to 
contribute to qa-selenium-webdriver-factory.
* For developers using Eclipse IDE, use the provided code-formatter in src/main/resources.
