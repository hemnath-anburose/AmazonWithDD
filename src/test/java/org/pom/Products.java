package org.pom;


import org.config.MyLibrary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products extends MyLibrary {
	public Products() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='s-result-sort-select']")
	private WebElement sort;

	@FindBy(xpath = "//div[@data-index='4']/descendant::img")
	private WebElement SelectProduct;

	public WebElement getSort() {
		return sort;
	}

	public WebElement getSelectProduct() {
		return SelectProduct;
	}

	public void High_Low() {
		ByDropDown(getSort(), "Price: High to Low");
	}

	public void selectToPurchase() {
//		String xpathStart = "//div[@data-index='";
//		String xpathEnd = "']";
//		for (int i = 4; i <= 10; i++) {
//			String myxpath = xpathStart + i + xpathEnd;
//
//			if (myxpath != myxpath + "/descendant::span[text()='₹']/parent::span[@aria-hidden='true']") {
//					System.out.println(myxpath);
//					driver.findElement(By.xpath(myxpath + "/descendant::img")).click();	//			}
//
//		}
		getSelectProduct().click();
	}
}
