package pom_amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basePackage.AmazonBaseClass;

public class Pom_Signin extends AmazonBaseClass{
	
	@FindBy(id="ap_email")WebElement email_signin;
	@FindBy(id="continue")WebElement continuebtn;
	@FindBy(id="ap_password")WebElement password_signin;
	@FindBy(id="signInSubmit")WebElement signinbtn;
	@FindBy(xpath="//div[contains(name(),'rememberMe')]")WebElement rememberme;
	@FindBy(xpath="//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")WebElement signinerror;
	@FindBy(xpath="//*[@id=\"auth-email-missing-alert\"]/div/div")WebElement emptyemailerror;
	@FindBy(xpath="//*[@id=\"auth-error-message-box\"]/div/h4")WebElement invalidphoneerror;
	@FindBy(xpath="//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")WebElement incorpassworderror;
	
	Actions action;
	public Pom_Signin() {
		PageFactory.initElements(driver,this);
	}
	public void signinurl() {
		
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).click();
		
	}
	public void enteremail(String emailid) {
		email_signin.sendKeys(emailid);
	}
	public void enterpassword(String password) {
		password_signin.sendKeys(password);
	}
	public void clickcontinue() {
		continuebtn.click();
	}
	public void clicksignin() {
		signinbtn.click();
	}
	public void invalidemailerror() {
		String expectedemailerror="We cannot find an account with that e-mail address";
		String actualresult=signinerror.getText();
		Assert.assertEquals(actualresult, expectedemailerror,"Test Passed");
	}
	public void incorpassworderror() {
		String actualpassworderror=incorpassworderror.getText();
		String expectedpassworderror="Your password is incorrect";
		Assert.assertEquals(actualpassworderror,expectedpassworderror,"Test Passed");
	}
	public void invalidnumbererror() {
		String actualerror=invalidphoneerror.getText();
		String expectedphoneerror="We cannot find an account with that mobile number";
		Assert.assertEquals(actualerror, expectedphoneerror, "Test Passed");
	}
	public void validcredentials() {
		if(signinbtn.isDisplayed()) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
	}
	public void usernameverify() {
		WebElement username = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		String actualusername=username.getText();
		String expectedusername="Hello, Vivek";
		Assert.assertEquals(actualusername, expectedusername);
		System.out.println(actualusername);
	}
}
