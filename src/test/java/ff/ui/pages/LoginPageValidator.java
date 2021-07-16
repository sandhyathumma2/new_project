package ff.ui.pages;

import org.openqa.selenium.WebElement;

import Nunc.Core.Libraries.Selenide;

public class LoginPageValidator extends BasePageValidator<LoginPage> {

	public LoginPageValidator(LoginPage Map) {
		super(Map);		
	}
    public void logintoFlickFusion(String username,String password) throws Throwable
    {
    	try {
          this.getMap().username.sendKeys(username);
          this.getMap().password.sendKeys(password);
          this.getMap().goBtn().click();         
    	}
    	catch(Exception ex) {
    	System.out.print(ex.getMessage());
    		
    	}
    }
    public String verifyLoggedAsAdmin(String role) throws Throwable
    {
    	String text ="";
    	try {         
      //  text= this.getMap().admin.getText();    
    	text=this.getMap().adminlink(role).getText();
        return text;
    	//this.getMap().getBrowser().
    	}
    	catch(Exception ex) {
    	System.out.print(ex.getMessage());
    	 return text;
    	}
    }
    
    public Object clientPageInstance()
    {
    	ClinetSettingsPageElements clientSettingele =new ClinetSettingsPageElements(this.getMap().getBrowser());
    	ClientPageValidator clientPage= new ClientPageValidator(clientSettingele);
    	return clientPage;
    }
     public boolean logOut()
     {
    	this.getMap().logout.click();
		return true;
    	 
    	 
     }
}

