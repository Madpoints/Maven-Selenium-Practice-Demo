package selenium;

import java.util.ArrayList;
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
		
		symbol = driver.findElement(By.xpath("//td[@aria-label='Symbol']")).getText();
		name = driver.findElement(By.xpath("//td[@aria-label='Name']")).getText();
		price =driver.findElement(By.xpath("//td[@aria-label='Price (Intraday)']")).getText();
		
		tempStock.setSymbol(symbol);
		tempStock.setName(name);
		tempStock.setPrice(price);
		System.out.println(tempStock.toString());
	
//		getSymbols(driver);
//		
//		nextPage(driver);
		
		List<Stock> stocks = setStocks(driver);
		
	}
	
	public static List<Stock> setStocks(WebDriver driver) {
		
		List<WebElement> stockElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td"));
		int index = 0;
		
		for (WebElement stockElement : stockElements) {
			
			if (index % 10 == 0) {
		
				System.out.println("Index: " + index + "  Symbol: " + stockElement.getText());
				
			}
			
			index++;
			
		}
		
		return null;
	}
	
	public static void getSymbols(WebDriver driver) {
		
		List<WebElement> symbols = driver.findElements(By.xpath("//td[@aria-label='Symbol']"));
		
		for (WebElement symbol : symbols) {
			System.out.println(symbol.getText());
		}
		
	}
	
	public static void nextPage(WebDriver driver) {
		
		driver.findElement(By.xpath("//button[@data-reactid='740']")).click();
	}

}
