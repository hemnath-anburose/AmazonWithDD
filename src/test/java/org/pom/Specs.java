package org.pom;

import org.config.MyLibrary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Specs extends MyLibrary{
	public Specs() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='feature-bullets']")
	private WebElement AboutItem;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	private WebElement AddToCart;

	public WebElement getAboutItem() {
		return AboutItem;
	}

	public WebElement getAddToCart() {
		return AddToCart;
	}
	
	public void printDetails() {
		winSwitch(1);
		System.out.println(getAboutItem().getText());
	}
	
	public void readyToCart() {
		getAddToCart().click();
	}
}
