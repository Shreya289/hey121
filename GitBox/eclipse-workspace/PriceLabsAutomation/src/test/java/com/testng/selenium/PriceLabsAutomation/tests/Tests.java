package com.testng.selenium.PriceLabsAutomation.tests;

import static org.junit.Assert.assertArrayEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.testng.selenium.PriceLabsAutomation.pages.Page;
import com.testng.selenium.PriceLabsAutomation.utils.ConfigReader;

public class Tests {
	WebDriver driver;
    Page page;
    ConfigReader configReader;
   
    

    @BeforeTest
    public void setup() {
        configReader = new ConfigReader();
        System.setProperty("webdriver.edge.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://pricelabs.co/signin");
        driver.manage().window().maximize();
       page = new Page(driver);
    }

    @Test(priority=1,enabled=true)
    public void testLogin() {
        String username = configReader.getProperty("username");
        String password = configReader.getProperty("password");
        page.loginToApplication(username, password);
      Assert.assertEquals("PriceLabs - Dashboard", driver.getTitle());
    }
    
    @Test(priority=2,enabled=true)
    public void testLisitingsPopup()
    {
    	page.viewListingsPopup();
    }
    
    @Test(priority=3,enabled=true)
    public void testmanageListingsDropdown()
    {
    	page.manageListingsDropdown(configReader.getProperty("minpricing"), configReader.getProperty("maxpricing"));
    }
    
    @Test(priority=4,enabled=true)
    public void clickOnPriceLabsLogoTest()
    {
    	page.clickOnPriceLabsLogo();
    	page.viewListingsPopup();
    }
    
    @Test(priority=5,enabled=true)
    
    public void clickOnReviewPricesTest()
    {
    	page.clickOnReviewPrices();
    	
    }
    
    @Test(priority=6,enabled=true)
    public void navigationToBillingDetailsUnderProfileTest()
    {
    	page.navigationToBillingDetailsUnderProfile();
    }
    
    @Test(priority=7,enabled=true)
    public void operationUnderMulticalendarTest()
    {
    	page.operationUnderMulticalendar(configReader.getProperty("within"), configReader.getProperty("days"));
    }

    @AfterTest
    public void teardown() {
       // driver.quit();
    }

}
