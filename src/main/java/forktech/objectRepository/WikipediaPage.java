package forktech.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author dinuh
 *
 */
public class WikipediaPage
{
	//declaration
	@FindBy(xpath="//input[@class='vector-search-box-input']") private WebElement searchtbx;
	@FindBy(xpath="//input[@id='searchButton']") private WebElement searchicn;
	@FindBy(xpath="//table[@class='infobox vevent']/tbody/tr[contains(.,'Release date')]/descendant::div[@class='plainlist']/descendant::li") private WebElement releasedt;
	@FindBy(xpath="//table[@class='infobox vevent']/tbody/tr[contains(.,'Country')]/descendant::td[@class='infobox-data']") private WebElement contryname;
	@FindBy(xpath="//table[@class='infobox vevent']") private List<WebElement> tables;
	@FindBy(xpath="//a[contains(@title,'film')]") private WebElement filmLink;
	//initialization
	public WikipediaPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization
	public WebElement getSearchtbx() 
	{
		return searchtbx;
	}
	public WebElement getSearchicn() 
	{
		return searchicn;
	}
	public WebElement getReleasedt() 
	{
		return releasedt;
	}
	public WebElement getContryname() 
	{
		return contryname;
	}
	public List<WebElement> getTables() {
		return tables;
	}
	public WebElement getFilmLink() {
		return filmLink;
	}
	
	
}
