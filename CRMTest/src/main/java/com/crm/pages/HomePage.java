package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.base.BaseClass;

public class HomePage extends BaseClass{
	
	
	@FindBy(xpath = ("//div[@id='main-nav']"))
	WebElement navigations;
	@FindBy(xpath=("//span[text()='Home']"))
	WebElement Home;

	@FindBy(xpath=("//span[text()='Calendar']"))
	WebElement Calendar;
	
	@FindBy(xpath=("//span[text()='Contacts']"))
	WebElement Contacts;
	
	
	@FindBy(xpath=("//span[text()='Companies']"))
	WebElement Companies;
	
	@FindBy(xpath=("//span[text()='Tasks']"))
	WebElement Tasks;
	
	@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement newContact;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);//initialize pagefactory or this 
	}
	
	public boolean validateHomePage()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#main-nav")));
		return navigations.isDisplayed();
	}
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage selectContacts() throws InterruptedException
	{
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Contacts']")));
		Contacts.click();
		System.out.println("In Contacts Page");
		Thread.sleep(4000);
		return new ContactsPage();//returning contacts page
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/contacts/new']")));
//		
//		Thread.sleep(4000);
//		System.out.println("Checking for New Button");
	
		//return newContact.isDisplayed();
	}
	
}
