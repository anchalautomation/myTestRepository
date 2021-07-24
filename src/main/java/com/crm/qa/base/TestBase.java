package com.crm.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
  public static Properties prop;
  public static EventFiringWebDriver e_driver;
  public static WebEventListener eventListener;
	public TestBase()//reeading properties file
	{
		try{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C://Users//hp pc//workspace//FreeCrmTest//src//main//java//com//crm"+"//qa//config//config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	//for git
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
			   driver=new ChromeDriver();
		}//else if(browserName.equals("Firefox"))
		//{
		//	System.setProperty("webdriver.gecko.driver", "C:\\selenium\\firefoxdriver_win32\\geckodriver.exe");
		//	   driver=new FirefoxDriver();
		//}
		
		//create object of event firing listener here
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		//if we have to chnage the implicitly wait of pageload wait thenwe have to come to script and change.so better keep in util class.testutil class.
		
	}

}
