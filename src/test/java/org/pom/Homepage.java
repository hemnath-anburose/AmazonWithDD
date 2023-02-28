package org.pom;

import java.io.IOException;
import org.config.MyLibrary;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends MyLibrary{
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchInMe;

	public WebElement getSearchInMe() {
		return searchInMe;
	}
	
	public void SearchBar() {
		getSearchInMe().sendKeys("iphone", Keys.ENTER);
	}
	public void SearchBar(String MyProduct) {
		getSearchInMe().sendKeys(MyProduct, Keys.ENTER);
	}
}
