package Assignments;

import java.io.File;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v104.browser.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class Assignment_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//1.Open the chrome browser.
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver(Options); 
		
		//2. Maximize the browser window
		driver.manage().window().maximize();
		
		
		Thread.sleep(5000);
		//3.Navigate to “http://qatechhub.com”.
		driver.navigate().to("https://qatechhub.com");
		
		//4.method to print

		String titleOfThePage = driver.getTitle();

		if (titleOfThePage.equals("QA Automation Tools Trainings and Tutorials | QA Tech Hub")) {
			System.out.println("Test case PASS");
		} else {
			System.out.println("Test case FAIL");
		}
		
		//5.Navigate to the Facebook page (https://www.facebook.com)
		
		driver.navigate().to("https://www.facebook.com");
		Thread.sleep(5000);
		//6.Navigate back to the QA Tech Hub website.
		driver.navigate().back();
		
		//7.Print the URL of the current page.
		System.out.println(driver.getCurrentUrl()); 
		Thread.sleep(5000);
		//8.Navigate forward.
		driver.navigate().forward();
		Thread.sleep(4000);
		//9.Reload the page.
		driver.navigate().refresh();
		TakesScreenshot scrShot =((TakesScreenshot)WebDriver);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(outputType.FILE);
		
		//10.Close the Browser.
		Thread.sleep(5000);
		driver.quit();
		System.out.println("Assignment_1 Pass");

	}

}
