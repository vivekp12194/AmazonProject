package testcases_amazon;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.AmazonBaseClass;
import pom_amazon.Pom_Signin;

public class Test_Signin extends AmazonBaseClass{
	Pom_Signin signin;
	
	public Test_Signin() {
		super();
	}
	@BeforeMethod
	public void initsetup() throws InterruptedException {
		initialization();
		signin = new Pom_Signin();
		Thread.sleep(3000);
		signin.signinurl();
	}
	@Test (priority=1)
	public void TC10_invalidemailid() {
		
		signin.enteremail("gerwsd12@gmail.com");
		signin.clickcontinue();
		signin.invalidemailerror();
	}
	@Test(priority=2)
	public void TC11_validemailid() {
		signin.enteremail("vvk12194@gmail.com");
		signin.clickcontinue();
		signin.validcredentials();
	}
	@Test(priority=3)
	public void TC12_invalidpassword() throws InterruptedException {
		signin.enteremail("vvk12194@gmail.com");
		signin.clickcontinue();
		signin.enterpassword("qwert@12");
		signin.clicksignin();
		signin.incorpassworderror();
	}
	@Test(priority=4)
	public void TC13_validpassword() {
		signin.enteremail("vvk12194@gmail.com");
		signin.clickcontinue();
		signin.enterpassword("VVK@12194");
		signin.clicksignin();
		signin.usernameverify();
	}
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
	
}