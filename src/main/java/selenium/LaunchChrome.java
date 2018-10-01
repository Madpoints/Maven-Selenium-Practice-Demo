package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {

	public static void main(String[] args) {
		
		// path to chrome webdriver exe
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\John\\careerDevs\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.finance.yahoo.com/most-active");
		List<WebElement> symbols = driver.findElements(By.xpath("//a[@class='Fw(b)']"));
		
		for (WebElement symbol : symbols) {
			System.out.println(symbol.getText());
		}
		
	}

}
