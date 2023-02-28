package org.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.constant.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class MyLibrary extends Constant{
	public static WebDriver driver;
	public static XSSFWorkbook workBook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String value;
	public static int rowSize;
	public static void Browser(String BName) {
		if(BName .equalsIgnoreCase("Chrome")) {
			DesiredCapabilities dc = new DesiredCapabilities();
			ChromeOptions co = new ChromeOptions();
			co.merge(dc);
			dc.setAcceptInsecureCerts(true);
			dc.setBrowserName("Chrome");
			dc.setVersion("107");
			System.setProperty(InitChrome, ChromeDriverLocation);
			co.addArguments("--start-maximized");
			driver = new ChromeDriver(co);
		}
		else if(BName .equalsIgnoreCase("Edge")) {
			DesiredCapabilities dc = new DesiredCapabilities();
			EdgeOptions eo = new EdgeOptions();
			eo.merge(dc);
			dc.setAcceptInsecureCerts(true);
			dc.setBrowserName("Edge");
			dc.setVersion("107");
			System.setProperty(InitEdge, EdgeDriverLocation);
			driver = new EdgeDriver(eo);
		}
		driver.get(LaunchURL);
	}
	
	public static void ByDropDown(WebElement element, String TextValue) {
		Select dd = new Select(element);
		dd.selectByVisibleText(TextValue);
	}
	
	public static void impWait(int Time) {
		driver.manage().timeouts().implicitlyWait(Time, TimeUnit.SECONDS);
	}
	public static void winSwitch(int moveTab) {
		Set<String> windows = driver.getWindowHandles();
		List<String> myWin = new ArrayList<String>(windows);
		driver.switchTo().window(myWin.get(moveTab));
	}

}
