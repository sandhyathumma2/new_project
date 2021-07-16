package ff.ui.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Nunc.Core.Libraries.Selenide;

public class ClinetSettingsPageElements extends CommonPageElements{
	public ClinetSettingsPageElements(WebDriver driver) {
		super(driver);		
	}
	public @FindBy(xpath="//div[@class='container']//li/a") List<WebElement> clientSettingsMenus;
	public @FindBy(xpath="//div[@class='container']//a[contains(text(),'Client Information')]") WebElement clientInfoTab;
	public @FindBy(xpath="//div[@class='container']//a[contains(text(),'Packages/Options')]") WebElement packagestab;
	public @FindBy(id="client_name") WebElement clientname;
	public @FindBy(id="client_desc") WebElement clientdesc;
	public @FindBy(id="client_dealer_id") WebElement rooftopId;
	public @FindBy(id="client_franchise_number") WebElement clientfranchisenumber;
	public @FindBy(id="client_color_span") WebElement clientcolorspan;
	public @FindBy(id="client_salesperson_name") WebElement client_salesperson_name;
	public @FindBy(id="client_address") WebElement client_address;
	public @FindBy(id="client_city") WebElement client_city;
	public @FindBy(id="client_state") WebElement client_state;
	public @FindBy(id="client_zip") WebElement client_zip;
	public @FindBy(id="client_phone") WebElement client_phone;
	public @FindBy(id="client_email_forward") WebElement client_email_forward;
	public @FindBy(id="client_url") WebElement client_url;
	public @FindBy(id="client_fb_id") WebElement client_fb_id;
	public @FindBy(name="client_comments") WebElement client_comments;
	public @FindBy(xpath="//button[@class='btn btn-primary']") WebElement btnsavechanges;
	
	//packages section
	public @FindBy(xpath="//div[@class='container']//li//a") List<WebElement> clientsettingtab;
	public @FindBy(xpath="//div[@id='client_inventory_video']//label") List<WebElement> checkboxlables;
	public @FindBy(xpath="//div[@id='client_inventory_video']//input") List<WebElement> checkboxes;
	
	public @FindBy(xpath="//button[@class='btn btn-primary']") WebElement options;
	public @FindBy(id="a_client_marketing_video") WebElement a_client_marketing_video;
	public @FindBy(id="a_client_autoflicks") WebElement a_client_autoflicks;
	public @FindBy(id="a_client_legacy") WebElement a_client_legacy;
	public @FindBy(id="a_client_all_options") WebElement a_client_all_options;
	public @FindBy(id="a_client_inventory_video") WebElement a_client_inventory_video;
	//package tab title
	public @FindBy(xpath="//h4[contains(text(),'Packages/Options')]") WebElement packagetitle;
	
	//Add client section
	
	public @FindBy(xpath="//a//span[@id='client_filter' and text()='Add Client']") WebElement addclientbtn;
	
	public WebElement ClientTab(String tab) throws Throwable
	{
		WebElement tabelement =Selenide.getElement(By.xpath("//div[@class='container']//a[contains(text(),'"+tab+"')]"), 20);
		return tabelement;		
	}
	public List<WebElement> ClientTabs(String tab) throws Throwable
	{
		List<WebElement> tabelements =Selenide.getElements(By.xpath("//div[@class='container']//a"), 20);
		return tabelements;		
	}
	public WebElement Inputcontrolbyid(String id) throws Throwable
	{
		WebElement tabelement =Selenide.getElement(By.id(id), 20);
		return tabelement;		
	}
	
	public WebElement EditActions(String columntext) throws Throwable
	{
		WebElement tabelement =Selenide.getElement(By.xpath("//table[@id='datatabletable_id_rm']//td[contains(text(),'"+columntext+"')]/..//a[contains(text(),'Edit Account')]"), 20);
		return tabelement;		
	}
	
	public WebElement ClientLink() throws Throwable {
		WebElement tabelement =Selenide.getElement(By.xpath("//div[@class='nav-collapse']//ul//li//a[contains(text(),'Clients')]"), 20);
		return tabelement;	
	}
	public WebElement editclientsearch() throws Throwable {
		WebElement tabelement =Selenide.getElement(By.xpath("//input[@type='search']"), 20);
		return tabelement;	
	}
	
	
}
