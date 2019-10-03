package task2;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hostelworld.com/");

		WebElement searchBox = driver.findElement(By.id("home-search-keywords"));
		searchBox.sendKeys("Dublin");
		searchBox.submit();

		WebElement result = driver.findElement(By.xpath("//ul[@class='suggestions']/li[@class='hover']"));
		result.click();

		WebElement button = driver.findElement(By.className("btn btn-primary btn-block mt-4 submit-search-form"));
		button.click();
	}
}
