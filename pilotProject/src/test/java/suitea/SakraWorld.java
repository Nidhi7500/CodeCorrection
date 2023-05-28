package suitea;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import testbase.TestBase;



public class SakraWorld extends TestBase  {

	
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
	 
	 
	 
	 
		if (!IsElementPresent(prop.getProperty("requestNameId")));
			softAssert("Name box is not Present");
			
			log("Finding box name");
			Thread.sleep(2000);
			
			
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
	 
	 String dob = (prop.getProperty("date"));
	 
	 //dynamic date selection logic
	 String monthYearDisplayed =	 driver.findElement(By.cssSelector("MonthYearPicker")).getText();
	System.out.println(monthYearDisplayed);
		 
	
	SimpleDateFormat sd = new SimpleDateFormat("MM-dd-yyyy");
	try {
		Date DateToBeSelected = sd.parse(dob);
		Date CurrentDate=new Date();
		String day = new SimpleDateFormat("dd").format(DateToBeSelected);
		System.out.println(day);
		String month = new SimpleDateFormat("MMM").format(DateToBeSelected);
		System.out.println(month);
		String year = new SimpleDateFormat("yyyy").format(DateToBeSelected);
		System.out.println(year);
		String MonthYearToBeSelected = month+"    " +year;
		System.out.println(MonthYearToBeSelected);
		
		while(!MonthYearToBeSelected.equals(monthYearDisplayed))
		{
			if(DateToBeSelected.compareTo(CurrentDate) == 1)
			{
				//forward icon click
				
				// driver.findElement(By.xpath(prop.getProperty("FarwordButton"))).click();
			}else if(DateToBeSelected.compareTo(CurrentDate)== -1)
			{
				//back icon click
				driver.findElement(By.xpath(prop.getProperty("BackButton"))).click();
			}
			 monthYearDisplayed =	 driver.findElement(By.cssSelector(prop.getProperty("MonthYearPicker"))).getText();
				System.out.println(monthYearDisplayed);
		}
		
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 // driver.close();
	
	}
	
	
	
	
	// this function will check the presence and visibility of the element
	//true = element present
	// false = element not present or hidden
	public boolean IsElementPresent(String Locator)
	{
		WebElement e = null;
		// presence
		try {
		e = driver.findElement(By.id(Locator));
		}catch(Exception ex)
		{
			log("Exception while extracting the object"+ex.getMessage());
			return false;
		}
		
		// visibility
		
		log("visibility Status" +e.isDisplayed());
			if(!e.isDisplayed())
				return false;
		
			
			// reach here means element is present 
			
			return true;
	}
	
	
	
	
	
	
	public void waitForPageToLoad()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i=0;
		
		while(i!=10)
		{
			String state = (String)js.executeScript("return document.readState;");
			System.out.println(state);
			
			if(state.equals("complete"))
				break;
			else
				wait(2);
			
			i++;
		}
		
		i=0;
		while(i!=10)
		{
			Long d = (Long) js.executeScript("return jQuery.active;");
			System.out.println(d);
			
			if(d.longValue()==0)
					break;
			else
				wait(2);
			
			i++;
		}
	}
	public void wait(int time)
	{
		try {
			Thread.sleep(time*1000);
			
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
}

