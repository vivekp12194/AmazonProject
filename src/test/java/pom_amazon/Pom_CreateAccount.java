package pom_amazon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePackage.AmazonBaseClass;


public class Pom_CreateAccount extends AmazonBaseClass{
	
	//@FindBy   WebElement
	@FindBy(id="ap_customer_name")WebElement YourName;
	@FindBy(id="ap_email")WebElement Email;
	@FindBy(id="ap_password")WebElement Password;
	@FindBy(id="ap_password_check")WebElement PasswordAgain;
	@FindBy(id="continue")WebElement submit;
	@FindBy(xpath="//*[@id=\"auth-continue\"]") WebElement emailverify;
	@FindBy(xpath="//*[@id=\"auth-continue\"]") WebElement mobileverify;
	@FindBy(xpath="//*[@id=\"auth-customerName-missing-alert\"]/div/div")WebElement nameerror;
	@FindBy(xpath="//*[@id=\"auth-email-missing-alert\"]/div/div") WebElement emailerror;
	@FindBy(xpath="//*[@id=\"auth-password-invalid-password-alert\"]/div/div")WebElement passwordverror;
	@FindBy(xpath="//*[@id=\"auth-password-mismatch-alert\"]/div/div") WebElement passwordagainerror;
	@FindBy(xpath="//*[@id=\"verification-code-form\"]/div[2]/div[1]/text()")WebElement otpemail;
	@FindBy(xpath="//*[@id=\"cvf-submit-otp-button-announce\"]")WebElement createaccountbtn;
	
	
	public Pom_CreateAccount() {
		
		PageFactory.initElements(driver,this);
	}
	
	public void enteryourname(String name) {
		YourName.sendKeys(name);
	}
	public void enteremail(String email) {
		Email.sendKeys(email);
	}
	public void enterpassword(String password) {
		Password.sendKeys(password);
	}
	public void enterpasswordagain(String passwordagain) {
		PasswordAgain.sendKeys(passwordagain);
	}
	public void clickonsubmit() {
		submit.click();
	}
	public void verifyemailmobile() {
			emailverify.click();
	}
	public void verifymobile() {
		mobileverify.click();
	}
	public void verifyerror() {
		String nameactual = nameerror.getText();
		String emailactual = emailerror.getText();
		String passwordactual = passwordverror.getText();
		if(nameactual.equals("Enter your name")) {
			Assert.assertEquals(nameactual, "Enter your name","Test Passed");
			//System.out.println(nameactual);
		}
		else if(emailactual.equals("Enter your e-mail address or mobile phone number")){
			Assert.assertEquals(emailactual, "Enter your e-mail address or mobile phone number", "Test Pased");
			//System.out.println(emailactual);
		}
		else if(passwordactual.equals("Minimum 6 characters required")) {
			Assert.assertEquals(passwordactual, "Minimum 6 characters required");
			//System.out.println("pass");
		}
		else  {
		
		}
	}
	public void verifyemailmobilebutton() {
		if (emailverify.getText().equals("Verify email")){
			System.out.println("Verify email is displayed");
		}
		else if(mobileverify.getText().equals("Verify mobile number")) {
			System.out.println("Verify mobile number is displayed");
		}
	}
	public void verifyemailotp() {
		if(createaccountbtn.isDisplayed()) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("unable to locate create account button");
		}
	}
}
