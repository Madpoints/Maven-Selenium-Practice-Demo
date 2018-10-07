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
		
		// path to chrome webdriver exe
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\John\\careerDevs\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.finance.yahoo.com/most-active");
		
//		getSymbols(driver);
		
		List<Stock> stocks = setStocks(driver);
		
		for (Stock stock : stocks) {
			System.out.println(stock.toString());
		}
		
		driver = nextPage(driver);
		
		stocks = setStocks(driver);
		
		for (Stock stock : stocks) {
			System.out.println(stock.toString());
		}
		
	}
	
	public static List<Stock> setStocks(WebDriver driver) {
		
		List<WebElement> stockSymbolElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='Symbol']"));
		List<WebElement> stockNameElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='Name']"));
		List<WebElement> stockPriceElements = driver.findElements(By.xpath("//table[@data-reactid='73']//td[@aria-label='Price (Intraday)']"));
		
		List<Stock> stocks = new ArrayList<Stock>();
		
		int size = stockSymbolElements.size();
		int listIndex = 0;
		
		for (int index = 0; index < size; index++) {
			
			Stock tempStock = new Stock();
			stocks.add(index, tempStock);
			
		}
		
		for (WebElement stockSymbolElement : stockSymbolElements) {
			
			stocks.get(listIndex).setSymbol(stockSymbolElement.getText());
			listIndex++;
			
		}
		
		listIndex = 0;
		
		for (WebElement stockNameElement : stockNameElements) {
			
			stocks.get(listIndex).setName(stockNameElement.getText());
			listIndex++;
			
		}
		
		listIndex = 0;
		
		for (WebElement stockPriceElement : stockPriceElements) {
			
			stocks.get(listIndex).setPrice(stockPriceElement.getText());
			listIndex++;
			
		}
		
		return stocks;
	}
	
	public static void getSymbols(WebDriver driver) {
		
		List<WebElement> symbols = driver.findElements(By.xpath("//td[@aria-label='Symbol']"));
		
		for (WebElement symbol : symbols) {
			System.out.println(symbol.getText());
		}
		
	}
	
	public static WebDriver nextPage(WebDriver driver) {
		
		driver.findElement(By.xpath("//button[@data-reactid='740']")).click();
		
		return driver;
	}

}
