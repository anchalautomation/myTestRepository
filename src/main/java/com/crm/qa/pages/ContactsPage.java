package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	@FindBy(xpath="//span[@class='header__name']")
	WebElement contactsLabel;
	@FindBy(id="firstname")
	WebElement firstname;
	@FindBy(id="lastname")
	WebElement lastname;
	@FindBy(xpath="//input[@type='submit']")
	WebElement savebtn;
	
		@FindBy(xpath="//h2[contains(text(),'Android')]")
	WebElement androidLink;
		//need not define everything in findby bcz for dynamic table, we ahev to define test2 test2 here so better define it in lower function..passs contact name as parameter in function

		public ContactsPage()
		{
			PageFactory.initElements(driver,this);
		}
		
		public boolean verifyContactsLabel()
		{
			return contactsLabel.isDisplayed();
		}
		public void clickOnAndroidLink()
		{
			androidLink.click();
			
		}
	/*	public void createNewContact(String title,String fname,String lname)//dont ant to hardcode so pass here
		{
			Select select =new Select(driver.findElement(By.id("title"))); //mr or mrs.
			select.selectByVisibleText(title);
			firstname.sendKeys(fname);
			lastname.sendKeys(lname);
			savebtn.click();
			
			
			
		}*/
}
