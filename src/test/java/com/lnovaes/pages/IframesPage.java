package com.lnovaes.pages;

import org.openqa.selenium.By;

import com.lnovaes.core.BasePage;

public class IframesPage extends BasePage {
	
	public void accessIframesWindow() {
		accessUrl("https://demo.automationtesting.in/Frames.html");
	}
	
	public void accessSingleIframeTab() {
		clickLink("Single Iframe");
	}
	
	public void accessSingleIframe() {
		accessFrame("singleframe");
	}
	
	public void writeTextInIframe(String text) {
		writeText(By.xpath("//input[@type='text']"), text);
	}
	
	public String getTextValueInIframe() {
		return getElementValue(By.xpath("//input[@type='text']"));
	}

	public void accessIframeWithinAnIframeTab() {
		clickLink("Iframe with in an Iframe");
	}
	
	public void accessIframe(int index) {
		accessFrameByIndex(index);
	}
	
	public String getIframeTitle() {
		return getElementH5Text(By.xpath("//h5"));
	}
}
