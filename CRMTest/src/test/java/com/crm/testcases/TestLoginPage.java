package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.BaseClass;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class TestLoginPage extends BaseClass{
	LoginPage loginpage;
	HomePage hp;
	
	public  TestLoginPage() {
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		
		 loginpage=new LoginPage();
	}
	 @Test(priority=1)
	 public void titleTest()
	 {
		 Assert.assertEquals(loginpage.checkLoginPageTitle(), "Free CRM #1 cloud software for any business large or small");
	 }
	 @Test(priority=2)
	 public void validateLogin()
	 
	 {
		  hp=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	 }
    @AfterMethod
    public void exitMethod()
    {
    	driver.quit();
    }
}
