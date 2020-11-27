package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.BaseClass;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class TestContactsPage extends BaseClass{
	LoginPage loginpage;
	HomePage hp;
	ContactsPage cp;
	
	public  TestContactsPage() {
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		loginpage=new LoginPage();
		hp=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		cp=hp.selectContacts();
		
	}
	 @Test(priority=1)
	 public void testContactPageElements()
	 {
		 System.out.println(cp.validateContactsPage());
		 Assert.assertTrue(cp.validateContactsPage());
	 }
	 @Test(priority=2)
	 public void createNewConatct() throws InterruptedException
	 
	 {
		 String name=cp.createContact("chins","chins","chins@chins.com");
		 System.out.println("Saved Contact is : "+name);
		 Assert.assertEquals("chins chins", name);
	 }
	 @Test(priority=3)
	 public void checkContacts()
	 {
		 cp.getTableData();
	 }
    @AfterMethod
    public void exitMethod()
    {
    	driver.quit();
    }
}
