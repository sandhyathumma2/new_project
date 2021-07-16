package ff.ui.stepdefs;

import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;
import org.testng.Assert;

import com.aventstack.extentreports.GherkinKeyword;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import Nunc.Core.Libraries.BrowserTypes;
import Nunc.Core.Libraries.CommonUtil;
import Nunc.Core.Libraries.Driver;
import Nunc.Core.Libraries.PropertiesFileReader;
import Nunc.Reports.ExtentReportUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import ff.ui.pages.LoginPage;
import ff.ui.pages.LoginPageValidator;
import ff.ui.stepdefs.Hooks;

public class LoginSteps{

	PropertiesFileReader obj= new PropertiesFileReader(); 
	LoginPage loginelements =new LoginPage(Driver.getDriver());
	LoginPageValidator loginpage =new LoginPageValidator(loginelements);
	
	@Given("User login to FlickFusion with the correct credentials")
	public void Give_user_login_to_Salesforce_with_the_correct_credentials()throws Throwable
	{
		try{
			//Driver.StartBrowser(BrowserTypes.Chrome, 15);
			JSONObject input = CommonUtil.readJsonObject("login", "users");
			String username= input.get("username").toString();
			String password=  input.get("password").toString();
			Properties properties=obj.getProperty("resources/browser-config.properties"); 
			String url=properties.getProperty("browser.baseURL");			
			Driver.getDriver().get(url);	        
			loginpage.logintoFlickFusion(username, password);		
			ExtentReportUtil.CreateInstance().setnodestep("Given","User login to FlickFusion with the correct credentials","Successfully logged into system");
			
		}
		catch(Exception e)
		{
			//BaseUtil.scenarioDef.createNode(new GherkinKeyword("Given"), "login to application").fail("Failed to login").addScreenCaptureFromPath(extentreportUtil.ExtentReportScreenShot());

		}

	}
		
	@Then("^validate user logged as \"([^\"]*)\"$")
	public void validateUserLoggedAs(String role) throws Throwable {
		String text=loginpage.verifyLoggedAsAdmin(role);
		ExtentReportUtil.CreateInstance().setnodestep("Then","validate user logged as"+ role,"Logged in with role "+text);
        Assert.assertEquals(role, text);
	}

	@Given("^User login to FlickFusion with the \"([^\"]*)\" and \"([^\"]*)\" credentials$")
	public void userLoginToFlickFusionWithTheAndCredentials(String username, String password) throws Throwable {
		
		Properties properties=obj.getProperty("resources/browser-config.properties"); 
		String url=properties.getProperty("browser.baseURL");			
		Driver.getDriver().get(url);	        
		loginpage.logintoFlickFusion(username, password);		
		ExtentReportUtil.CreateInstance().setnodestep("Given","User login to FlickFusion with the correct credentials","Successfully logged into system");
		
	}

	@Then("^logout user$")
	public void logoutUser() throws Throwable {
		if(loginpage.logOut())
		{
			ExtentReportUtil.CreateInstance().setnodestep("Then","Logged out user","Successfully logged out from system");	
		}
	}
	
}
