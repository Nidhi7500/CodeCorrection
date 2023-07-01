package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;

public class Amazon extends TestBase {

	@Test

	public void appTest() throws InterruptedException {
		launchBrowser("Chrome");
		driver.get("https://www.amazon.ca/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone10");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
	List<WebElement> phoneNames = driver.findElements(By.cssSelector("div.a-section.a-spacing-none.a-spacing-top-small.s-title-instructions-style"));
	List<WebElement> prices = driver.findElements(By.cssSelector("div.a-section.a-spacing-none.a-spacing-top-small.s-price-instructions-style"));
	System.out.println(phoneNames.size());
	System.out.println(prices.size());
	
	int cheapestPrice = 0;

		for (int i = 0; i < phoneNames.size(); i++) {
			//int p= 300;
			if (i == prices.size()) {
				break;
			}
			String price = prices.get(i).getText().split("\n")[0].substring(1);
			if (cheapestPrice == 0 || (price.matches("\\d+") && Integer.valueOf(price) < cheapestPrice)) {
				cheapestPrice = Integer.valueOf(price);

			}
			//if(price. p )// no idea what to write here
			// i want to display and click on cheapest price.
	/*	{
			
			System.out.println(phoneNames.get(i).getText()+"------------"+price);
			
		break;
	}*/
		}
		System.out.println("cheapest Price is " + cheapestPrice);
	}
}
