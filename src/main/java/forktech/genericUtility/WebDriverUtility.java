package forktech.genericUtility;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author dinuh
 *
 */

public class WebDriverUtility 
{
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void navigateToNewPage(WebDriver driver, String url)
	{
		driver.navigate().to(url);
	}

	public void waitTillPageLoads(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static String takeScreenshot(WebDriver driver,String screenshotName)
	{
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File src=takesScreenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/"+screenshotName+".PNG");
		try {
			FileUtils.copyFile(src, dest);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return screenshotName;
	}

	
	}

	


