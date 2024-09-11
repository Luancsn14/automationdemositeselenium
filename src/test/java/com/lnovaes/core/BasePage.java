package com.lnovaes.core;

import static com.lnovaes.core.DriverFactory.getDriver;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	/************ TextField and TextArea ************/
	
	public void writeText(By by, String text) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(text);		
	}
	
	public String getFieldValue(By by) {
		return getDriver().findElement(by).getAttribute("value");
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
	
	public void clickElement(By by) {
		getDriver().findElement(by).click();
	}
	
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
	
	public List<WebElement> getMultiValues(By field) {
		List<WebElement> elements = getDriver().findElements(field);
		return elements;
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
	
	public String getUploadedFileName(By uploadField) {		
		return getDriver().findElement(uploadField).getAttribute("value");
	}
}
