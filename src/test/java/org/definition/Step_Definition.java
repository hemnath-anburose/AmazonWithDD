package org.definition;

import java.util.List;
import java.util.Map;

import org.config.MyLibrary;
import org.excelFiles.ExcelDataReader;
import org.excelFiles.ExcelPom;
import org.excelFiles.IDataReader;
import org.pom.Homepage;
import org.pom.Products;
import org.pom.Specs;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Step_Definition extends MyLibrary{
	Homepage home;
	Products prods;
	Specs product_spec;
	
	@Given("launch browser and visit amazon india")
	public void launch_browser_and_visit_amazon_india() {
	    Browser("chrome");
	    impWait(20);
	}
	@Then("search a product")
	public void search_a_product() {
	    home = new Homepage();
	    home.SearchBar();
	}
	@Then("sort the price from high to low")
	public void sort_the_price_from_high_to_low() {
		prods = new Products();
	    prods.High_Low();
	}
	@Then("click fifth product")
	public void click_fifth_product() {
		prods = new Products();
	    prods.selectToPurchase();
	}
	@Then("print the details of the product in console")
	public void print_the_details_of_the_product_in_console() {
		product_spec = new Specs();
		product_spec.printDetails();
	}
	@Then("do add cart")
	public void do_add_cart() {
		product_spec = new Specs();
		product_spec.readyToCart();
	}
	
	@Then("Search Products {string}")
	public void search_products(String MyProduct) {
	   home = new Homepage();
	   home.SearchBar(MyProduct);
	}
	
	@Then("search from Excel Sheet")
	public void search_from_excel_sheet(io.cucumber.datatable.DataTable dataTable) {
	  List<Map<String, String>>data = dataTable.asMaps();
	  System.out.println(data.get(3)+ "prodsssssss");
	}
	
	/**
	 * @param entry
	 * @return
	 */
	@DataTableType
	public IDataReader excelToDataTable(Map<String, String> entry) { //filename and location
		ExcelPom xlConfig = new ExcelPom.ExcelPomReader()
				.setFileName(entry.get("Excel"))
				.setFileLocation(entry.get("Location"))
				.setSheetName(entry.get("Sheet"))
				.setIndex(Integer.valueOf(entry.getOrDefault("Index", "0"))) //optional
				.reader();
		return new ExcelDataReader(xlConfig); 
		
	}

	
}

