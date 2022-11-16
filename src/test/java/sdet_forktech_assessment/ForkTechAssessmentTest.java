package sdet_forktech_assessment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import forktech.genericUtility.BaseClass;
import forktech.genericUtility.ExcelUtility;
import forktech.genericUtility.FileUtility;
import forktech.genericUtility.WebDriverUtility;
import forktech.objectRepository.IMDBPage;
import forktech.objectRepository.WikipediaPage;

public class ForkTechAssessmentTest extends BaseClass
{
@Test    //date is same but format is change so fail
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
	
	int count=wiki.getTables().size();
	while(count==0) 
	{
		wiki.getFilmLink().click();
		break;
	}
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,600)");
	String releaseDatewiki=wiki.getReleasedt().getText();
	String countrywiki=wiki.getContryname().getText();
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
	Reporter.log("IMDB data for "+movieName+" "+releaseDateIMDB+" "+countryIMDB,true);
	
	SoftAssert sa=new SoftAssert();
	sa.assertEquals(releaseDateIMDB, releaseDatewiki);//fails since format change but date same
	Reporter.log("date pass",true);
	sa.assertEquals(countrywiki, countryIMDB);
	Reporter.log("country pass",true);
	sa.assertAll();
	
}
}
