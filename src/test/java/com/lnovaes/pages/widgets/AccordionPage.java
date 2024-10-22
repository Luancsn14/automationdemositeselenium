package com.lnovaes.pages.widgets;

import org.openqa.selenium.By;

import com.lnovaes.core.BasePage;

public class AccordionPage extends BasePage {
	
	public void accessAccordionWindow() {
		accessUrl("https://demo.automationtesting.in/Accordion.html");
	}
	
	public void clickAccordion(String accordion) {
		clickElement(By.xpath("//b[contains(text(),'" + accordion + "')]"));
	}
	
	public boolean accordionReadabilityIsExpanded() {
		return isExpanded(By.id("collapse1"));
	}
	
	public void waitAccordionReadabilityIsOpened() {
		waitElementVisibility(By.id("collapse1"), 10);
	}
	
	public void waitAccordionReadabilityIsClosed() {
		waitElementInvisibility(By.id("collapse1"), 10);
	}
	
	public String getAccordionReadabilityText() {
		return getElementText(By.id("collapse1"));
	}
	
	public boolean accordionSingleLineCodingIsExpanded() {
		return isExpanded(By.id("collapse2"));
	}
	
	public void waitAccordionSingleLineCodingIsOpened() {
		waitElementVisibility(By.id("collapse2"), 10);
	}
	
	public String getAccordionSingleLineCodingText() {
		return getElementText(By.id("collapse2"));
	}		
	
	public boolean accordionMethhodChainingIsExpanded() {
		return isExpanded(By.id("collapse3"));
	}
	
	public void waitAccordionMethhodChainingIsOpened() {
		waitElementVisibility(By.id("collapse3"), 10);
	}
	
	public String getAccordionMethhodChainingText() {
		return getElementText(By.id("collapse3"));
	}
	
	public boolean accordionCrossBrowserTestingIsExpanded() {
		return isExpanded(By.id("collapse4"));
	}
	
	public void waitAccordionCrossBrowserTestingIsOpened() {
		waitElementVisibility(By.id("collapse4"), 10);
	}
	
	public String getAccordionCrossBrowserTestingText() {
		return getElementText(By.id("collapse4"));
	}
}
