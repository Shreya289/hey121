package testcase1;

//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

	

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
        driver.quit();

 

	}
	

}
