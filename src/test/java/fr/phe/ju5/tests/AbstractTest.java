package fr.phe.ju5.tests;

import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.adapter.junit.jupiter.FluentTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import io.github.bonigarcia.wdm.WebDriverManager;

@FluentConfiguration(webDriver = "chrome", capabilities = "{\"chromeOptions\": {\"args\": [\"window-size=1024,768\"]}}")
public abstract class AbstractTest extends FluentTest {
	
	@BeforeAll
	public static void setUpChrome() {
		WebDriverManager.chromedriver().setup();
	}
	@AfterAll
	public static void quitChrome() {
		WebDriverManager.chromedriver().quit();
	}
}
