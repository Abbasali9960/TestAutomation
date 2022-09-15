package com;

import org.testng.annotations.Test;

import com.locators.pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class AllTest {
	private WebDriver driver = null;
	
	@Test(priority = 1)
	@Parameters({ "myURL", "myTitle" })
	public void checkHopePageUp(String myURL, String myTitle) {	    
		driver.get(myURL);	
		String title = driver.getTitle();
		Assert.assertTrue(title.contains(myTitle));
		System.out.println("Store Page is up");	
		System.out.println("**************");	
		 System.out.println('\n');
		
	}
    @Test(priority = 2)
	@Parameters({"searchTerm"})
	public void SearchTerm(String searchTerm ) {
    	driver.manage().window().maximize() ;
		pageObjects pg = new pageObjects();
		pg.pageWebDriver(driver);
	   
	   //set Search term
	   pg.setSearchTerm(searchTerm);
	   pg.clickSearchButton();
	   assert(pg.getSearchResult().toString().contains(searchTerm));
	   System.out.println("Validated Searched Result");   
	   System.out.println("**************");	
	   System.out.println('\n');
	  // driver =pg.getDriver();
	
	}
    @Test(priority = 3)
   	@Parameters({"myURL","myDress"})
   	public void selectCategoryWomen(String myURL,String myDress) { 
    	
   		pageObjects pg1 = new pageObjects();
   		pg1.pageWebDriver(driver);
   	    pg1.getUrl(myURL);
   	   //click women category
   	   pg1.clickWomenCategory();
   	   System.out.println("Women Category Clicked");   
   	   pg1.clickTopCategory();
   	   pg1.clickColor();
    	 assert(pg1.getSearchResult().toString().contains(myDress));
   	}
	
    @BeforeTest
	public void beforeTest() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
       driver.quit();
	}

}
