package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//a[contains(text(),'Contact')]")
	WebElement contact;
	
	@FindBy(xpath="//a[contains(text(),'Pricing')]")
	@CacheLookup
	WebElement pricing;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactlink;
	
	@FindBy(xpath="//a[contains(text(),'Features')]")
	WebElement features;
	
	public HomePage()
	
	{
		PageFactory.initElements(driver , this);
	}
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	public ContactsPage clickOnContactsLink()
	{
		contact.click();
		return new ContactsPage();
	}
	public PricingPage clickOnPricingLink()
	{
		pricing.click();
		return new PricingPage();
	}
	public FeaturesPage clickOnFeaturesLink()
	{
		pricing.click();
		return new FeaturesPage();
	}
	/*public void clickOnNewContactLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contact).build().perform();
		newcontactlink.click();//form ison contacts page so filling form mthd is there
		
	}*/
	
	
	
	
	

}
