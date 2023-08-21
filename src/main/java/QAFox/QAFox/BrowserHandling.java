package QAFox.QAFox;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserHandling {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//WebDriverManager.chromedriver().setup();
		
		//using  new chrome test
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\QAFox\\driver\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.setBinary("C:\\Users\\Admin\\Downloads\\Seleniume\\Chrome-115\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Sign Up")).click();
		Thread.sleep(2000);

		Set<String> Handle = driver.getWindowHandles();
		// driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("TanmayK");
		Iterator<String> it = Handle.iterator(); // iterator not maintained the orders
		String ParentWindowID = it.next();
		System.out.println("Parent window  id is" + ParentWindowID);
		String ChildWindowID = it.next();
		System.out.println("childwindow  id:" + ChildWindowID);


		driver.switchTo().window(ChildWindowID);
		System.out.println("childwindow title"+driver.getTitle());
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("TanmayK");
		driver.close();
		driver.switchTo().window(ParentWindowID);
		System.out.println("Parent window  title"+driver.getTitle());



		}


}
