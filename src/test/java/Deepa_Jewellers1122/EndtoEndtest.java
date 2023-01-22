package Deepa_Jewellers1122;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class EndtoEndtest {
	public WebDriver driver;
	

/*
 Navigate one page to another page .I was written this code for navigate all the pages.
 In this i was navigated all the pages successfully.
 I executed priority wise on which appeard in webpage.
 */
	
  @Test 
  public void aboutus_page()  {
	  driver.findElement(By.linkText("About Us")).click();
	  System.out.println("Succesfully navigated to About us page ");
	    }
  
 @Test(priority=1)
 public void Events_page () {
	 driver.findElement(By.linkText("Events")).click(); 
	 System.out.println("Succesfully navigated to Events page ");
	 
 }
 
 
 @Test(priority=2)
 public void Design_Gallery () {
	 driver.findElement(By.linkText("Design Gallery")).click(); 
	 System.out.println("Succesfully navigated to Design Gallery page ");
 }
 
 @Test(priority=3)
 public void Blogs_Page () {
	 driver.findElement(By.linkText("Blogs")).click(); 
	 System.out.println("Succesfully navigated to Blogs page ");
	 
 }
 
 @Test(priority=4)
 public void ContactUs_Page () {
	 driver.findElement(By.linkText("Contact Us")).click(); 
	 System.out.println("Succesfully navigated to Contact us page ");
 }
 
 //______________________________**************** __________________________________
 
 
 
 /*
  * Checking for logo is displayed or not .
  * In this website logo diplayed 2places one is Header and another one is footer section    
  */

 @Test (priority=5)
 public void logo_nav()  {
	  WebElement logoheader=driver.findElement(By.xpath("//a[@class='navbar-brand']"));
	  boolean actualresult1=logoheader.isDisplayed();
	  if (actualresult1) {
		  System.out.println("Logo is Displayed on Header");
	  }
	  else {
		  System.out.println("Logo is not Displayed on Header");
	  }
		  
			  
	    }
 
 @Test (priority=6)
 public void logo_footer()  {
	  WebElement logofooter=driver.findElement(By.xpath("//div[@class='col-lg-4 footer_secion_1']"));
	  boolean actualresult2=logofooter.isDisplayed();
	  if (actualresult2) {
		  System.out.println("Logo is Displayed on Footer");
	  }
	  else {
		  System.out.println("Logo is not Displayed on Footer");
	  }
		  
			  
	    }
 
 // performing actions by clicking next button its should show next image
 
 @Test(priority=7)
	public void next_button() {
	driver.findElement(By.xpath("//span[@class='carousel-control-next-icon']")).click();
	
	}
 
 
 
 //Enter text in Textfield  
 
 @Test(priority=8)
	public void Enter_email() throws Exception {
	driver.findElement(By.name("email")).sendKeys("Deepajeweller@gmail.com");	
	Thread.sleep(3000);
	
	//observe By clicking on "Subscribe now" button ,alert message is present or not
	
		driver.findElement(By.xpath("//button[@class='btn form-control']")).click();
		Thread.sleep(2000);

	//Get text from alert 
	Alert message=driver.switchTo().alert();
	System.out.println(message.getText());
	
	driver.switchTo().alert().accept();	
	
 }
 
 @Test(priority=9)
 public void ContactUs_Detailsfill () {
	 driver.findElement(By.linkText("Contact Us")).click(); 
	 
	 //Filling details in contact us page
	 
	 //entername
	 
	 driver.findElement(By.xpath("//input[@name='name']")).sendKeys("123sai");
	 
	//enteremail
      driver.findElement(By.xpath("//input[@name='email']")).sendKeys("123sai@gmail");
	 
    //enterphone number
    driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("12367");
    
    //enter subject
    driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("hhhhlll");
 
    //enter message
    driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("234567dfghj@#$%^");
  
    //Click on get in touch button
    driver.findElement(By.xpath("//button[@class='btn']")).click();
    
    
    

 }
 
 

 
 /*
  * Launching website on google chrome 
  * 
  */
 
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("http://eis-digital.com/djcms/");
	  
	  //Maximize the website 
	  driver.manage().window().maximize();
	
	  
  }

  @AfterTest
  public void afterTest() {
    driver.quit();	  
  }

}
