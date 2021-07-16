package ff.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Nunc.Core.Libraries.Selenide;
import ff.ui.pages.BasePageElementMap;

public class LoginPage extends CommonPageElements {

	public LoginPage(WebDriver driver) {
		super(driver);		
	}
	public @FindBy(xpath="//input[@name='login']") WebElement username;
	public @FindBy(xpath="//input[@name='password']") WebElement password;
	//public @FindBy(xpath="//button[text()='Go']") WebElement goBtn;
	public @FindBy(xpath="//a[text()='Flick Fusion Admin']") WebElement admin;
	public @FindBy(xpath="//a[text()='Logout']") WebElement logout;
	public WebElement goBtn() {
		WebElement ele = null;
		try {
			ele=Selenide.getElement(By.xpath("//button[text()='Go' and @type='submit']"), 40);
		} catch (Throwable e) {
			System.out.print(e.getStackTrace());
		}
		return ele;
		
	}
	
	public WebElement adminlink(String role) {
		WebElement ele = null;
		try {
			ele=Selenide.getElement(By.xpath("//a[text()='"+role+"']"), 40);
		} catch (Throwable e) {
			System.out.print(e.getStackTrace());
		}
		return ele;
		
	}
	
	
	
	
}


