package pom_amazon;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import basePackage.AmazonBaseClass;
public class Pom_Address extends AmazonBaseClass{
	Select pro;
	@FindBy(id="ap_email")WebElement email_signin;
	@FindBy(id="continue")WebElement continuebtn;
	@FindBy(id="ap_password")WebElement password_signin;
	@FindBy(id="signInSubmit")WebElement signinbtn;
	@FindBy(xpath="//h2[contains(text(),'Your Addresses')]")WebElement addresslink;
	@FindBy(xpath="//*[@id=\"ya-myab-address-add-link\"]/div/div/h2")WebElement addaddress;
	@FindBy(id="address-ui-widgets-countryCode")WebElement countrydrpdown;
	@FindBy(id="address-ui-widgets-enterAddressFullName")WebElement fullname;
	@FindBy(id="address-ui-widgets-enterAddressPhoneNumber")WebElement phonenumber;
	@FindBy(id="address-ui-widgets-enterAddressLine1")WebElement address1;
	@FindBy(id="address-ui-widgets-enterAddressLine2")WebElement address2;
	@FindBy(id="address-ui-widgets-enterAddressCity")WebElement city;
	@FindBy(name="address-ui-widgets-enterAddressStateOrRegion")WebElement provincedrpdown;
	@FindBy(id="address-ui-widgets-enterAddressPostalCode")WebElement postalcode;
	@FindBy(xpath="//div[contains(text(),'Please enter a name.')]")WebElement nameerror;
	@FindBy(xpath="//div[contains(text(),'Please enter a phone number so we can call if there are any issues with delivery.')]")WebElement phonenumbererror;
	@FindBy(xpath="//div[contains(text(),'Please enter an address.')]")WebElement addresserror;
	@FindBy(xpath="//div[contains(text(),'Please enter a city name.')]")WebElement cityerror;
	@FindBy(xpath="//div[contains(text(),'Please enter a province/territory.')]")WebElement provinceerror;
	@FindBy(xpath="//div[contains(text(),'Please enter a postal code.')]")WebElement postalerror;
	@FindBy(id="address-ui-widgets-form-submit-button")WebElement addaddressbtn;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-enterAddressFormContainer\"]/div[4]/a/span/span")WebElement deliveryinstructions;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-delivery-instructions-desktop-widget-html-container\"]/div/div/div[1]/div[6]/div[1]/div/div/div/span/div[4]/label/input")WebElement radiobtn;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-delivery-instructions-desktop-widget-html-container\"]/div/div/div[1]/div[6]/div[2]/a/i")WebElement openfordeliveries;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-delivery-instructions-desktop-widget-html-container\"]/div/div/div[1]/div[6]/div[2]/div/div[1]/div[1]/div/div[2]/div/div[3]/span/div/label/i")WebElement weekdaychkbox;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-delivery-instructions-desktop-widget-html-container\"]/div/div/div[1]/div[6]/div[2]/div/div[1]/div[2]/div/div[2]/div/div[3]/span/div/label/i")WebElement weekendchkbox;
	
	public Pom_Address() {
		
		PageFactory.initElements(driver,this);
	}
	
	public void hello() {
		
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).click();
		
	}
	public void verifyaddressnavigation() {
		addresslink.click();
		String actualurl = driver.getCurrentUrl();
		Assert.assertEquals(actualurl, "https://www.amazon.ca/a/addresses?ref_=ya_d_c_addr");
		boolean visible = addaddress.isDisplayed();
		if (visible==true) {
			System.out.println("Test case Passed: Add Address is Displaying");
		}
		else {
			System.out.println("You are on wrong page:");
		}
	}
	public void addaddress() {
		addaddress.click();	
		
	}
	public void typename(String fname) {
		fullname.sendKeys(fname);
	}
	public void typenumber(String number) {
		phonenumber.sendKeys(number);
	}
	public void typeaddress(String street) {
		address1.sendKeys(street);
	}
	public void typeaddress2(String apartment) {
		address2.sendKeys(apartment);
	}
	public void typecity(String cityname) {
		city.sendKeys(cityname);
	}
	public void selectprovince(String province) {
		pro = new Select(provincedrpdown);
		pro.selectByVisibleText(province);
	}
	public void typepostal(String zipcode) {
		postalcode.sendKeys(zipcode);
	}
	public void clickaddaddressbtn() {
		addaddressbtn.click();
	}
	public void adddeliveryinsstructions() {
		deliveryinstructions.click();
		System.out.println("clicked on delivery instructions:");
		radiobtn.click();
		openfordeliveries.click();
		System.out.println("clicked on"+openfordeliveries.getText());
		weekdaychkbox.click();
		System.out.println("checkbox is selected");
		weekendchkbox.click();
		System.out.println("checkbox is selected");
	}
	public void saveaddress() {
		boolean savebutton = driver.findElement(By.id("a-autoid-2-announce")).isDisplayed();
		if(savebutton == true) {
			driver.findElement(By.id("a-autoid-2-announce")).click();
		}
		else {
			System.out.println("Save address button is not diaplyed");
		}
	}
	
	public void verifyerrors() {

		String actualnameerror = "Please enter a name.";
		String actualphoneerror = "Please enter a phone number so we can call if there are any issues with delivery.";
		String actualaddresserror = "Please enter an address.";
		String actualcityerror = "Please enter a city name.";
		String actualprovinceerror = "Please enter a province/territory.";
		String actualpostalerror = "Please enter a postal code.";

		if (actualnameerror.equals(nameerror.getText())) {
			System.out.println("Failed to add address" +actualnameerror );
		}
		else if (actualphoneerror.equals(phonenumbererror.getText())) {
			System.out.println("Failed to add address" +actualphoneerror);
		} 
		else if (actualaddresserror.equals(addresserror.getText())) {
			System.out.println("Failed to add address" +actualaddresserror);
		} 
		else if (actualcityerror.equals(cityerror.getText())) {
			System.out.println("Failed to add address" +actualcityerror);
		} 
		else if (actualprovinceerror.equals(provinceerror.getText())){
			System.out.println("Failed to add address" +actualprovinceerror);
		} 
		else if (actualpostalerror.equals(postalerror.getText())) {
			System.out.println("Failed to add address" +actualpostalerror);
		} 
		else {
			
		}
	}
}
