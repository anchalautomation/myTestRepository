package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	//ctrl shift o-for imports
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public HomePageTest()
	{
		super();
	}
	
	//have to login bcz checking home page ,so login will land to homepge
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage=new LoginPage();
		contactspage=new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority=2)
	public void verifyHomePageTitleTest()
	{
		String title=homepage.validateHomePageTitle();
		Assert.assertEquals(title,"Free CRM  - CRM software for customer relationship management, sales, and support.","homepge title not matched");
		//asert comment will be printed in report when tc fails
	}
   @Test(priority=1)
	public void verifyContactPageLink(){
		contactspage=homepage.clickOnContactsLink();
	}
	@AfterMethod()
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	

}
