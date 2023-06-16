package jsAndActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.TestBase;

public class Class1 extends TestBase{

	@Test
	
	public void appTest() throws InterruptedException
	{
		launchBrowser("Chrome");
		driver.get("http://americangolf.co.uk/");
		WebElement golfClub=driver.findElement(By.xpath("//*[@id='header-navigation']/div/ul/li[2]/a"));
		driver.findElement(By.xpath("//*[@id='termly-code-snippet-support']/div/div/div/div/div/div[2]/button[2]")).click();
		Actions act = new Actions(driver);
		act.moveToElement(golfClub).build().perform();
		
		 // if the stale or element not found etc exception is occur
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //it helps to visible the element.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CLUBS_1']/ul/li[1]/ul/li[8]/a/span")));
	
		driver.findElement(By.xpath("//*[@id='CLUBS_1']/ul/li[1]/ul/li[8]/a/span")).click();//here is problem
		
	     driver.findElement(By.cssSelector("div.EGn_M-close")).click();
		
	}
}
