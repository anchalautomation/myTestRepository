package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase 
{
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest()
	{
		super(); //calls the test base class constructor for initialization of poperties n all(sys.setproperty n all)
		//so we wont get nu;llpointerexception for initialization() method bcz we have already defined sys.set prop n all here
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage=new LoginPage(); //validateloginpage() isnot static so created object here
	}
	@Test(priority=1)
	public void loginPageTest()
	{
		String title=loginpage.ValidateLoginPageTitle();
		Assert.assertEquals(title, "CRM PRO Log In Screen");
		
	}
	@Test(priority=2)
	public void crmLogoTest()
	{
		boolean flag=loginpage.validateCrmImage();
		Assert.assertTrue(flag);
		
	}
	@Test(priority=3)
	public void Login()
	{
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password") );
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}

