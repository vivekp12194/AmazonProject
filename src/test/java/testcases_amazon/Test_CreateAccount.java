package testcases_amazon;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.AmazonBaseClass;
import pom_amazon.Pom_CreateAccount;
import pom_amazon.Pom_Homepage;

public class Test_CreateAccount extends AmazonBaseClass {
	
	Pom_CreateAccount create_acc;
	Pom_Homepage homepage;
	
	
	public Test_CreateAccount() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initialization();
		create_acc = new Pom_CreateAccount();
		homepage = new Pom_Homepage();
	}
	@Test (priority=1)
	public void TC2_Emptynamefield() throws InterruptedException {
		homepage.clickonstarthere();
		Thread.sleep(2000);
		create_acc.enteryourname("");
		create_acc.enteremail("ihgnfd@gmail.com");
		create_acc.enterpassword("abcd@1212");
		create_acc.enterpasswordagain("abcd@1212");
		create_acc.verifyemailmobile();
		create_acc.verifyerror();
		
	}
	@Test(priority=2)
	public void TC3_Emptyemailormobilenumberfield() throws InterruptedException {
		homepage.clickonstarthere();
		Thread.sleep(2000);
		create_acc.enteryourname("vivek");
		create_acc.enteremail("");
		create_acc.enterpassword("abcd@1212");
		create_acc.enterpasswordagain("abcd@gmail.com");
		create_acc.verifyemailmobile();
		create_acc.verifyerror();
	}
	@Test(priority=3)
	public void TC4_verfiymobilenumberfield() throws InterruptedException {
		homepage.clickonstarthere();
		Thread.sleep(2000);
		create_acc.enteryourname("vivek");
		create_acc.enteremail("123456789");
		create_acc.enterpassword("");
		create_acc.verifyemailmobile();
		create_acc.verifyemailmobilebutton();
	}
	@Test (priority=4)
	public void TC5_verfiyemailfield() {
		homepage.clickonstarthere();
		//Thread.sleep(2000);
		create_acc.enteryourname("vivek");
		create_acc.enteremail("ihgnfd@gmail.com");
		create_acc.enterpassword("");
		create_acc.verifyemailmobile();
		create_acc.verifyemailmobilebutton();
	}
	@Test(priority=5)
	public void TC7_invalidpassowrd() {
		homepage.clickonstarthere();
		//Thread.sleep(2000);
		create_acc.enteryourname("vivek");
		create_acc.enteremail("ihgnfd@gmail.com");
		create_acc.enterpassword("1234");
		create_acc.enterpasswordagain("123456");
		create_acc.verifyemailmobile();
		create_acc.verifyerror();
		
	}
	@Test(priority=6)
	public void TC9_validdetails() throws InterruptedException {
		homepage.clickonstarthere();
		//Thread.sleep(2000);
		create_acc.enteryourname("vivek");
		create_acc.enteremail("ihgnfd@gmail.com");
		create_acc.enterpassword("abcd@123");
		create_acc.enterpasswordagain("abcd@123");
		create_acc.verifyemailmobile();
		//create_acc.verifyerror();
		Thread.sleep(5000);
		create_acc.verifyemailotp();
	}
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
}
