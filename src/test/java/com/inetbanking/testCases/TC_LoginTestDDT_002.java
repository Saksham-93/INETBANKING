package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginTestDDT_002 extends Base {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String username , String pwd) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		
		lp.setPassword(pwd);
		
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		
		else {
			Assert.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() {
		
		try {
			
			driver.switchTo().alert();
			return true;
			
		}
		
		catch(NoAlertPresentException n) {
			
			return false;
			
		}
		
		
	}
	
	
	
	
	@DataProvider(name="LoginData")
	String[][] getdata() throws IOException{
		
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetbanking\\testData\\LoginData.xlsx";
		
		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rowcount][colcount];
		
		for(int i=1 ;i<=rowcount;i++) {
			
			for(int j=0;j<colcount;j++) {
				
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
				
			}
		}
		
		return logindata;
		
		
		
	}


}


