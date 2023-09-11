package pom_amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.AmazonBaseClass;

public class Pom_Homepage extends AmazonBaseClass {
		
		@FindBy(xpath="//*[@id=\"nav-link-accountList\"]")WebElement HelloSignIn;
		@FindBy(linkText="Start here.")WebElement starthere;
		Actions action;
		public Pom_Homepage() {
			
			PageFactory.initElements(driver,this);
		}
		
		public void clickonstarthere() {
			action = new Actions(driver);
			action.moveToElement(HelloSignIn).build();
			starthere.click();
		}
		public String verifytitle() {
			return driver.getTitle();
		}
}
	
