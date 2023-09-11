package testcases_amazon;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.AmazonBaseClass;
import pom_amazon.Pom_YourOrders;

public class Test_YourOrders extends AmazonBaseClass{
	Pom_YourOrders yourorders;
	public Test_YourOrders() {
		super();
	}
	@BeforeMethod
	public void initsetup()  {
		initialization();
		yourorders = new Pom_YourOrders();
	}
	@Test
	public void TC_yourorders() throws InterruptedException {
	login();
	Thread.sleep(3000);
	yourorders.clickonorders();
	yourorders.buyagain();
	yourorders.notyetshipped();
	yourorders.cancelledorders();
		
	}
	@AfterMethod
	public void browserclose() {
		//driver.close();
	}
	
}
