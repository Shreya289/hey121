package com.testng.selenium.PriceLabsAutomation.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	WebDriver driver;
	private WebDriverWait wait;

	By username = By.xpath("//input[@id='user_email']");
	By password = By.xpath("//input[@id='user_password']");
	By signInButton = By.xpath("//input[@type='submit']");
	By showAllListingsButton=By.xpath("//button[@id='apply-filter']");
	By pricingDashboardTable=By.xpath("//table[@id='table']");
	By dynamicPricingDropdown=By.xpath("(//a[@class='nav-link dropdown-toggle'])[1]");
	By manageListingOption=By.xpath("(//a[@class='dropdown-item'])[3]");
	By firstMinPrice=By.xpath("(//tbody//tr[1]//td[8])[1]//input");
	By firstMaxPrice=By.xpath("(//tbody//tr[1]//td[10])[1]//input");
	
	By priceLabslogo=By.xpath("//a[@title='PriceLabs']");
    By reviewPricesbutton=By.xpath("((//tbody)[9]//td)[2]//a");
    By nextButton=By.xpath("(//button[@class='btn-prev-next-common next-btn'])[2]");
    
    By profileLink=By.xpath("//a//div[@class='profile-name']");
    By billingOption=By.xpath("(//ul)[18]//li[2]//a");
    By addNewCardButton=By.xpath("//button[@id='add-credit-button']");
    By billingDetailsButton=By.xpath("//ul[@id='billing-nav']//li[4]//a");
    By saveSettingsButton=By.xpath("//div[@class='account_footer']//input");
    
    By multiCalendarOption=By.xpath("(//a[@class='dropdown-item'])[2]");
    By tableInMultiCalendar=By.xpath("//div[@id='mc-main']//table");
    By moreOptionsButton=By.xpath("//div[@id='mc-main']//table//tbody//tr[3]//td[2]//div[2]//button");
    By editCustomizationOption=By.xpath("//div[@class='chakra-portal']//button[5]");
    By generalLink=By.xpath("(//div[@class='chakra-collapse']//div//button)[1]");
    By customizeLastMinuteToggle=By.xpath("(//input[@class='chakra-switch__input'])[16]");
    By fixedDropdown=By.xpath("(//select[@class='chakra-select css-nldtbv'])[2]");
    By withinTextField=By.xpath("(//div[@class='chakra-input__group css-1xtoim8'])[3]//div//input");
    By daysTextField=By.xpath("(//div[@class='chakra-input__group css-1xtoim8'])[4]//div//input");
    
   //1)Changing minimum and maximum pricing inside manage listings
	public Page(WebDriver driver) {
		this.driver = driver;
		 wait=new WebDriverWait(driver,  Duration.ofSeconds(10));
	}

	public void setUsername(String strUsername) {
		driver.findElement(username).sendKeys(strUsername);
	}

	public void setPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}

	public void clickLogin() {
		driver.findElement(signInButton).click();
	}

	public void loginToApplication(String strUsername, String strPassword) {
		
		WebElement usernameTextFieldWait=wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		this.setUsername(strUsername);
		this.setPassword(strPassword);
		this.clickLogin();
	}
	public void  viewListingsPopup()
	{
		
		WebElement showAllListingsWait=wait.until(ExpectedConditions.elementToBeClickable(showAllListingsButton));
		driver.findElement(showAllListingsButton).click();
	}
	
	public void manageListingsDropdown(String minPricing, String maxPricing)
	{
		
		WebElement pricingDashboardTableWait=wait.until(ExpectedConditions.visibilityOfElementLocated(pricingDashboardTable));
		driver.findElement(dynamicPricingDropdown).click();
		driver.findElement(manageListingOption).click();	
		viewListingsPopup();
		WebElement pricingWait=wait.until(ExpectedConditions.elementToBeClickable(firstMinPrice));
		driver.findElement(firstMinPrice).clear();
		driver.findElement(firstMinPrice).sendKeys(minPricing);
		driver.findElement(firstMaxPrice).clear();
		driver.findElement(firstMaxPrice).sendKeys(maxPricing);
		
	}
	
	//2)Clicking on review prices button in Pricing Dashboard
	public void clickOnPriceLabsLogo()
	{
		driver.findElement(priceLabslogo).click();
	}
	
	public void clickOnReviewPrices()
	{
		WebElement pricingDashboardTableWait=wait.until(ExpectedConditions.visibilityOfElementLocated(pricingDashboardTable));
		driver.findElement(reviewPricesbutton).click();
		WebElement nextButtonWait=wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton));
		
	}
	
	//3)Navigation to billing Details under profile dropdown
	public void navigationToBillingDetailsUnderProfile()
	{
		driver.findElement(profileLink).click();
		driver.findElement(billingOption).click();
		WebElement addNewCardButtonWait=wait.until(ExpectedConditions.visibilityOfElementLocated(addNewCardButton));
		driver.findElement(billingDetailsButton).click();
		WebElement saveSettingsButtonWait=wait.until(ExpectedConditions.visibilityOfElementLocated(saveSettingsButton));
	}
	
	//4)Operations under Multicalendar option
	public void operationUnderMulticalendar(String within , String days)
	{
		driver.findElement(dynamicPricingDropdown).click();
		 String originalWindow = driver.getWindowHandle();
		driver.findElement(multiCalendarOption).click();
		
		// Wait for the new window or tab
	        Set<String> allWindows = driver.getWindowHandles();
	        while (allWindows.size() == 1) {
	            allWindows = driver.getWindowHandles();
	        }

	        // Iterate through window handles and switch to the new window
	        for (String windowHandle : allWindows) {
	            if (!windowHandle.equals(originalWindow)) {
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }
	        
	        WebElement tableInMultiCalendarWait=wait.until(ExpectedConditions.visibilityOfElementLocated(tableInMultiCalendar));
	        driver.findElement(moreOptionsButton).click();
	        driver.findElement(editCustomizationOption).click();
	        WebElement generalLinkWait=wait.until(ExpectedConditions.visibilityOfElementLocated(generalLink));
	        driver.findElement(generalLink).click();
//	        if(driver.findElement(customizeLastMinuteToggle).isSelected()&&driver.findElement(fixedDropdown).getText().equals("Fixed"))
//	        {
//	        	driver.findElement(withinTextField).clear();
//	        	driver.findElement(withinTextField).sendKeys(within);
//	        	driver.findElement(daysTextField).clear();
//	        	driver.findElement(daysTextField).sendKeys(days);
//	        }
//	        else
//	        {
//	        	driver.findElement(customizeLastMinuteToggle).click();
//	        	Select drpdiscount = new Select(driver.findElement(By.xpath("(//select[@name='last_min_factor_type'])[2]")));
//	        	drpdiscount.selectByVisibleText("Fixed");
//	        	driver.findElement(withinTextField).clear();
//	        	driver.findElement(withinTextField).sendKeys(within);
//	        	driver.findElement(daysTextField).clear();
//	        	driver.findElement(daysTextField).sendKeys(days);
//	        }
//	        	
	        driver.findElement(withinTextField).clear();
         	driver.findElement(withinTextField).sendKeys(within);
     	    driver.findElement(daysTextField).clear();
      	    driver.findElement(daysTextField).sendKeys(days);
	        
	        
	}
	

}
