package com.lnovaes.pages;

import org.openqa.selenium.By;

import com.lnovaes.core.BasePage;
import com.lnovaes.core.DriverFactory;

public class AlertsPage extends BasePage {
	
	public void accessAlertsWindow() {
		DriverFactory.getDriver().get("https://demo.automationtesting.in/Alerts.html");
	}
	
	public void accessAlertWithOkTab() {
		clickLink("Alert with OK");
	}
	
	public void clickAlertWithOkButton() {
		clickButton(By.xpath("//div[@id='OKTab']/button"));
	}
	
	public String getAlertWithOkText() {
		clickAlertWithOkButton();
		
		return getAlertTextAndAccept();
	}
	
	public void accessAlertWithOkAndCancelTab() {
		clickLink("Alert with OK & Cancel");
	}
	
	public void clickAlertWithOkAndCancelButton() {
		clickButton(By.xpath("//div[@id='CancelTab']/button"));
	}
	
	public String getAlertWithOkAndCancelTextAndPressOk() {
		clickAlertWithOkAndCancelButton();
		
		return getAlertTextAndAccept();
	}
	
	public String getAlertWithOkAndCancelTextAndPressCancel() {
		clickAlertWithOkAndCancelButton();
		
		return getAlertTextAndDismiss();
	}
	
	public String getAlertWithOkAndCancelConfirmation() {
		return getFieldText(By.id("demo"));
	}
	
	public void accessAlertWithTextboxTab() {
		clickLink("Alert with Textbox");
	}
	
	public void clickAlertWithTextboxButton() {
		clickButton(By.xpath("//div[@id='Textbox']/button"));
	}
	
	public String getAlertWithTextboxText() {
		clickAlertWithTextboxButton();
		return getAlertText();
	}
	
	public void writeAlertWithTextbox(String value) {
		alertWrite(value);
	}
	
	public String getAlertWithTextboxConfirmationMessage() {
		return getFieldText(By.id("demo1"));
	}
	
	public String getAlertWithTextboxTextAndAccept() {
		clickAlertWithTextboxButton();
		
		return getAlertTextAndAccept();
	}
	
	public String getAlertWithTextboxTextAndDismiss() {
		clickAlertWithTextboxButton();
		
		return getAlertTextAndDismiss();
	}

}
