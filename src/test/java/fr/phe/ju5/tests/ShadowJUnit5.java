package fr.phe.ju5.tests;

import org.fluentlenium.core.annotation.Page;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Assertions;

import fr.phe.ju5.pages.WatirPage;

// inspired from titusfortner project
// https://github.com/titusfortner/website-examples/blob/shadow_dom/java/selenium4/src/test/java/com/titusfortner/selenium4/ShadowDomTest.java

@TestMethodOrder(OrderAnnotation.class)
public class ShadowJUnit5 extends AbstractTest {

	@Page
	private WatirPage watirPage;

	@Test
	@Order(1)
	public void checkDomItem() throws InterruptedException {
		watirPage.go();
		watirPage.verifyIsLoaded();
		Assertions.assertEquals(watirPage.getDomLinkText(), "scroll.html");
        
        Thread.sleep(2000);
	}

	@Test
	@Order(2)
	public void checkShadowItem() throws InterruptedException {
		watirPage.go();
		watirPage.verifyIsLoaded();
		Assertions.assertEquals(watirPage.getShadowRootSpanText(), "some text");
        
        Thread.sleep(2000);
	}
}
