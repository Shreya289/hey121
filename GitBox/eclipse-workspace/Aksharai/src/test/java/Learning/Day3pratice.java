package Learning;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Day3pratice {

    public static void main(String[] args) throws InterruptedException {
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/home-kitchen/home-appliances/washing-machines/fully-automatic-front-load~function/pr?sid=j9e%2Cabm%2C8qx&otracker=nmenu_sub_TVs%20%26%20Appliances_0_Fully%20Automatic%20Front%20Load");
        driver.manage().deleteAllCookies();
        WebElement element = driver.findElement(By.xpath("//div[text()='BOSCH 10 kg Fully Automatic Front Load Washing Machine Black, Grey']"));
       
        //Actions action = new Actions(driver);
        
        //action.contextClick(element).perform();
        
        
                Actions action = new Actions(driver);
                driver.findElement(By.xpath("//a[text()='Login']")).click();

        action.moveToElement(element).perform();
        
        }
    }
