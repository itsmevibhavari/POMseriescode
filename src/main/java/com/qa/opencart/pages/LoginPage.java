package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	By emailid = By.id("input-email");
	By password = By.id("input-password");
	By loginbtn = By.xpath("//input[@value='Login']");
	By forgetpwd=By.linkText("Forgotten Password");
	By logo=By.xpath("//img[@title='naveenopencart']");
	By msg=By.xpath("//div[@class='alert alert-danger alert-dismissible']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//PageAction
	public boolean getLoginPageLogo() {
		return driver.findElement(logo).isDisplayed();
	}
	public String getTitle() {
		String title=driver.getTitle();
		return title;
	}
	public boolean getForgotPwd() {
		return driver.findElement(forgetpwd).isDisplayed();
	}
	public AccountsPage doLogin(String username,String pwd) {
		driver.findElement(emailid).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginbtn).click();
		return new AccountsPage(driver);
		
	}
}
