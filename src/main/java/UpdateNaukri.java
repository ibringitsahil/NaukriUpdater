
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadExecutionException;

public class UpdateNaukri {
	WebDriver driver;

	@Test
	public void nauk() throws  InterruptedException{
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/nlogin/logout");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,15);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("usernameField"))));
		driver.findElement(By.id("usernameField")).sendKeys("ibringitsahil@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("ibringit");
		Thread.sleep(1000);
		driver.findElement(By.id("passwordField")).submit();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("UPDATE PROFILE"))));
		driver.findElement(By.linkText("UPDATE PROFILE")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class='resumeHeadline']/div/div/div/span[2]"))));
		driver.findElement(By.xpath("//*[@class='resumeHeadline']/div/div/div/span[2]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("resumeHeadlineTxt"))));
		driver.findElement(By.id("resumeHeadlineTxt")).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.chord(Keys.CONTROL,"a")).sendKeys(Keys.DELETE).build().perform();
		Thread.sleep(1000);
		Random rd = new Random();
		driver.findElement(By.id("resumeHeadlineTxt")).sendKeys("Software Tester, 2.6+ yrs of experience in Automation(Selenium)/Manual Testing | Java| TestNG | SQL | GITHUB | log4j | Page object model | ExtentReports | Java Script | Defect Tracking Tool- TargetProcess." +rd.nextInt(10));
		Thread.sleep(1000);
		driver.findElement(By.id("resumeHeadlineTxt")).submit();
		System.out.println("Pass");
		
		
		
	}

}
