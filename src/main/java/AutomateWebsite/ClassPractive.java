package AutomateWebsite;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ClassPractive {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		
//1.launch the application
		 
		driver = new Headers().launchbrowser("Firefox","https://www.demoblaze.com/index.html");
		
//2. Click on Laptops from categories
		WebElement laptop = driver.findElement(By.xpath("//a[text()='Laptops']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", laptop);
		
		laptop.click();
		System.out.println("2.locating and clicking on web element of laptop is done");
		
		Thread.sleep(5000);
		
		
//3.Click the laptop Macbook pro ($1100)
		WebElement MacBookPro = driver.findElement(By.xpath("//a[text() = 'MacBook Pro' and @class = 'hrefch'] "));
		
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js2.executeScript("arguments[0].scrollIntoView()", MacBookPro);
		
		MacBookPro.click();
		System.out.println("3.clicking of web element of macbook pro is done");
		
		Thread.sleep(5000);
		
		
//4. Add to cart
		WebElement cart = driver.findElement(By.xpath("//a[text()='Add to cart']"));
		
		cart.click();
		Thread.sleep(5000);
//5. Verify alert message (Product added) and click on ok
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		alert.accept();
		
		System.out.println("5. accepting the alert is fine");

		Thread.sleep(5000);
//		6. Click on Cart menu
		WebElement cart_menu = driver.findElement(By.xpath("//a[text()='Cart']"));
		
		cart_menu.click();
		Thread.sleep(5000);
		
		
//		7. Check whether product is added into cart and click on place order
		WebElement placeorder = driver.findElement(By.xpath("//button[text()='Place Order']"));
		
		placeorder.click();
		Thread.sleep(5000);
		System.out.println("7. clicked on place order");
		
		Thread.sleep(5000);
//		8. Fill all the details and click on ‘Purchase; button
		WebElement name = driver.findElement(By.xpath("//input[@id= 'name']"));
		name.sendKeys("pavan");
		
		WebElement country = driver.findElement(By.xpath("//input[@id= 'country']"));
		country.sendKeys("ind");
		
		WebElement city = driver.findElement(By.xpath("//input[@id= 'city']"));
		city.sendKeys("hyd");
		
		WebElement card = driver.findElement(By.xpath("//input[@id= 'card']"));
		card.sendKeys("54321");
		
		WebElement month = driver.findElement(By.xpath("//input[@id= 'month']"));
		month.sendKeys("09");
		
		WebElement  year = driver.findElement(By.xpath("//input[@id= 'year']"));
		year.sendKeys("2022");
		
		
		WebElement  purchase = driver.findElement(By.xpath("//button[text()= 'Purchase']"));
		purchase.click();
		
		
		Thread.sleep(5000);
		
//	    3. Take window Screenshot
	    takewindowscreenshot("purchasewindow");
		
//		9. Print the Order Details
		System.out.println("done");
//		10. Close the browser
		driver.quit();
	}

	public static void takewindowscreenshot(String name) throws IOException {
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// String path = System.getProperty("user.dir")+"\\NewSCreenshot\\"+name+".png";
		String path = System.getProperty("user.dir")+"\\Scc\\"+name+".png";
		FileUtils.copyFile(screenshotFile, new File(path));
		System.out.println("done screenshot");
	}
}
