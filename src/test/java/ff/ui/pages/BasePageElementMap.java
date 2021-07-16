package ff.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BasePageElementMap {
	private final WebDriver browser;
	public BasePageElementMap(WebDriver driver){
		this.browser = driver;		
		//PageFactory.initElements(driver, this); 
		 int TimeoutValue = 40;
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this); //Either we can use this keyword or classname(Test.class)
	}
	
	public WebDriver getBrowser() {
		return browser;
	}
}
