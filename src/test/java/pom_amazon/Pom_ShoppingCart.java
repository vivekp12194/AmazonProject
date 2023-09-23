package pom_amazon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePackage.AmazonBaseClass;

public class Pom_ShoppingCart extends AmazonBaseClass {
	
	Select size;
	Select itemquantity;
	@FindBy(id="twotabsearchtextbox")WebElement searchbox1;
	@FindBy(id="nav-search-submit-button")WebElement searchbtn;
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[9]/div/div/div/div/div[2]/div/span/a")WebElement item1;
	@FindBy(xpath="/html/body/div[2]/div/div[5]/div[1]/div[1]/div[2]/div[2]/div/div/div[1]/div[20]/div[1]/div[2]/form/div[1]/span/span/select")WebElement sizedrpdown;
	@FindBy(id="nav-cart-text-container")WebElement cart;
	@FindBy(id="quantity")WebElement quantity;
	@FindBy(id="addToCart_feature_div")WebElement addtocartbtn;
	@FindBy(xpath="//div[@class='a-spacing-mini sc-item-content-group']")WebElement s_cartproduct_link;
	
	public Pom_ShoppingCart() {
		PageFactory.initElements(driver,this);
	}
	public void searchanyitem(String anyitemname) {
		searchbox1.sendKeys(anyitemname);
		searchbtn.click();
	}
	public void clickonitem() throws InterruptedException {
		item1.click();
		Thread.sleep(2000);
		WebElement sizedrp = driver.findElement(By.xpath("//select[@class='a-native-dropdown a-declarative']"));
		boolean valid = sizedrp.isDisplayed();
		if (valid==true) {
		size = new Select(driver.findElement(By.xpath("//select[@class='a-native-dropdown a-declarative']")));
		size.selectByVisibleText("Medium");	
		System.out.println("Size Selected");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addToCart_feature_div")));
		addtocartbtn.click();
		System.out.println("Item Added to cart");
		}
		else {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addToCart_feature_div")));
		addtocartbtn.click();
		System.out.println("Item Added to cart");
		Thread.sleep(2000);
		}
	}
	public void increasequantity() throws InterruptedException {
		cart.click();
		WebElement beforeprice = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']"));
		System.out.println("Price before quantity updated:"+beforeprice.getText());
		itemquantity = new Select(quantity);
		itemquantity.selectByVisibleText("2");	
		System.out.println("Quantity updated");
		Thread.sleep(3000);
		WebElement afterprice = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']"));
		System.out.println("Price after quantity updated:"+afterprice.getText());
		if(!afterprice.equals(beforeprice)){
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed:");
	}
}
	public void addsameitem() throws InterruptedException {
		cart.click();
		Thread.sleep(3000);
		s_cartproduct_link.click();
		ArrayList <String> newtab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newtab.get(1));
		System.out.println("Page title of new tab:" +driver.getTitle());
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("addToCart_feature_div")));
		addtocartbtn.click();
		System.out.println("item added in cart:");
		driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();	//Go to cart
		Thread.sleep(3000);		
		Select qty = new Select(driver.findElement(By.xpath("//*[@id=\"quantity\"]")));  //quantity dropdown
		WebElement opt = qty.getFirstSelectedOption();
		String defaultitem = opt.getText();
		System.out.println("Selected Quantities are: "+defaultitem);
		Assert.assertEquals(defaultitem, "2");
		System.out.println("Test Passed: It is displaying only one item and only increased the quantity");
	}	
	public void removeitem() throws InterruptedException {
		searchbox1.clear();
		searchbox1.sendKeys("wardrobe closet");
		searchbtn.click();
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div[1]/span/a")).click();
		addtocartbtn.click();
		System.out.println("item added in cart:");
		driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();	//Go to cart
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		System.out.println("item deleted from cart:");
		Thread.sleep(3000);
		WebElement text = driver.findElement(By.xpath("//h1[@class='a-spacing-mini a-spacing-top-base']"));
		String actualtext = text.getText();
		Assert.assertEquals(actualtext, "Your Amazon Cart is empty.");
		System.out.println(actualtext);
		WebElement subtotal = driver.findElement(By.xpath("//*[@id=\"activeCartViewForm\"]/div[3]"));  //subtotal link
		String actualtotal = subtotal.getText();
		Assert.assertEquals(actualtotal,"Subtotal (0 items): $0.00");
		System.out.println(actualtotal);
	}
}
