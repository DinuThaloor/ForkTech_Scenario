package forktech.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author dinuh
 *
 */
public class IMDBPage
{
	//declaration
	@FindBy(xpath="//input[@id='suggestion-search']") private WebElement searchtbx;
	@FindBy(xpath="//button[@id='suggestion-search-button']") private WebElement searchicn;
	@FindAll({@FindBy(xpath="//h3[@class='findSectionHeader' and text()='Titles']/following-sibling::table/descendant::tr[@class='findResult odd']/td[@class='primary_photo']"),@FindBy(xpath="//div[@class='ipc-title ipc-title--section-title ipc-title--base ipc-title--on-textPrimary sc-17bafbdb-1 jEwIuf' and contains(.,'Titles')]/following-sibling::div/ul/li")}) private WebElement slctmovie;
	@FindBy(xpath="//li[@role='presentation' and contains(.,'Release date')]/div[@class='ipc-metadata-list-item__content-container']") private WebElement releasedt;
	@FindBy(xpath="//li[@role='presentation' and contains(.,'Country of origin')]/div[@class='ipc-metadata-list-item__content-container']") private WebElement contryname;
	//initialization
	public IMDBPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
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
	public WebElement getSlctmovie() 
	{
		return slctmovie;
	}
	public WebElement getReleasedt() 
	{
		return releasedt;
	}
	public WebElement getContryname() 
	{
		return contryname;
	}
	
}
