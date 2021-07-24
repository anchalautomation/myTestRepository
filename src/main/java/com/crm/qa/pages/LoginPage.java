package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	//define page factory-or
	@FindBy(name="username")// no need to write ny.findelemengt
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
		@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmLogo;
	
//if there is no id and name then use custom xpath
	
	//now initialize all the elements by page factory (create constructor)
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this); //can use LoginPage.class but better to write 'this' as it means current class object
	}
	//all the web elements will be initialized by driver
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();
	}
	public boolean validateCrmImage()
	{
		return (crmLogo.isDisplayed());
	}
	public HomePage login(String un,String pwd)
	{
	
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage(); //after login it will return to homepage
		
	}
	
	
	
	
}
