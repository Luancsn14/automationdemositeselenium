package com.lnovaes.tests.widgets;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lnovaes.core.BaseTest;
import com.lnovaes.pages.widgets.AccordionPage;

public class AccordionTests extends BaseTest {
	AccordionPage accordionPage = new AccordionPage();
	
	@Before
	public void start() {
		accordionPage.accessAccordionWindow();
	}
	
	@Test
	public void testCollapsibleGroup1Readability() {	
		Assert.assertTrue(accordionPage.accordionReadabilityIsExpanded());
		
		accordionPage.clickAccordion("Readability");
		accordionPage.waitAccordionReadabilityIsClosed();
		
		Assert.assertFalse(accordionPage.accordionReadabilityIsExpanded());
		
		accordionPage.clickAccordion("Readability");
		accordionPage.waitAccordionReadabilityIsOpened();
		
		Assert.assertTrue(accordionPage.accordionReadabilityIsExpanded());
		Assert.assertEquals("This Automation Testing API is very simple to read and understand. "
				+ "Every method in this is self explanatory. "
				+ "If a layman looks into this code/script can understand what is happening. "
				+ "You can read the automation script like manual test case.", accordionPage.getAccordionReadabilityText());
	}
	
	@Test
	public void testCollapsibleGroup2SingleLineCoding() {
		Assert.assertFalse(accordionPage.accordionSingleLineCodingIsExpanded());
		
		accordionPage.clickAccordion("Single Line Coding");
		accordionPage.waitAccordionSingleLineCodingIsOpened();
		
		Assert.assertTrue(accordionPage.accordionSingleLineCodingIsExpanded());
		Assert.assertEquals("In this Automation tool, each and every functionality will be achieved by Single line code. "
				+ "i.e. Selecting a Value from dropdown, "
				+ "Switching between windows and Drag and Drop functionality etc...", accordionPage.getAccordionSingleLineCodingText());	
	}
	
	@Test
	public void testCollapsibleGroup3MethhodChaining() {
		Assert.assertFalse(accordionPage.accordionMethhodChainingIsExpanded());
		
		accordionPage.clickAccordion("Methhod Chaining");
		accordionPage.waitAccordionMethhodChainingIsOpened();
		
		Assert.assertTrue(accordionPage.accordionMethhodChainingIsExpanded());
		Assert.assertEquals("As the name indicates, "
				+ "you can chain the methods without breaking the code "
				+ "i.e. you can write the code for each element continuously.",
				accordionPage.getAccordionMethhodChainingText());
	}
	
	@Test
	public void testCollapsibleGroup4CrossBrowserTesting() {
		Assert.assertFalse(accordionPage.accordionCrossBrowserTestingIsExpanded());
		
		accordionPage.clickAccordion("Cross Browser Testing");
		accordionPage.waitAccordionCrossBrowserTestingIsOpened();
		
		Assert.assertTrue(accordionPage.accordionCrossBrowserTestingIsExpanded());
		Assert.assertEquals("NTest your web application across the most popular browsers including Firefox,"
				+ "Chrome and Internet Explorer to validate the functionality. "
				+ "You can easily switch between the browsers without changing the code.",
				accordionPage.getAccordionCrossBrowserTestingText());
	}
}
