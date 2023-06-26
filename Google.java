package Excercise1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.TestBase;

public class Google extends TestBase{
	
	@Test
	
	public void appTest() throws InterruptedException
	{
		String word = "Hero";
		launchBrowser("Chrome");
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("hero");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='sbct sbre']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='sbct sbre']")));
		List<WebElement> list= driver.findElements(By.xpath("//li[@class='sbct sbre']"));
		System.out.println("size =" +list.size());
		
		for(WebElement e :list)
		{
			if(e.getText().equals(word))
			{	
			System.out.println( e.getText());
		//	System.out.println();
			e.sendKeys(Keys.ENTER);
			break;
		}
		}
		
		//driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
	}

}



