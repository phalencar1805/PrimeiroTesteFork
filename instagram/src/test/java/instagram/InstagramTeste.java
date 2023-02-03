package instagram;



import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InstagramTeste {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
		driver.manage().window().maximize();

	}

	@After
	public void setDown() throws Exception {
		TimeUnit.SECONDS.sleep(6);
		TakesScreenshot srcShot = (TakesScreenshot) driver;
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./evidencias/" + "Evidencia Instagram" + ".png");
		FileUtils.copyFile(srcFile, destFile);
		
		

	}

	@Test
	public void test() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("phalencar1805");
		driver.findElement(By.name("password")).sendKeys("Pedroh18!");
		driver.findElement(By.xpath("//button[@class='sqdOP  L3NKy   y3zKF     ']")).click();

	}

}
