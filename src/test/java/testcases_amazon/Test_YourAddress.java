package testcases_amazon;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.AmazonBaseClass;
import pom_amazon.Pom_Address;
import pom_amazon.Pom_Signin;

public class Test_YourAddress extends AmazonBaseClass{
	Pom_Address address;
	Pom_Signin signin;
	public Test_YourAddress() {
		super();
	}
	@BeforeMethod
	public void initsetup() throws InterruptedException {
		initialization();
		login();
		address=new Pom_Address();
		
	}
	@Test
	public void TC_addressnavigation() {
		address.hello();
		address.verifyaddressnavigation();
	}
	@Test
	public void TC_addaddresswithvaliddetails() {
		address.hello();
		address.verifyaddressnavigation();
		address.addaddress();
		System.out.println("clicked on add address");
		address.typename("vivek");
		address.typenumber("1234567898");
		address.typeaddress("3484 rue hutchison");
		address.typeaddress2("09");
		address.typecity("montreal");
		address.selectprovince("Quebec");
		address.typepostal("h2x2g8");
		address.clickaddaddressbtn();
		address.saveaddress();
	}
	@Test
	public void TC_addaddresswithinvaliddetails1() {
		address.hello();
		address.verifyaddressnavigation();
		address.addaddress();
		address.typename("");
		address.typenumber("1234567898");
		address.typeaddress("3484 rue hutchison");
		address.typeaddress2("09");
		address.typecity("montreal");
		address.selectprovince("Quebec");
		address.typepostal("h2x2g8");
		address.clickaddaddressbtn();
		address.verifyerrors();
	}
	@Test
	public void TC_addaddresswithinvaliddetails2() {
		address.hello();
		address.verifyaddressnavigation();
		address.addaddress();
		address.typename("vivek");
		address.typenumber("1234567898");
		address.typeaddress("");
		address.typeaddress2("09");
		address.typecity("montreal");
		address.selectprovince("Quebec");
		address.typepostal("h2x2g8");
		address.clickaddaddressbtn();
		address.verifyerrors();
	}
	@Test
	public void TC_additionaldeliverydetails() {
		address.hello();
		address.verifyaddressnavigation();
		address.addaddress();
		System.out.println("clicked on add address");
		address.typename("vivek");
		address.typenumber("1234567898");
		address.typeaddress("3484 rue hutchison");
		address.typeaddress2("09");
		address.typecity("montreal");
		address.selectprovince("Quebec");
		address.typepostal("h2x2g8");
		address.adddeliveryinsstructions();
	}
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
}
