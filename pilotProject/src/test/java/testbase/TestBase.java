package testbase;



import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Extentmanager1.Extentmanager1;

public class TestBase {

	

	// This code can be reusable in other Classes by inheritance.
	
	// It is a Base Class or Parent Class.
	
	public ExtentReports reports;
	public ExtentTest test;
	public SoftAssert softAssert;
	public String browser;
	public WebDriver driver;
	public Properties prop = null;
	
	
	@BeforeMethod(alwaysRun = true)
	public void init(ITestContext con,ITestResult result)
	{
	
	reports = Extentmanager1.getReports();
	test= reports.createTest(result.getMethod().getMethodName().toUpperCase());
	result.setAttribute("reporter", test);
	softAssert = new SoftAssert();
	
	String groupName [] = con.getAllTestMethods()[0].getGroups();
	String browserGroup="";
	for(String i :groupName)
	{
		if (i.startsWith("browsergroup"))
		{
			browserGroup =i;
		break;
				
		
	}
	}
	browser = con.getCurrentXmlTest().getParameter(browserGroup);
	System.out.println("browser is : " +browser);

	}
	
	@AfterMethod(alwaysRun = true) // call after the listener
	public void quit()
	{
	reports.flush();
	driver.close();
	}
	
	public void log(String msg)
	{
		System.out.println(msg);
	test.log(Status.INFO,msg );
	}
	public void logFailure(String msg) //only fails in extent reports
	{
		System.out.println(msg);
	test.log(Status.FAIL,msg );
	}
	
	public void failAndStop(String msg)// fails in extent as well as testng but stop
	{
	logFailure(msg);//extent
	softAssert.fail(msg);//testng
	softAssert.assertAll();//stop
	}
	public void softAssert(String msg)// fails in extent as well as testng but continue
	{
	logFailure(msg); //extent
	softAssert.fail(msg); //testng
	}
	
	
	
	@SuppressWarnings("deprecation")
	public WebDriver launchBrowser(String browsername)
	{
		
	
		
		if (browsername.equals("Chrome"))
		{
			 
			//System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,"logs\\chrome.log");	
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			ChromeOptions options = new ChromeOptions();
			//options.setBinary(null);
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			options.addArguments("--ignore-certificate-errors");
			driver= new ChromeDriver(options);
		}else if(browsername.equals("Mozilla"))
		{
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"logs\\firefox.log");	
			FirefoxOptions options = new FirefoxOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			FirefoxProfile prof = new FirefoxProfile();// to create new profile
			options.setProfile(prof);
			prof.setPreference("dom.webnotifications.enabled",false);
			
			driver= new FirefoxDriver(options);
		}else if(browsername.equals("Edge"))
		{
			System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			EdgeOptions options = new EdgeOptions();
			//options.setBinary(null);
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			driver= new EdgeDriver(options);
		}else if(browsername.equals("InternetExplorer"))
		{
			System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			//options.setBinary
			
			driver=  new InternetExplorerDriver(options);
		}
		
		// dynamic wait.means if can't find the element then it will wait for max 10 sec.
		// globle timeout , means it will applicable to all driver dot commands.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// it also init the property file after launch the browser
		try {
			 prop = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//project.Properties");
		prop.load(fs);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return driver; // it will return us driver back
	}

}



