package challenge02;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Amazon {

	public static void main(String[] args) 
	{
		//1.Launch the chrome browser
		System.setProperty("webdriver.chrome.driver", "./dependencies/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		
		//2.Choose Furniture
		WebElement selectDropdown = driver.findElement(By.id("searchDropdownBox"));
		Select dropdown = new Select(selectDropdown);
		dropdown.selectByVisibleText("Furniture");
		
		//3.Search for chairs for computer table
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("chairs for computer table");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		//4.Find the highest priced chair name displayed on page 1(without using sort by price option given in the webiste)
		List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		String[] priceTexts = new String[priceElements.size()];
		int[] priceInts = new int[priceElements.size()];
		int largest=0, largestIndex=0, globalRatingInt=0, fiveStarRatingNum;
		String globalRatingText, fiveStarRatingText;
		for(int priceElementsIndex=0;priceElementsIndex<priceElements.size();priceElementsIndex++)
		{
			priceTexts[priceElementsIndex] = priceElements.get(priceElementsIndex).getText().replace(",", "");
			priceInts[priceElementsIndex]=Integer.parseInt(priceTexts[priceElementsIndex]);
			//System.out.println(priceInts[priceElementsIndex]);
			if(priceInts[priceElementsIndex]>largest)
			{	
				largest=priceInts[priceElementsIndex];
				largestIndex=priceElementsIndex+1;
			}
		}
		
		//5.Also print its number of 5 ratings
		System.out.println("Largest is : "+largest+" and its index is : "+largestIndex);
		driver.findElement(By.xpath("((//span[@class='a-price-whole'])["+largestIndex+"]/preceding::div)[last()]/span[1]")).click();
		globalRatingText = driver.findElement(By.xpath("((//span[@class='a-price-whole'])["+largestIndex+"]/preceding::div)[last()]/span[2]")).getText().replace(",", "");
		globalRatingInt = Integer.parseInt(globalRatingText);
		System.out.println("Global Rating : "+globalRatingText);
		fiveStarRatingText = driver.findElement(By.xpath("//a[contains(text(),'5 star')]/following::div")).getAttribute("aria-valuenow").replace("%", "");
		fiveStarRatingNum = Integer.parseInt(fiveStarRatingText);
		System.out.println("Total number of 5 star rating :"+globalRatingInt*fiveStarRatingNum/100);		
	}

}
