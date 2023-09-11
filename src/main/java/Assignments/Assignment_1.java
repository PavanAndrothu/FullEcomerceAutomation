 package Assignments;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import AutomateWebsite.Headers;

public class Assignment_1 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		//1.Open the chrome browser.
//		ChromeOptions Options = new ChromeOptions();
//		Options.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver(Options); 
		
		 
		driver = new Headers().launchbrowser("Firefox","https://www.demoblaze.com/index.html");
		
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
		
//	    3. Take window Screenshot
	    takewindowscreenshot("Assignment1");
		
		//TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//10.Close the Browser.
		Thread.sleep(5000);
		driver.quit();
		System.out.println("Assignment_1 Pass");
		

	}
		public static void takewindowscreenshot(String name) throws IOException {
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// String path = System.getProperty("user.dir")+"\\NewSCreenshot\\"+name+".png";
			String path = System.getProperty("user.dir")+"\\Assignmen1SC\\"+name+".png";
			FileUtils.copyFile(screenshotFile, new File(path));
			System.out.println("done screenshot");

		
	}

}
