package Excercise1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.TestBase;

public class Facebook extends TestBase {

	@Test

	public void appTest() throws InterruptedException {
		launchBrowser("Chrome");
		driver.get("https://www.facebook.com/");
		driver.findElement(By.cssSelector("div._6lux>input")).sendKeys("sharma02788@gmail.com");
		driver.findElement(By.cssSelector("div._6lux>div>input")).sendKeys("9872281072R_n");
		driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='निधि ऋषि भनोट']")));
		driver.findElement(By.xpath("//span[text()='निधि ऋषि भनोट']")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='x9f619 x1ja2u2z x1xzczws x7wzq59']//div/a[3]")));
		driver.findElement(By.xpath("//div[@class='x9f619 x1ja2u2z x1xzczws x7wzq59']//div/a[3]")).click();

		
		
		
		/*
		  int countBeforeScroll=0;
		  while(true) 
		  { 
			 List<WebElement> friends = driver.findElements(By.xpath("//div[@class='x1iyjqo2 x1pi30zi']/div[1]//span" )); 
			 System.out.println(countBeforeScroll+"=="+friends.size());
		  
		  if(countBeforeScroll==friends.size()) 
		  {
			  break;
			  }
		  
		  countBeforeScroll=friends.size();
		  
		  
		  int y = friends.get(friends.size()-1).getLocation().y;
		  
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("window.scrollTo(0,"+y+")"); }
		  Thread.sleep(3000);
		 
	}*/
	
								
						 
		
		  List<WebElement> friends =  driver.findElements(By.xpath("//div[@class='x1iyjqo2 x1pi30zi']/div[1]//span" )); 
		  //System.out.println(friends.size());
			for(int i =0;i<friends.size();i++)
			{ 
				 System.out.println(i+"="+friends.size());
		  if(i==friends.size())
		  {
			  break;
		 }
		 i=friends.size();
		  int y = friends.get(friends.size()-1).getLocation().y;
		  
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("window.scrollTo(0,"+y+")");
		  Thread.sleep(4000);
		  }
		 
	}
}

