package com.qa.opencart.tests;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class AccountsPageTest extends BaseTest{
	@BeforeClass
	public void accpageSetup() {
		accpage=loginpage.doLogin("abcdef.123@gmail.com","abc123");
	}
	@Test(priority=1)
	public void dogetAccUrl() {
		String url=accpage.getAccUrl();
		Assert.assertEquals( url,"https://naveenautomationlabs.com/opencart/index.php?route=account/account");
	}
	@Test(priority=2)
	public void dogetTitle() {
		String title=accpage.getTitle();
		Assert.assertEquals(title, "My Account");
	}
	@Test(priority=4)
	public void pagescrollDown() {
		accpage.scrollDownPage();
	}
	@Test(priority=3)
	public void getheadersList() {
		ArrayList<String> actheaderList = accpage.headersList();
		Assert.assertEquals(actheaderList, accpage.actualList);	
	}
	@Test(priority=4)
	public void searchItemTest() {
		accpage.searchItem();
	}
	@Test(priority=5)
	public void selectProductTest() {
		accpage.selectProduct();
	}
	@Test(priority=6)
	public void getProductData() {
		accpage.productMetadata();
	}
	
}
