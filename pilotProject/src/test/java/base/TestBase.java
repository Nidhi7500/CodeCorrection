package base;

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

public class TestBase {
WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public WebDriver launchBrowser(String browsername)
	{
		
	
		
		if (browsername.equals("Chrome"))
		{
			 
			//System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,"logs\\chrome.log");	
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			ChromeOptions options = new ChromeOptions();
			//options.setBinary(null);
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
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
		
		return driver; // it will return us driver back
	}

}



