package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	String sheetname="contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage=new LoginPage();
		contactspage=new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority=1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactspage.verifyContactsLabel());
	}
	
	@Test(priority=2)
	public void verifyclickOnAndroidLink()
	{
		contactspage.clickOnAndroidLink();
	}
	/*@DataProvider
	public Object[][] getCRMTestData()
	{
	Object data[][]=TestUtil.getTestData(sheetname);//complete data stored here
	return data;
		
	}
	@Test(dataProvider="getCRMTestData") //3 vcol in sheet so three params in validatenewcontact
	public void validateCreateNewContact(String title,String fname,String lname)
	{
		homepage.clickOnNewContactLink();//first click on conta ct on homepage
		contactspage.createNewContact(title,fname,lname); //will use data provider here
	}*/
	
	@AfterMethod()
	public void teardown()
	{
		driver.quit();
	}
	
	
	

}
