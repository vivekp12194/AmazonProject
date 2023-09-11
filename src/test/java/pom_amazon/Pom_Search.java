package pom_amazon;


import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import basePackage.AmazonBaseClass;

public class Pom_Search extends AmazonBaseClass{
	String itemname;
	Select dropdown;
	@FindBy(id="twotabsearchtextbox")WebElement searchbox;
	@FindBy(id="nav-search-submit-button")WebElement searchbtn;
	@FindBy(className ="s-image")WebElement image;
	@FindBy(xpath=("//span[@class='a-icon-alt']"))WebElement ratings;	
	//@FindBy(className="a-size-base-plus a-color-base a-text-normal")WebElement productname;
	@FindBy(className = "a-price")WebElement price;
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[68]/div/div/span/a[3]")WebElement nextbtn;
	@FindBy(linkText="Men's Activewear T-Shirts")WebElement mensactivewear;
	@FindBy(linkText="$25 to $50")WebElement pricefilter;
	@FindBy(xpath="//*[@id=\"a-autoid-0-announce\"]/span[1]")WebElement sortbydropdown;
	
	////*[@id="anonCarousel2"]/ol/li[3]/div/div/div/div/div[2]/div[1]/h2/a/span
	////*[@id="anonCarousel2"]/ol/li[1]/div/div/div/div/div[2]/div[1]/h2/a/span
	////*[@id="anonCarousel2"]/ol/li[2]/div/div/div/div/div[2]/div[2]/h2/a/span
	public Pom_Search() {
		PageFactory.initElements(driver,this);
	}
	public void searchitem(String itemname) {
		searchbox.sendKeys(itemname);
		searchbtn.click();
		this.itemname=itemname;
	}
	public void verifytitle() {
		String actualtitle=driver.getTitle();
		String expectedtitle=("Amazon.ca : "+itemname);
		Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println("Test Passed: Title Matched");
	}
	public void verifyimages() {
		boolean images = image.isDisplayed();
		System.out.println(images +"***********"+"Test Passed: Here is the url of all images:");
		List <WebElement> p_image= driver.findElements(By.tagName("img"));
		for (WebElement imagelist : p_image) {
			System.out.println(imagelist.getAttribute("src"));
		}
		
	}
	public void verifyproductname() {
		WebElement p_name = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		boolean nameofproduct = p_name.isDisplayed();
		System.out.println(nameofproduct);
		List <WebElement> name = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		for (WebElement p_namelist:name) {
			System.out.println(p_namelist.getText());
		}
	}
	public void verifyproductprice() {
		boolean price_product = price.isDisplayed();
		System.out.println(price_product);
		System.out.println("Below are the Prices of all Producs:");
		List <WebElement> prices_p = driver.findElements(By.className("a-price"));
		for (WebElement pricesofproducts : prices_p) {
			System.out.println(pricesofproducts.getText());
	}
		}
	public void verifyratings() {
		//boolean ratings_p = ratings.isDisplayed();
		//System.out.println(ratings_p);
		System.out.println("Below are the ratings of all Products:");
		List <WebElement> productsratings = driver.findElements(By.xpath("//span[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom']"));
		for (WebElement products_ratings:productsratings) {
			System.out.println(products_ratings);
		}
	}
	public void verifynumberofproducts() {
		int products = driver.findElements(By.xpath("//div[@class='s-card-container s-overflow-hidden aok-relative puis-expand-height puis-include-content-margin puis puis-vqcnlkgcd4sr22kxlmcindh6i0 s-latency-cf-section s-card-border']")).size();
		System.out.println(products);
		Assert.assertEquals(products, 60);
		System.out.println("Test Passed"+"........."+"Number of products found on page is:"+products);
	}
	public void filtration() {
		mensactivewear.click();
		System.out.println("************** Filter by Department***********");
		List <WebElement> name_p = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		for (WebElement p_namelist:name_p) {
			System.out.println(p_namelist.getText());
		}
	}
	public void filterbyprice() {
		pricefilter.click();
		System.out.println("************** Filter by Price ***********");
		List <WebElement> prices_p = driver.findElements(By.className("a-price"));
		for (WebElement pricesofproducts : prices_p) {
			System.out.println(pricesofproducts.getText());
	}
	}
	public void sorting() throws InterruptedException {
		System.out.println("price before sorting");
		List <WebElement> pricesbeforefilter = driver.findElements(By.className("a-price-whole"));
		//List <Double> priceslist = new ArrayList<>();
		for(WebElement p1:pricesbeforefilter) {
			System.out.println(p1.getText());
		}
		dropdown = new Select (driver.findElement(By.id("s-result-sort-select")));
		dropdown.selectByVisibleText("Price: High to low");
		System.out.println("price after sorting");
		Thread.sleep(3000);
		List<WebElement> priceafterfilter = driver.findElements(By.className("a-price-whole"));
	//	List <Double> p_list = new ArrayList<>();
		for(WebElement p2:priceafterfilter) {
			System.out.println(p2.getText());
		}
}
	
}
