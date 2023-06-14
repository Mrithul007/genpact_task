package pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class SauceDemo {
	
	WebDriver driver;
	@Test(dataProvider="testdata")
	
	public void DemoProject(String username, String password) 
	{
		System.setProperty("webdriver.gecko.driver","D:\\STC\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.name("user-name")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login-button")).click();
		driver.findElement(By.xpath("//html/body/div/div/div/div[1]/div[2]/div/span/select")).click();
		driver.findElement(By.xpath("//html/body/div/div/div/div[1]/div[2]/div/span/select/option[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
		driver.findElement(By.xpath("//html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-onesie\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bike-light\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
		driver.findElement(By.name("firstName")).sendKeys("Mrithul");
		driver.findElement(By.name("lastName")).sendKeys("Sudhakaran");
		driver.findElement(By.name("postalCode")).sendKeys("691333");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
		driver.close();
		
	}
	
	@DataProvider(name="testdata")
	public Object[][] TestDataFeed()
	{
		ReadExcelFile config = new ReadExcelFile("D:\\STC\\genpro.xlsx");
		
		int rows = config.getRowCount(0);
		
		Object[][] credntls = new Object[rows][2];
		
		for(int i=0;i<rows;i++) 
		{
			credntls[i][0] = config.getData(0,i,0);
			credntls[i][1] = config.getData(0,i,1);
		}
		return credntls; 
	}

}
