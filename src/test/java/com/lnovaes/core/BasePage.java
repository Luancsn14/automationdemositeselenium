package com.lnovaes.core;

import static com.lnovaes.core.DriverFactory.getDriver;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	/************ Common ************/
	
	public String getElementValue(By by) {
		return getDriver().findElement(by).getAttribute("value");
	}
	
	public String getElementTarget(By by) {
		return getDriver().findElement(by).getAttribute("target");
	}
	
	public String getElementOnclick(By by) {
		return getDriver().findElement(by).getAttribute("onclick");
	}
	
	public void clickElement(By by) {
		getDriver().findElement(by).click();
	}
	
	public String getElementText(By by) {
		return getDriver().findElement(by).getText();
	}
	
	/************ Wait ************/
	
	public void waitElementInvisibility(By element, int time) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(element)));
	}
	
	public void waitElementVisibility(By element, int time) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(element)));
	}
	
	/************ TextField and TextArea ************/
	
	public void writeText(By by, String text) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(text);		
	}
	
	public String getFieldText(By by) {
		return getDriver().findElement(by).getText();
	}
	
	/************ Tooltips ************/
	
	public String getTooltip(By fieldBy, By tpBy) {
		WebElement element = getDriver().findElement(fieldBy);

        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
        
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(tpBy));
        
		return tooltip.getText();
	}
	
	/********* Radio And Check ************/
	
	public boolean isRadioSelected(By by){
		return getDriver().findElement(by).isSelected();
	}
	
	public boolean isCheckSelected(By by){
		return getDriver().findElement(by).isSelected();
	}
	
	/************ Multi-select ************/
	
	public void selectAllOptionsMulti(By field, By multi) {
		getDriver().findElement(field).click();
		List<WebElement> elements = getDriver().findElements(multi);
		for(WebElement element: elements) {
			element.click();
		}
	}
	
	public void selectSpecificOptionMulti(By field, By multi) {
		getDriver().findElement(field).click();
		getDriver().findElement(multi).click();
	}
	
	public void selectSearchedOptionMulti(By multi) {
		getDriver().findElement(multi).click();
	}
	
	public List<WebElement> getMultiValues(By field) {
		List<WebElement> elements = getDriver().findElements(field);
		return elements;
	}
	
	public List<String> getMultiTexts(By field) {
		List<String> texts = new ArrayList<>();

        for (WebElement text : getMultiValues(field)) {
            texts.add(text.getText());
        }
		return texts;
	}
	
	/************ Combo ************/
	
	public void selectCombo(By by, String value) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		combo.selectByVisibleText(value);
	}
	
	public void deselectCombo(By by, String value) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		combo.deselectByVisibleText(value);
	}

	public String getComboValue(By by) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
		
	public List<WebElement> getComboOptions(By by) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		
		List<WebElement> options = combo.getOptions();
		
		return options;
	}
	
	public List<String> getComboValues(String id) {
		WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> values = new ArrayList<String>();
		for(WebElement opcao: allSelectedOptions) {
			values.add(opcao.getText());
		}
		return values;
	}
	
	/************ Upload file ************/
	
	public void uploadFile(String file, By uploadField) {
		File uploadFile = new File(file);
		
		WebElement fileInput = getDriver().findElement(uploadField);
	    fileInput.sendKeys(uploadFile.getAbsolutePath());
	}
	
	/************ Button ************/
	
	public void clickButton(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clickButtonByText(String text) {
		clickButton(By.xpath("//button[.='" + text + "']"));
	}
		
	/************ Link ************/
	
	public void clickLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	
	/************ Alerts ************/
	
	public String getAlertText(){
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String getAlertTextAndAccept(){
		Alert alert = getDriver().switchTo().alert();
		String text = alert.getText();
		alert.accept();
		return text;		
	}
	
	public String getAlertTextAndDismiss(){
		Alert alert = getDriver().switchTo().alert();
		String text = alert.getText();
		alert.dismiss();
		return text;
		
	}
	
	public void alertWrite(String value) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(value);
		alert.accept();
	}
	
	/************ Windows ************/
	
	public void accessUrl(String window) {
		getDriver().get(window);
	}
	
	public void browserToNewWindow() {		
		getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[1]);
	}
	
	public String getUrl() {
		return getDriver().getCurrentUrl();
	}
	
	public int getWindowsAmount() {
		return getDriver().getWindowHandles().size();
	}
	
	public List<String> getWindowsUrls() {	
		List<String> windows = new ArrayList<>(getDriver().getWindowHandles());
		List<String> urls = new ArrayList<>();
		
		for (String window : windows) {
            urls.add(getDriver().switchTo().window(window).getCurrentUrl());
        }		
		return urls;
	}
	
	/************ Frames ************/
	
	public void accessFrame(String id) {
		getDriver().switchTo().frame(id);
	}
	
	public void accessFrameByIndex(int index) {		
		getDriver().switchTo().frame(index);
	}
	
	/************ Accordion ************/
	
	public boolean isExpanded(By by) {
		return getDriver().findElement(by).isDisplayed();
	}
}
