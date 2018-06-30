package webtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadWebTables {

	WebDriver driver;

	@BeforeClass
	public void setUpClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"C:\\Users\\dmitr_000\\eclipse-workspace\\automation-project\\src\\test\\java\\webtables\\webtable.html");
	}

	@Test
	public void TestReadScores() {
		WebElement table = driver.findElement(By.tagName("table"));
//		System.out.println(table.getText());
		
		List<WebElement> listElements = driver.findElements(By.tagName("tr"));
		
		System.out.println(listElements.size());
		
		for (WebElement each:listElements) {
			System.out.println(each.getText());
		}
		
		listElements = driver.findElements(By.tagName("th"));
		
		List<String> expHeaders = Arrays.asList("Team1", "Score", "Team2");
		List<String> actHeaders = new ArrayList<>();
		
		for (WebElement each : listElements) {
			actHeaders.add(each.getText());
		}
		
		Assert.assertEquals(expHeaders, actHeaders);
	}

	@AfterClass
	public void teardownClass() {
		driver.close();
	}

}
