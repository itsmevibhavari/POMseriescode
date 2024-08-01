package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/*
 * this method helps to initialize driver
 * returns driver
 */
public class DriverFactory {
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initDriver(Properties prop) {
		String browserName=prop.getProperty("browser");
		System.out.println("BrowserName:"+ browserName);
		if(browserName.equals("chrome")) {
			 driver= new ChromeDriver();
			}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
	}
		else
			System.out.println("pass the correct browser");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));

		return driver;
	}
	public Properties initProp() {
		 prop=new Properties();
		 try {
			FileInputStream ip=new FileInputStream("./src/resourse/POMTests/config/Config.Properties");
		prop.load(ip);
		 } catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} return prop;
		}
	
	
	}