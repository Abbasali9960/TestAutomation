package com.locators;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class pageObjects {
	
	WebDriver driver;
	By topSearch = By.id("search_query_top");
	By searchButton= By.name("submit_search")	;		
    By searchResult = By.xpath("*//div[@class='product-container']//a[@class='product-name']");
    By womenCategory = By.xpath("//a[@title='Women']");
    By categoryTop = By.id("uniform-layered_category_4");
    By selectColor = By.id("ul_layered_id_attribute_group_3");
    		
    public void pageWebDriver(WebDriver driver) {
	this.driver = driver;
	}
    public void getUrl(String Url)
    {
    	driver.navigate().to(Url);
    }
    public void setSearchTerm(String searchTerm)
	{
		driver.findElement(topSearch).sendKeys(searchTerm);
	}
	
    public void clickSearchButton()
	{
		driver.findElement(searchButton).click();
	}
    public String getSearchResult()
    {
    	return driver.findElement(searchResult).getText();
    }
    public void clickWomenCategory()
    {
    	driver.findElement(womenCategory).click();
    }
    public WebDriver getDriver()
    {
    	return driver;
    	
    }
    public void clickTopCategory()
    {
    	driver.findElement(categoryTop).click();
    }
    public void clickColor()
    {
    	driver.findElement(selectColor).click();
    }
}