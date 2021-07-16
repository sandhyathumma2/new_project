package ff.ui.pages;

import java.awt.List;
import java.util.ArrayList;

import Nunc.Core.Libraries.Selenide;

/**
 * @author E000911
 *
 */
public class ClientPageValidator extends BasePageValidator<ClinetSettingsPageElements>{
	
	public ClientPageValidator(ClinetSettingsPageElements Map) {
		super(Map);
	}

	public boolean clickOnClientPage() {
		try {
			//this.getMap().ClientLink().click();
			Selenide.waitForInVisibilityOfElement(this.getMap().loading, 30);
		} catch (Throwable e) {
			try {
				Selenide.waitForInVisibilityOfElement(this.getMap().loading, 30);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
		return true;
	}

	public boolean clicksonEditActions(String clientName) throws Throwable {
		Selenide.waitForInVisibilityOfElement(this.getMap().loading, 40);
		this.getMap().editclientsearch().sendKeys(clientName);
		this.getMap().EditActions(clientName).click();
		updateClientInfo();
		return true;
	}
    public ArrayList<String> getClientSettingMenus()
    {
    	ArrayList<String> lst=new ArrayList<String>();
    	this.getMap().clientSettingsMenus.forEach(x-> lst.add(x.getText()));
    	return lst;
    	
    }
	public boolean updateClientInfo() {
		this.getMap().clientdesc.sendKeys("This description is from automation"); 
		this.getMap().client_salesperson_name.sendKeys("Ted Holder");
		this.getMap().client_comments.sendKeys("Welcome to our Toyota of Tampa Bay, This is from automation");
		//this.getMap().client_email_forward.sendKeys("test@flickfusion.com");
		this.getMap().btnsavechanges.click();
	//	clickOnClientPackageOptions();
		return true;
	}
	
	public ArrayList<String> clickOnClientPackageOptions()
	{ 
		this.getMap().packagestab.click();
		ArrayList<String> lst =new ArrayList<String>();
		this.getMap().clientsettingtab.forEach(x->lst.add(x.getText()));
		return lst;
	}
	
	public boolean clickonInventory()
	{
		this.getMap().a_client_inventory_video.click();		
	    return true;
	}
	public boolean addnewclient(ArrayList<String> lst)
	{
		this.getMap().addclientbtn.click();
		this.getMap().clientname.sendKeys(lst.get(0));
		this.getMap().rooftopId.sendKeys(lst.get(1));
		this.getMap().client_address.sendKeys(lst.get(2));
		this.getMap().client_city.sendKeys(lst.get(3));
		this.getMap().client_state.sendKeys(lst.get(4));
		this.getMap().client_phone.sendKeys(lst.get(6));
		this.getMap().client_zip.sendKeys(lst.get(5));
		this.getMap().client_email_forward.sendKeys(lst.get(7));
		this.getMap().client_url.sendKeys(lst.get(8));
		this.getMap().client_comments.sendKeys("this client created from automation for testing purpose");
		this.getMap().btnsavechanges.click();
	    return true;
	}
	public ArrayList<String> printallcheckboxes()
	{
		ArrayList<String> lst= new ArrayList<String>();
		this.getMap().checkboxlables.forEach(x->lst.add("Option :"+x.getText()+" is Checked :"+x.isSelected()));
		//checkChekbox("client_hvo");
		
		return lst;
	}
	
	public boolean selectOptions(ArrayList<String> options)
	{
		options.stream().forEach(x->checkChekbox(x));
		this.getMap().btnsavechanges.click();
		return true;
	}
	public boolean unselectOptions(ArrayList<String> options)
	{
		options.stream().forEach(x->uncheckChekbox(x));		
		this.getMap().btnsavechanges.click();
		return true;
	}
	
	public String checkChekbox(String id) 
	{
		try {
			if(!this.getMap().Inputcontrolbyid(id).isSelected())
			{
				System.out.print(this.getMap().Inputcontrolbyid(id).isSelected());
				this.getMap().Inputcontrolbyid(id).click();
			}
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}
	public String uncheckChekbox(String id) 
	{
		try {
			if(this.getMap().Inputcontrolbyid(id).isSelected())
			{
				System.out.print(this.getMap().Inputcontrolbyid(id).isSelected());
				this.getMap().Inputcontrolbyid(id).click();
			}
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}
	
	 

	
}
