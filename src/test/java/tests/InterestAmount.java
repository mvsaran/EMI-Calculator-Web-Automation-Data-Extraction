package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InterestAmount {

public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true); // ✅ Ignore SSL certificate errors
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		String principalLoanamountXpath = "//*[name()='svg']//*[local-name()='g' and @class = 'highcharts-label highcharts-data-label highcharts-data-label-color-0']//*[name()='text']";
		String principalLoanamount = driver.findElement(org.openqa.selenium.By.xpath(principalLoanamountXpath)).getText();
		System.out.println("Principal Loan Amount: " + principalLoanamount);
		
		String totalInterestXpath ="//*[name()='svg']//*[local-name()='g' and @class = 'highcharts-label highcharts-data-label highcharts-data-label-color-1']//*[name()='text']";
		String totalInterest = driver.findElement(org.openqa.selenium.By.xpath(totalInterestXpath)).getText();
		System.out.println("Total Interest Amount: " + totalInterest);
		
		driver.quit();
}
        
}