package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement userId;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement Login;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement Logout;
	
	public void setUserName(String uname) {
		userId.sendKeys(uname);
	}
    
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		Login.click();
	}
	
	public void clickLogout() {
		Logout.click();
	}
}
