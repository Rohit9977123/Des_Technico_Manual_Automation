package SecureFileSharing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileSharing {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		// Create a new instance of the ChromeDriver
		driver=new ChromeDriver();
		
		// Set an implicit wait of 10 seconds (waits for elements before throwing NoSuchElementException)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	   // Open the login page of the file-sharing application
		driver.get("https://file-sharing-application.netlify.app/login");
		
	 // Maximize the browser window for better visibility
		driver.manage().window().maximize();
	}
	@Test(enabled =   false)
	public void Signup()
	{
		// Clicks on a specific element ( sign-up button) using a CSS selector
		driver.findElement(By.cssSelector("#root > div > div.css-1ge78x1 > div > div.css-1o7k574 > div > div.css-8q8yev > p > span")).click();
		
		// Enters the full name "Rohit Chouhan" in the input field with the placeholder "Enter Your Full Name"
		driver.findElement(By.cssSelector("[placeholder=\"Enter Your Full Name\"]")).sendKeys("Rohit Chouhan");
		
		// Enters the email address "rohitchouhankgn11@gmail.com" in the input field with the placeholder "example@gmail.com"
		driver.findElement(By.cssSelector("[placeholder=\"example@gmail.com\"]")).sendKeys("rohitchouhankgn11@gmail.com");
		
		// Enters the password "rohit@123" in the input field with the placeholder "Enter Your Password"
		driver.findElement(By.cssSelector("[placeholder=\"Enter Your Password\"]")).sendKeys("rohit@123");
		
		// Clicks on the submit button (possibly to log in or sign up) identified by the class "chakra-button css-rxecov
		driver.findElement(By.cssSelector("[class=\"chakra-button css-rxecov\"]")).click();
		
	}
	@Test(priority = 1)
	public void login()
	{
		// Locate the email input field using CSS selector and enter the email
		driver.findElement(By.cssSelector("[placeholder=\"example@gmail.com\"]")).sendKeys("rohitchouhankgn11@gmail.com");
		
		// Locate the password input field using CSS selector and enter the password
		driver.findElement(By.cssSelector("[placeholder=\"Enter Your Password\"]")).sendKeys("rohit@123");
		
		// Locate the login button using CSS selector and click on it
		driver.findElement(By.cssSelector("[class=\"chakra-button css-rxecov\"]")).click();
		
		//// Retrieve the text from the success alert message
		String Text=driver.findElement(By.cssSelector("[class=\"chakra-alert__title css-tidvy5\"]")).getText();
		
		// Check if the retrieved text contains "Login Success!"
		
		if(Text.contains("Login Success!"))
		{
			System.out.println("Success"); // Print "Success" if login was successful
		}
		else
		{
			System.out.println("Fail"); // Print "Fail" if login was unsuccessful
		}
	}
	
	@Test(priority = 2)
	public void uploadFile() throws InterruptedException
	{     
		// Pause execution for 2 seconds to allow the page to load properly
		Thread.sleep(2000);
		
		// Locate the file input field and upload the file by providing the absolute file path
		driver.findElement(By.cssSelector("[type=\"file\"]")).sendKeys("D://AI gen//_Test_Plan.pdf");

		// Locate and click the checkbox (assuming it's for agreeing to terms or enabling file sharing
		driver.findElement(By.cssSelector("[class=\"chakra-checkbox__label css-6x44c9\"]")).click();
		
		// Locate the password input field and enter "1234" (assuming this is to set a password for the shared file)
		driver.findElement(By.cssSelector("[class=\"chakra-input css-13e75gm\"]")).sendKeys("1234");
		
		// Locate and click the submit/upload button to share the file
		driver.findElement(By.cssSelector("[class=\"chakra-button css-rxecov\"]")).click();
		
		// Retrieve the success message displayed after file upload
		String Text1=driver.findElement(By.cssSelector("[class=\"chakra-heading css-18j379d\"]")).getText();
		
		// Check if the message contains the expected confirmation text
		if(Text1.contains("Copy the link above & share it with your friends."))
		{
			System.out.println("Success");// Print "Success" if file upload was successful
		}
		else
		{
			System.out.println("Fail"); // Print "Fail" if the expected message is not found
		}
		

	}
	@Test 
	public void Teadown()
	
	{   // Close the browser window
			driver.close();
			
	}
	
	
	}
	
	


