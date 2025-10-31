package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGGraphHandle {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true); // ✅ Ignore SSL certificate errors
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		String barText ="//*[local-name()='svg']//*[local-name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[local-name()='text']";
		String verticalXpath ="//*[local-name()='svg']//*[name()='g' and @class ='highcharts-series-group']//*[name()='rect']";
		List<WebElement> verticalBars = driver.findElements(By.xpath(verticalXpath));
		System.out.println("Number of vertical bars: "+verticalBars.size());
		
		Actions act = new Actions(driver);
		for (WebElement bar : verticalBars) {
			act.moveToElement(bar).perform();
			Thread.sleep(100);
			String text = driver.findElement(By.xpath(barText)).getText();
			System.out.println("Bar details: " + text);
		}
		
		
		driver.quit();
	}

}
