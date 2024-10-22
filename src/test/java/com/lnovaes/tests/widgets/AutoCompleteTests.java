package com.lnovaes.tests.widgets;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import com.github.javafaker.Faker;
import com.lnovaes.core.BaseTest;
import com.lnovaes.pages.widgets.AutoCompletePage;

public class AutoCompleteTests extends BaseTest{
	AutoCompletePage autoCompletePage = new AutoCompletePage();
	Faker faker = new Faker();
	
	@Before
	public void start() {
		autoCompletePage.accessAutoCompleteWindow();
	}
	
	@Test
	public void testAutoCompleteFunctionality() {
		String country = faker.country().name();
		String searchChars = country.substring(0, 3);
		
		autoCompletePage.writeAutoComplete(searchChars + Keys.DOWN);
		
		List<String> results = autoCompletePage.getAutoCompleteResultText();
		
		Assert.assertTrue(results.size() > 0);
 		Assert.assertTrue(results.contains(country));
		
		for(String result: results) {			
			Assert.assertTrue(result.toLowerCase().contains(searchChars.toLowerCase()));
		}		
	}
	
	@Test
	public void testAutoCompleteMultiSelect() {
		String country1 = faker.country().name();
		String country2 = faker.country().name();
		
		autoCompletePage.writeAutoComplete(country1 + Keys.DOWN);
		autoCompletePage.selectSpecificAutoCompleteOption(country1);
		
		autoCompletePage.writeAutoComplete(country2 + Keys.DOWN);
		autoCompletePage.selectSpecificAutoCompleteOption(country2);
		
		Assert.assertTrue(autoCompletePage.getAutoCompleteSelection().contains(country1));
		Assert.assertTrue(autoCompletePage.getAutoCompleteSelection().contains(country2));
	}
}
