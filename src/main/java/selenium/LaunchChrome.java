package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import stock.Stock;

public class LaunchChrome {

	public static void main(String[] args) {
		
		Stock tempStock = new Stock();
		String symbol, name, price;
		
		// path to chrome webdriver exe
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\John\\careerDevs\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.finance.yahoo.com/most-active");
		
		symbol = driver.findElement(By.xpath("//a[@class='Fw(b)']")).getText();
		
		tempStock.setSymbol(symbol);
		System.out.println(tempStock.toString());
	
		getSymbols(driver);
		
		nextPage(driver);
		
	}
	
	public static void getSymbols(WebDriver driver) {
		
		List<WebElement> symbols = driver.findElements(By.xpath("//a[@class='Fw(b)']"));
		
		for (WebElement symbol : symbols) {
			System.out.println(symbol.getText());
		}
		
	}
	
	public static void nextPage(WebDriver driver) {
		
		driver.findElement(By.xpath("//button[@data-reactid='740']")).click();
	}

}
