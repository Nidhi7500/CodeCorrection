package suitea;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import testbase.TestBase;

public class GenericCalendar extends TestBase{
	
	@Test
	
	public void selectDate()
	{
		launchBrowser("Chrome");
		
		driver.get(prop.getProperty("url"));
		driver.findElement(By.linkText(prop.getProperty("doctor_name"))).click();
		
		
		 driver.findElement(By.xpath(prop.getProperty("button1"))).click();
		
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
		
		

}