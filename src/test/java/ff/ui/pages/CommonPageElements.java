package ff.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Nunc.Core.Libraries.Selenide;

public class CommonPageElements extends BasePageElementMap{

	public CommonPageElements(WebDriver driver) {
		super(driver);		
	}
	public @FindBy(xpath="//div[contains(text(),'Loading')]") WebElement loading;
	
	public WebElement loadingelement()
	{
	WebElement ele = null;
		try {
			ele = Selenide.getElement(By.xpath("//div[contains(text(),'Loading')]"), 60);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ele;
	}
	
}