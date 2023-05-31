package suitea;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import testbase.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		/**
		 * As there is no MonthYearPicker element present on the Page, it was throwing NoSuchElementFound Exception
		 * This might be present in the old HTML code and date picker might be introduced later on.
		 * So we need to select month and year separately as they are 2 different dropdowns now.
		 */
		//String monthYearDisplayed =	 driver.findElement(By.cssSelector("MonthYearPicker")).getText();
		Select selectMonth = new Select(driver.findElement(By.cssSelector(".ui-datepicker-month")));
		String monthDisplayed = selectMonth.getFirstSelectedOption().getText();
		Select selectYear = new Select(driver.findElement(By.cssSelector(".ui-datepicker-year")));
		String yearDisplayed = selectYear.getFirstSelectedOption().getText();
		System.out.println(monthDisplayed + " " + yearDisplayed);
			 
		
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date DateToBeSelected = sd.parse(dob);
			Date CurrentDate=new Date();
			String day = new SimpleDateFormat("dd").format(DateToBeSelected);
			System.out.println(day);
			String month = new SimpleDateFormat("MM").format(DateToBeSelected);
			System.out.println(month);
			String year = new SimpleDateFormat("yyyy").format(DateToBeSelected);
			System.out.println(year);
			String MonthYearToBeSelected = month+"    " +year;
			System.out.println(MonthYearToBeSelected);

			String dateToSend = month+"/"+day+"/"+year;

			driver.findElement(By.id("req_datebirth")).sendKeys(dateToSend);
			driver.findElement(By.id("req_submit")).click();

			
		/*	while(!MonthYearToBeSelected.equals(monthDisplayed+"    "+yearDisplayed))
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
				//Commneted this piece of code to avoid compilation issues. need to discuss the test scenario to fix this.
				*//* monthYearDisplayed =	 driver.findElement(By.cssSelector(prop.getProperty("MonthYearPicker"))).getText();
					System.out.println(monthYearDisplayed);*//*
			}*/
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 // driver.close();
		
		}
		
		

}