package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.base.BaseClass;

public class LoginPage extends BaseClass{
	
	
	//Object repo
	
	@FindBy(xpath="//span[(text()='Log In')]")
	WebElement LOGIN;
	
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//span[contains(text(),'sign up')]")
	WebElement signUp;
	
	@FindBy(xpath="//a[@title='free crm home']")
	WebElement logoTitle;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?']")
	WebElement forgotPwd;
	
	//init  
	public LoginPage()
	{
		PageFactory.initElements(driver, this);//initialize pagefactory or this 
	}
	
	//actions
    public String checkLoginPageTitle()
    {
    	return driver.getTitle();
    }
    
    public HomePage login(String uname,String pwd)
    {
    	LOGIN.click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='email']")));
    	username.sendKeys(uname);
    	password.sendKeys(pwd);
    	loginBtn.click();
    	System.out.println("Login successful");
    	
    	return new HomePage();
    }
}
