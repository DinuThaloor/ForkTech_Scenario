package sdet_forktech_assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import forktech.genericUtility.BaseClass;
import forktech.genericUtility.ExcelUtility;
import forktech.genericUtility.FileUtility;
import forktech.genericUtility.WebDriverUtility;
import forktech.objectRepository.IMDBPage;
import forktech.objectRepository.WikipediaPage;

public class ForkTechAllPassTest extends BaseClass
{
	@Test //eventhough date format is wrong date is same so test pass
	public void forktechTech() throws Throwable
	{
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		
		wLib.maximizeWindow(driver);
		wLib.waitTillPageLoads(driver);
		
		String movieName=eLib.getDataFromExcel("MovieSheet", 1, 0);
		WikipediaPage wiki=new WikipediaPage(driver);
		wiki.getSearchtbx().sendKeys(movieName);
		wiki.getSearchicn().click();
		WebElement page = driver.findElement(By.xpath("//html[@class='client-js ve-available']"));
		WebElement descTable = driver.findElement(By.xpath("//table[@class='infobox vevent']"));
		WebElement filmLink = driver.findElement(By.xpath("//a[contains(@title,'film')]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		String releaseDatewiki=wiki.getReleasedt().getText();
		String countrywiki=wiki.getContryname().getText();
		String []releasedatewiki=releaseDatewiki.split(" ");
		String wikidate =releasedatewiki[0];
		String wikimonth=releasedatewiki[1];
		String wikiyear=releasedatewiki[2];
		String wikipediadate=wikidate+" "+wikimonth+" "+wikiyear;
		Reporter.log("wiki data for "+movieName+" "+releaseDatewiki+" "+countrywiki,true);
		
		
		String Imdburl = fLib.getPropertyKeyValue("IMDBurl");
		driver.navigate().to(Imdburl);
		IMDBPage imdb=new IMDBPage(driver);
		imdb.getSearchtbx().sendKeys(movieName);
		imdb.getSearchicn().click();
		imdb.getSlctmovie().click();
		js.executeScript("window.scrollBy(0,6000)");
		String releaseDateIMDB=imdb.getReleasedt().getText();
		String countryIMDB=imdb.getContryname().getText();
		String []reldateIMDB=releaseDateIMDB.split(" ");
		String Imdbdate=reldateIMDB[1].substring(0, 2);
		String Imdbmonth=reldateIMDB[0];
		String Imdbyear=reldateIMDB[2];
		String IMBDdate=Imdbdate+" "+Imdbmonth+" "+Imdbyear;
		Reporter.log("IMDB data for "+movieName+" "+releaseDateIMDB+" "+countryIMDB,true);
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(IMBDdate, wikipediadate);
		Reporter.log("date pass",true);
		sa.assertEquals(countrywiki, countryIMDB);
		Reporter.log("country pass",true);
		sa.assertAll();
		
		
		
	}
}
