package firstprog;

//import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;

public class logo {
	
 //WebDriver driver;
    
    
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/gp/aw/c?ref_=navm_hdr_cart");
       //Assert.assertEquals("Amazon.in" , driver.getTitle());
       

	}
	    

}
