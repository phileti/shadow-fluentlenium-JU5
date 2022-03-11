package fr.phe.ju5.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.annotation.Unshadow;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

//inspired from titusfortner project
//https://github.com/titusfortner/website-examples/blob/shadow_dom/java/selenium4/src/test/java/com/titusfortner/selenium4/ShadowDomTest.java

@PageUrl("http://watir.com/examples/shadow_dom.html")
public class WatirPage extends FluentPage {
	
    @Override
    public void verifyIsLoaded() {
        await().until(el("div#shadow_host")).displayed();
    }

	@FindBy(css = "a")
	private FluentWebElement link;
	public String getDomLinkText() {
		return link.text();
	}
	public String getDomLinkUrl() {
		return link.url();
	}

    @Unshadow(css = {"#shadow_host", "#shadow_content"})
	private FluentWebElement span;
    public String getShadowRootSpanText() {
        return span.text();
    }
}