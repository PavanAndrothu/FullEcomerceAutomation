package AutomateWebsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Headers {

	WebDriver driver;
	
	public WebDriver launchbrowser(String browser, String URL) {
		
//      1. Launch the Browser
		if(browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions Options = new ChromeOptions();
			Options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
        	driver = new ChromeDriver(Options);
        	
		}else if(browser.equalsIgnoreCase("Firefox")) {
	        WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("Edge")) {
		    WebDriverManager.edgedriver().setup();
		    driver = new EdgeDriver();
		}   
               
//    2. Maximize the browser window
        driver.manage().window().maximize();
       
//    3. Delete all cookies from the browser window
        driver.manage().deleteAllCookies();
       
//    4. Enter URL and Launch the Application (https://demoqa.com/buttons)
        driver.get(URL);
		
		
		return driver;
		
		
	}

}
