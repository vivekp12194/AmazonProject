package pom_amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basePackage.AmazonBaseClass;

public class Pom_YourOrders extends AmazonBaseClass{
	Actions action;
	
	@FindBy(xpath="//*[@id=\"nav-link-accountList-nav-line-1\"]")WebElement accountlist;
	@FindBy(xpath="//*[@id=\"nav_prefetch_yourorders\"]/span")WebElement yourorders;
	@FindBy(className="a-dropdown-container")WebElement orderdropdown;
	@FindBy(linkText="Buy Again")WebElement buyagain;
	@FindBy(linkText="Not Yet Shipped")WebElement notyetshipped;
	@FindBy(linkText="Cancelled Orders")WebElement cancelledorders;
	@FindBy(xpath="//*[@id=\"CardInstance4N_OEVZbkFFI9zTuMR5RSQ\"]")WebElement listitems;
	@FindBy(xpath="//*[@id=\"ordersContainer\"]/div[1]/div")WebElement nystext;
	@FindBy(xpath="//*[@id=\"ordersContainer\"]/div[1]/div")WebElement cancelledordertext;

	public Pom_YourOrders() {
		PageFactory.initElements(driver,this);
	}
	public void clickonorders() {
		action = new Actions(driver);
		action.moveToElement(accountlist).perform();
		yourorders.click();
		
	}
	public void buyagain() {
		boolean verifybuyagain = buyagain.isDisplayed();
		String actualresult = buyagain.getText();
		System.out.println("Items available to buy again:" +actualresult);
		buyagain.click();
		
			List <WebElement> items = driver.findElements(By.className("_YnV5L_gridCell_1hj4x"));
			int list = items.size();
			if (list!=0) {
				System.out.println(list+ "Test Passed");
			}
			else if (list==0){
				System.out.println("You have not ordered anything in past");
			}
			for (WebElement itemlist:items) {
				System.out.println(itemlist.getText());
				
			}
		}
	public void notyetshipped() {
		boolean verifynyshipped = notyetshipped.isDisplayed();
		String actualnysresult = notyetshipped.getText();
		System.out.println(actualnysresult);
		notyetshipped.click();
		String text = nystext.getText();
		String expected = "Looking for an order? All of your orders have shipped. View all orders";
		Assert.assertEquals(text, expected,"Test Passed");
		}
	public void cancelledorders() {
		boolean verifycancelorder =cancelledorders.isDisplayed();
		String actualcancelorder = cancelledorders.getText();
		System.out.println(actualcancelorder);
		cancelledorders.click();
		String actualtext = cancelledordertext.getText();
		String expectedtext="We aren't finding any cancelled orders (for orders placed in the last 6 months).View all orders";
		Assert.assertEquals(actualtext, expectedtext,"Test Passed");
	}
	}
	
