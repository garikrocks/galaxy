package grid;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridTest
{

	protected WebDriver driver;

	@Before
	public void init()
	{
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		// capability.setBrowserName("Chrome");
		// capability.setPlatform(Platform.WINDOWS);
		// capability.setVersion("27");

		try
		{
			driver = new RemoteWebDriver(new URL("http://192.168.24.231:4444/wd/hub"), capability);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}

		driver.get("http://www.clickandflirt.com");
		driver.manage().window().maximize();

	}

	@Test
	public void takeScreenshotOfElement() throws IOException, InterruptedException
	{
		driver.findElement(By.id("UserForm_email")).sendKeys("kertis.is@gmail.com");
	}

	@After
	public void quit()
	{
		driver.quit();
	}
}
