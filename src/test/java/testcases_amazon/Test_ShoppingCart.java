package testcases_amazon;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.AmazonBaseClass;
import pom_amazon.Pom_ShoppingCart;

public class Test_ShoppingCart extends AmazonBaseClass{
	Pom_ShoppingCart cart;
	
	public Test_ShoppingCart() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initialization();
		cart = new Pom_ShoppingCart();
	}
	@Test(priority=1)
	public void TC_additemtocart() throws InterruptedException{
		cart.searchanyitem("Tshirts for men");
		cart.clickonitem();
	}
	@Test(priority=2)
	public void TC_increaseQuanity() throws InterruptedException {
		
		cart.searchanyitem("Tshirts for men");
		cart.clickonitem();
		cart.increasequantity();
	}
	@Test(priority=3)
	public void TC_addsameitemagain() throws InterruptedException {
		cart.searchanyitem("Tshirts for men");
		cart.clickonitem();
		cart.addsameitem();	
	}
	@Test
	public void TC_removeitemsfromcart() throws InterruptedException {
		cart.removeitem();
		
	}
	@AfterMethod
	public void browserclose() {
		//driver.close();
	}
}
