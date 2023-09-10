package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_2 {

	public static void main(String[] args) throws InterruptedException {
		//1.Open a Chrome browser.		
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(Options);
		
		driver.manage().window().maximize();
		//2.Navigate to “http://www.fb.com”
		driver.navigate().to("https://www.fb.com");
		
		String urlofthepage = driver.getCurrentUrl();
	    //3.Verify that the page is redirected to “http://www.facebook.com”, 
		//by getting the current URL. 
		//(use if-else condition to verify this condition or use Assert.assertequals() 
		//in case you are familiar with TestNG or JUnit)
		if(urlofthepage.equalsIgnoreCase("https://www.facebook.com/"))
		{
			System.out.println("Test is Pass");
		}
		else
		{
			System.out.println("Test is fail");
		}
		//4.Verify that there is a “Create an account” section on the page.
		WebElement verifying_account = driver.findElement(By.linkText("Create new account"));
		verifying_account.click();
		
		System.out.println("Test 2");
		Thread.sleep(5000);
		//5.Fill in the text boxes: First Name, Surname, Mobile Number or email address, “Re-enter mobile number”, new password.
		driver.findElement(By.name("firstname")).sendKeys("Test");
		driver.findElement(By.name("lastname")).sendKeys("User");
		driver.findElement(By.name("reg_email__")).sendKeys("Testmail@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("Testmail@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Testpassword");
		System.out.println("Test 3");
		//6.Update the date of birth in the drop-down.
		Select selDate = new Select(driver.findElement(By.id("day")));
		Select selMonth = new Select(driver.findElement(By.id("month")));
		Select selYear = new Select(driver.findElement(By.id("year")));
		
		selDate.selectByVisibleText("21");
		selMonth.selectByVisibleText("Jun");
		selYear.selectByVisibleText("1998");
		System.out.println("Test 4");
		//7.Select gender.
		
		driver.findElement(By.xpath("//input[@type='radio' and @value='2']")).click();
		//8.Click on “Create an account”.
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		//9.Verify that the account is created successfully.
		System.out.println("Test 5");
		Thread.sleep(5000);
		driver.quit();

	}

}
