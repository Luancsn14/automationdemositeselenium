package com.lnovaes.pages.widgets;

import java.util.List;

import org.openqa.selenium.By;
import com.lnovaes.core.BasePage;

public class AutoCompletePage extends BasePage {
	
	public void accessAutoCompleteWindow() {
		accessUrl("https://demo.automationtesting.in/AutoComplete.html");
	}
	
	public void writeAutoComplete(String text) {
		writeText(By.id("searchbox"), text);
	}
	
	public List<String> getAutoCompleteResultText(){	
		return getMultiTexts(By.xpath("//ul[@id='ui-id-1']/li"));
	}
	
	public void selectSpecificAutoCompleteOption(String country) {
		selectSearchedOptionMulti(By.xpath("//ul[@id='ui-id-1']/li/a[text()='" + country + "']"));
	}
	
	public List<String> getAutoCompleteSelection() {
		return getMultiTexts(By.xpath("//input[@id='searchbox']/../div"));
	}
}
