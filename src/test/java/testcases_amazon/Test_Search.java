package testcases_amazon;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.AmazonBaseClass;
import pom_amazon.Pom_Search;

public class Test_Search extends AmazonBaseClass {
	Pom_Search  search;
	public Test_Search() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initialization();
		search=new Pom_Search();
	}
	@Test (priority=1)
	public void TC25_searchitem() {
		search.searchitem("tshirts");
		search.verifytitle();
	}
	@Test(priority=2)
	public void TC27_productinfo() {
		search.searchitem("tshirts");
		search.verifyimages();
		search.verifyproductname();
		search.verifyproductprice();
	}
	@Test(priority=3)
	public void TC28_numberofproducts() {
		search.searchitem("tshirts");
		search.verifynumberofproducts();
	}
	@Test(priority=4)
	public void TC_filtration() throws InterruptedException {
		search.searchitem("tshirts");
		//search.filtration();
		//search.filterbyprice();
		search.sorting();
	}
	@AfterMethod
	public void browserclose() {
		driver.close();
	}
}
