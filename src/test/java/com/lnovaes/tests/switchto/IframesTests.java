package com.lnovaes.tests.switchto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.javafaker.Faker;
import com.lnovaes.core.BaseTest;
import com.lnovaes.pages.switchto.IframesPage;

public class IframesTests extends BaseTest {	
	IframesPage iframesPage = new IframesPage();
	Faker faker = new Faker();
	
	@Before
	public void start() {
		iframesPage.accessIframesWindow();
	}
	
	@Test
	public void testSingleIframe() {
		String text = faker.lorem().word();
		
		iframesPage.accessSingleIframeTab();
		iframesPage.accessSingleIframe();
		
		Assert.assertEquals("iFrame Demo", iframesPage.getIframeTitle());
		
		iframesPage.writeTextInIframe(text);
		
		Assert.assertEquals(text, iframesPage.getTextValueInIframe());
	}
	
	@Test
	public void testIframeWithinAnIframe() {
		String text = faker.lorem().word();
		
		iframesPage.accessIframeWithinAnIframeTab();
		iframesPage.accessIframe(1);
		
		Assert.assertEquals("Nested iFrames", iframesPage.getIframeTitle());
		
		iframesPage.accessIframe(0);
		
		Assert.assertEquals("iFrame Demo", iframesPage.getIframeTitle());
		
        iframesPage.writeTextInIframe(text);
		
		Assert.assertEquals(text, iframesPage.getTextValueInIframe());
	}
}
