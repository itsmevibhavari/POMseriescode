package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	private WebDriver driver;
	By headers=By.xpath("//div[@id='content']/h2");
	By searchProduct=By.xpath("(//input[@name='search'])[1]");
	By searchButton=By.xpath("(//button[@type='button'])[4]");
	
	//product page locators
	By product=By.xpath("//img[@title='MacBook Pro']");
	By productData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	public static Map<String, String> datamap;
	
	public static List<String> actualList=Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
	}
	public String getAccUrl() {
		return driver.getCurrentUrl();
	}
	public String getTitle() {
		return driver.getTitle();
	}
	public void scrollDownPage() {
		//Actions action=new Actions(driver);
		//action.sendKeys(Keys.PAGE_DOWN).build().perform();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public ArrayList<String> headersList() {
		List<WebElement> accHeadList = driver.findElements(headers);
		ArrayList<String> headersText= new ArrayList<String>();
		for(WebElement e:accHeadList) {
			String listtext=e.getText();
		 headersText.add(listtext);
			
		}return headersText;
		
	}
	public void searchItem() {
		WebElement search=driver.findElement(searchProduct);
		search.sendKeys("Macbook");
		driver.findElement(searchButton).click();
	}
	public void selectProduct() {
		driver.findElement(product).click();
	}
	public Map<String, String> productMetadata() {
		 List<WebElement> matadata = driver.findElements(productData);
		datamap=new LinkedHashMap<String ,String>();
		for(WebElement e:matadata) {
			String dataText=e.getText();
			String text[]=dataText.split(":");
			String datakey=text[0].trim();
			String datavalue=text[1].trim();
			datamap.put(datakey, datavalue);
		}
		datamap.forEach((k,v) -> System.out.println(k +":"+ v));
		return datamap;
	}
}
