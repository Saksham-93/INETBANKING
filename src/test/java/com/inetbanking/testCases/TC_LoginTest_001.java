package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends Base{
	@Test
	public void login() throws InterruptedException, IOException {
		
		
		
		logger.info("URL is open");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Enter the username");
		lp.setPassword(password);
		logger.info("Enter the password");
		lp.clickSubmit();
		logger.info("Click on the login button");
		Thread.sleep(5000);
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			
			Assert.assertTrue(true);
			logger.info("Test case passed");
		}
		
		else {
			
			captureScreen(driver, "login");
			Assert.assertTrue(false);
			logger.info("Test case failed");
		}
		
		
		
		
	}

}
