package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	DriverFactory df;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginpage;
	public AccountsPage accpage;
	@BeforeTest
	public void setUp() {
	df=new DriverFactory();
	prop=df.initProp();
	driver=	df.initDriver(prop);
	loginpage=new LoginPage(driver);
	
	}
	
	
	@AfterTest
	public void tearDown() {
		//AccountsPagedriver.quit();
	}
}
