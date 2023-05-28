package suitea;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import testbase.TestBase;

public class TriedCode  extends TestBase 
{

	
	@Test
	public void appointmentTest() throws InterruptedException 
	{
		
	
		launchBrowser ("Chrome");
		log("openBrowser");
		driver.get(prop.getProperty("url"));
		//waitForPageToLoad();
		driver.findElement(By.linkText(prop.getProperty("doctor_name"))).click();
		
		
	 driver.findElement(By.xpath(prop.getProperty("button1"))).click();
	 
		//validate the presence and visibility e.g name,email boxes etc
	// ********************Explicit Wait******************************
	 
	 
	 
	
			
			
	 driver.findElement(By.id(prop.getProperty("requestNameId"))).sendKeys(prop.getProperty("firstname"));
	 driver.findElement(By.id(prop.getProperty("requestEmailId"))).sendKeys(prop.getProperty("email_id"));
	 driver.findElement(By.id(prop.getProperty("requestMobile"))).sendKeys(prop.getProperty("phnNo."));
	 //******************validate the gender options**************************
	 
	 
	 
	 
	 
	 WebElement gender= driver.findElement(By.name(prop.getProperty("requestGender")));
	 Select s = new Select(gender);
	 s.selectByVisibleText("Female");
	 
	 
	// if(driver.findElement(By.id(prop.getProperty("UHID"))).isDisplayed())
		// failAndStop("UHID is Displayed");
	// else(!driver.findElement(By.id(prop.getProperty("UHID"))).isDisplayed())
	 
 driver.findElement(By.id(prop.getProperty("DOB"))).click();
	
//	WebElement DAY= driver.findElement(By.xpath(prop.getProperty("Day")));
//	 Select sd = new Select(DAY);
//	 sd.selectByVisibleText(prop.getProperty("day"));
	
	 WebElement MONTH= driver.findElement(By.className(prop.getProperty("Month")));
	 Select sm = new Select(MONTH);
	 sm.selectByVisibleText("Feb");
	 
	 
	 WebElement YEAR= driver.findElement(By.className(prop.getProperty("Year")));
	 Select sy = new Select(YEAR);
	 sy.selectByVisibleText("2014"); 
	 
	 
	 String dob = (prop.getProperty("date"));{
	
	System.out.println(dob);
	 }
	}

}
