package fr.phe.ju5.tests;

import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.adapter.junit.jupiter.FluentTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

@FluentConfiguration(webDriver = "chrome", capabilities = "{\"chromeOptions\": {\"args\": [\"window-size=1024,768\"]}}")
public abstract class AbstractTest extends FluentTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractTest.class);
    public static WebDriver driver;
	
	@BeforeAll
	public static void setUpChrome() {
		logger.info("@BeforeAll");
		WebDriverManager.chromedriver().setup();
		driver = WebDriverManager.chromiumdriver().getWebDriver();
	}
	@AfterAll
	public static void quitChrome() {
		logger.info("@AfterAll");
		WebDriverManager.chromedriver().quit();
	}
}
