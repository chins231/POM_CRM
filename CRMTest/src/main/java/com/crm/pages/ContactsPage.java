package com.crm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.base.BaseClass;

public class ContactsPage extends BaseClass {
	
	
	@FindBy (xpath="//div[@class='ui loader']")
	WebElement contactsTable;
	@FindBy(xpath="//button[text()='New']")
	WebElement newContact;
	@FindBy(xpath = "//div[text='Create New Contact']")
	WebElement newContactHeader;
	@FindBy(name = "first_name")
	WebElement Fname;
	@FindBy(name = "last_name")
	WebElement Lname;
	@FindBy(name = "company")
	WebElement Company;
	@FindBy(name = "category")
	WebElement Category;
	@FindBy (xpath="//input[@placeholder='Email address']")
	WebElement EmailId;
	@FindBy (xpath="//i[@class='save icon' ]")
	WebElement saveContact;
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);//initialize pagefactory or this 
	}
	
	public String createContact(String fname,String lname,String emailId)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='New']")));
		newContact.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='first_name']")));
//		newContact.click();
		Fname.sendKeys(fname);
		Lname.sendKeys(lname);
//		if(company!=null)
//		{
//		 Company.sendKeys(company);}
		EmailId.sendKeys(emailId);
		saveContact.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui loader']")));
		return contactsTable.getText();
	}
	public boolean validateContactsPage()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='New']")));
		return newContact.isDisplayed();
	}
	
	public void getTableData()
	{
		List<WebElement>rows =driver.findElements(By.xpath("//div[contains(@class,'main-content')]/table/tbody/tr"));
		System.out.println(rows.size());
		List<WebElement>cols =driver.findElements(By.xpath("//div[contains(@class,'main-content')]/table/tbody/tr[1]/td"));
		System.out.println(cols.size());
		for (int i=1;i<=rows.size();i++)
		{
			String name=driver.findElement(By.xpath("//div[contains(@class,'main-content')]/table/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(name);
		}
		
	}

}
