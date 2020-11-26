package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.BaseClass;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class TestHomePage extends BaseClass{
	LoginPage loginpage;
	HomePage hp;
	ContactsPage cp;
	
	public  TestHomePage() {
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage=new LoginPage();
		hp=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	 @Test(priority=1)
	 public void testHomePageElements()
	 {
		 System.out.println(hp.validateHomePage());
		 Assert.assertTrue(hp.validateHomePage());
	 }
	 @Test(priority=2)
	 public void ValidateContactLink() throws InterruptedException
	 
	 {
		 System.out.println(hp.selectContacts());
		  cp=hp.selectContacts();
		 //Assert.assertTrue(hp.selectContacts());
	 }
    @AfterMethod
    public void exitMethod()
    {
    	driver.quit();
    }
}
