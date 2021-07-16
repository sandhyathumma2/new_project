package ff.ui.stepdefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import Nunc.Core.Libraries.Driver;
import Nunc.Reports.ExtentReportUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ff.ui.pages.ClientPageValidator;
import ff.ui.pages.ClinetSettingsPageElements;

public class ClientSteps {

	ClinetSettingsPageElements clientSettingele =new ClinetSettingsPageElements(Driver.getDriver());
	ClientPageValidator clientPage= new ClientPageValidator(clientSettingele);
	
	
	@Given("^I Clicks on clients Menu Link$")
	public void iClicksOnClientsMenuLink() throws Throwable {
	//	throw new PendingException();
		clientPage.clickOnClientPage();
		ExtentReportUtil.CreateInstance().setnodestep("Given","I Clicks on clients Menu Link","Clicked on clients link");
	}

	@Then("^I valdidate the clients page$")
	public void iValdidateTheClientsPage() throws Throwable {
		//throw new PendingException();
	}

	@When("^I Clicks on the EditAction Button of \"([^\"]*)\"$")
	public void iClicksOnTheEditActionButtonOf(String clientName) throws Throwable {	
				
		boolean isUpdated = clientPage.clicksonEditActions(clientName);
		if(isUpdated)
		ExtentReportUtil.CreateInstance().setnodestep("When","When:I Clicks on the EditAction Button of "+clientName,"Clicked on EditAction of"+clientName + "and successfully updated client");
	}

	@Then("^I validate client settings page and verify all menus$")
	public void iValidateClienteditpageAndVerifyAllMenus() throws Throwable {
		//throw new PendingException();
	ArrayList<String> lst =clientPage.getClientSettingMenus();
	
	// Get String Array 
    String[] str = GetStringArray(lst);
	ExtentReportUtil.CreateInstance().setnodestep("Then","Then:I validate client settings page and verify all menus","Menus from client settings "+Arrays.toString(str));
	}
	

    // Function to convert ArrayList<String> to String[] 
    public static String[] GetStringArray(ArrayList<String> arr) 
    {  
        // declaration and initialise String Array 
        String str[] = new String[arr.size()];  
        // ArrayList to Array Conversion 
        for (int j = 0; j < arr.size(); j++) {   
            // Assign each value to String array 
            str[j] = arr.get(j); 
        }   
        return str; 
    } 

	@When("^I clicks on client information page and updates$")
	public void iclicksOnClientInformation() throws Throwable {
		//throw new PendingException();
	}

	@Then("^I validate client information page$")
	public void iValidateClientInformationPage() throws Throwable {
		//throw new PendingException();
	}

	@When("^I Update client details$")
	public void iUpdateClientDetails() throws Throwable {
	//	throw new PendingException();
	}

	@Then("^I validate for successfull updates$")
	public void iValidateForSuccessfullUpdates() throws Throwable {
		//throw new PendingException();
	}

	@When("^I clicks on  options/packages tab$")
	public void iClicksOnOptionsPackagesTab() throws Throwable {
		ArrayList<String> lst = clientPage.clickOnClientPackageOptions();		// Get String Array 
	    String[] str = GetStringArray(lst);
		ExtentReportUtil.CreateInstance().setnodestep("When","When:I clicks on  options/packages tab","Menus from options/packages tab "+Arrays.toString(str));
		clientPage.clickonInventory();
		ExtentReportUtil.CreateInstance().setnodestep("When","When:I clicks on  options/packages tab","Clicks on inventory");
	}

	@Then("^I verify all options with thier status$")
	public void iVerifyAllOptionsWithThierStatus() throws Throwable {
		ArrayList<String> lst =clientPage.printallcheckboxes();
		StringBuilder sb =new StringBuilder();
		for(String item : lst)
		{
			sb.append(item+",");			
		}
		
		ExtentReportUtil.CreateInstance().setnodestep("Then","Then:I verify all options with thier status","All options : "+sb.toString());
	}

	@Then("^I select options$")
	public void iSelectOptions() throws Throwable {
		ArrayList<String> options =new ArrayList<String>();
		options.add("client_vidmagnet");
		
		  String[] str = GetStringArray(options);
		clientPage.selectOptions(options);
		ExtentReportUtil.CreateInstance().setnodestep("Then","Then:I select options","All selected options : "+Arrays.toString(str));
	}
	@Then("^I unselect options$")
	public void iunSelectOptions() throws Throwable {
		ArrayList<String> options =new ArrayList<String>();
		options.add("client_hvo");
		String[] str = GetStringArray(options);
		clientPage.unselectOptions(options);
		ExtentReportUtil.CreateInstance().setnodestep("Then","I unselect optionss","All unselected options : "+Arrays.toString(str));
	}

	@When("^I Clicks on the AddClient Button$")
	public void iClicksOnTheAddClientButton() throws Throwable {
		String h="";
	}

	@Then("^Add client information and validate$")
	public void addClientInformationAndValidate() throws Throwable {
		Faker faker = new Faker(new Locale("en-US"));
		
		 FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"), new RandomService());
		 String cellnumber = fakeValuesService.numerify("???-???-????");
		 Matcher emailMatcher = Pattern.compile("\\d{3}\\d{3}\\d{4}").matcher(cellnumber);
		String name = faker.company().name();
		String rooftopid = faker.address().buildingNumber();
		String address=faker.address().buildingNumber().toString()+","+faker.address().streetAddress().toString();
		String city=faker.address().city().toString();
		String state=faker.address().state().toString();
		String zip=faker.address().zipCode().toString();
		String phone="781-333-5555";
		System.out.print("this is from javafaker"+phone);
		String email = faker.internet().emailAddress("en-US");
		String url = faker.internet().url();
		ArrayList<String> lst =new ArrayList<String>();
		lst.add(name);
		lst.add(rooftopid);
		lst.add(address);
		lst.add(city);
		lst.add(state);
		lst.add(zip);
		lst.add(phone);
		lst.add(email);
		lst.add(url);
		String[] str = GetStringArray(lst);
		 
		clientPage.addnewclient(lst);
		ExtentReportUtil.CreateInstance().setnodestep("Then","Add client information and validate : ",Arrays.toString(str));
		
	}


}
