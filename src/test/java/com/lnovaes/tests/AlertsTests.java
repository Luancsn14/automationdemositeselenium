package com.lnovaes.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.javafaker.Faker;
import com.lnovaes.core.BaseTest;
import com.lnovaes.pages.AlertsPage;


public class AlertsTests extends BaseTest {
	AlertsPage alertsPage = new AlertsPage();
	Faker faker = new Faker();
	
	@Before
	public void start() {
		alertsPage.accessAlertsWindow();		
	}
	
	@Test
	public void testAlertWithOk() {
		alertsPage.accessAlertWithOkTab();
		
		Assert.assertEquals("I am an alert box!", alertsPage.getAlertWithOkText());
	}
	
	@Test
	public void testAlertWithOKAndCancelPressOk() {
		alertsPage.accessAlertWithOkAndCancelTab();
		
		Assert.assertEquals("Press a Button !", alertsPage.getAlertWithOkAndCancelTextAndPressOk());
		Assert.assertEquals("You pressed Ok", alertsPage.getAlertWithOkAndCancelConfirmation());
	}
	
	@Test
	public void testAlertWithOKAndCancelPressCancel() {
		alertsPage.accessAlertWithOkAndCancelTab();
		
		Assert.assertEquals("Press a Button !", alertsPage.getAlertWithOkAndCancelTextAndPressCancel());
		Assert.assertEquals("You Pressed Cancel", alertsPage.getAlertWithOkAndCancelConfirmation());
	}
	
	@Test
	public void testAlertWithTextBox() {
		String name = faker.name().firstName();
		
		alertsPage.accessAlertWithTextboxTab();
		
		Assert.assertEquals("Please enter your name", alertsPage.getAlertWithTextboxText());
		
		alertsPage.writeAlertWithTextbox(name);
		
		Assert.assertEquals("Hello " + name + " How are you today", alertsPage.getAlertWithTextboxConfirmationMessage());		
	}
	
	@Test
	public void testAlertWithTextBoxBlank() {		
		alertsPage.accessAlertWithTextboxTab();
		
		Assert.assertEquals("Please enter your name", alertsPage.getAlertWithTextboxText());
		
		alertsPage.writeAlertWithTextbox("");
		
		Assert.assertTrue(alertsPage.getAlertWithTextboxConfirmationMessage().isBlank());		
	}
	
	@Test
	public void testAlertWithTextBoxDefaultMessage() {		
		alertsPage.accessAlertWithTextboxTab();
		
		Assert.assertEquals("Please enter your name", alertsPage.getAlertWithTextboxTextAndAccept());
		
		Assert.assertEquals("Hello Automation Testing user How are you today", alertsPage.getAlertWithTextboxConfirmationMessage());		
	}
	
	@Test
	public void testAlertWithTextBoxDismiss() {		
		alertsPage.accessAlertWithTextboxTab();
		
		Assert.assertEquals("Please enter your name", alertsPage.getAlertWithTextboxTextAndDismiss());
		
		Assert.assertTrue(alertsPage.getAlertWithTextboxConfirmationMessage().isBlank());		
	}
}
