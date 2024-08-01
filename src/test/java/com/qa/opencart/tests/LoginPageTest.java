package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;



public class LoginPageTest extends BaseTest {
	
	@Test(priority=2)
	public void getLoginPageLogoTest() {
		
		
		Assert.assertTrue(loginpage.getLoginPageLogo());
	}
	@Test(priority=1)
	public void getTitleTest() {
			
		String title=loginpage.getTitle();
		Assert.assertEquals(title, "Account Login");
	}
	@Test(priority=3)
	public void doLoginTest() {
		loginpage.doLogin("abcdef.123@gmail.com","abc123");
	}
}
