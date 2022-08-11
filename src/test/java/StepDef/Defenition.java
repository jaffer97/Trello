package StepDef;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.PageObjects;

public class Defenition {
	public static WebDriver driver;

	
	@Given("Launch the URl {string}")
	public void launch_the_u_rl(String string) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SVNHQW744\\Testing2\\Driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 driver.get(string);
	}
	
	
	@When("user Enter the login cerdentials username {string} and password {string}")
	public void user_enter_the_login_cerdentials_username_and_password(String useremail, String password) throws InterruptedException {
		Thread.sleep(3000);
		
		WebElement username = driver.findElement(By.xpath(PageObjects.user_Email));
		username.click();
		username.sendKeys(useremail);
		Thread.sleep(1000);
		WebElement log_Btn = driver.findElement(By.xpath(PageObjects.login_Btn));
		log_Btn.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement password1 = driver.findElement(By.xpath(PageObjects.user_Password));
		password1.click();
		password1.sendKeys(password);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement log_Btn2 = driver.findElement(By.xpath(PageObjects.login_Btn2));
		log_Btn2.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
	
	
	@When("Click on Boards")
	public void click_on_boards() throws Throwable {
		
		WebElement create_Board = driver.findElement(By.xpath(PageObjects.create_Board));
		create_Board.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Set<String> wh = driver.getWindowHandles();
		System.out.println(wh.size());
		
		for(String window :wh) {
			String title = driver.switchTo().window(window).getTitle();
			System.out.println(title);
		}
		Thread.sleep(5000);	
		}


	@Given("Enter the board title and Click on Create {string}")
	public void enter_the_board_title_and_click_on_create(String string) {
		
		WebElement board_Title = driver.findElement(By.xpath(PageObjects.board_Title));
		board_Title.click();
		board_Title.sendKeys(string);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	
		WebElement create_Btn = driver.findElement(By.xpath(PageObjects.create_Btn));
		create_Btn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	@When("Click on add another list")
	public void click_on_add_another_list() {
		WebElement add_Another_List = driver.findElement(By.xpath(PageObjects.add_Another_List));
		add_Another_List.click();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		
	}
	
	
	
	@When("Add two list named as {string} and {string}")
	public void add_two_list_named_as_and(String string1, String string2) throws Throwable {
		Thread.sleep(2000);
		WebElement add_Another_List_Name = driver.findElement(By.xpath(PageObjects.add_Another_List_Name));
		add_Another_List_Name.click();
		add_Another_List_Name.sendKeys(string1);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		WebElement add_Another_List_Btn = driver.findElement(By.xpath(PageObjects.add_Another_List_Btn));
		add_Another_List_Btn.click();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	
		Thread.sleep(2000);
		
		WebElement add_Another_List_Name1 = driver.findElement(By.xpath(PageObjects.add_Another_List_Name));
		add_Another_List_Name1.click();
		add_Another_List_Name1.sendKeys(string2);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		WebElement add_Another_List_Btn2 = driver.findElement(By.xpath(PageObjects.add_Another_List_Btn));
		add_Another_List_Btn2.click();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		
		WebElement add_Card = driver.findElement(By.xpath(PageObjects.add_Card));
		add_Card.click();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

		Thread.sleep(3000);
		WebElement add_Card_Text = driver.findElement(By.xpath(PageObjects.add_Card_Text));
		add_Card_Text.click();
		add_Card_Text.sendKeys("Smoke Test 1");
		
		WebElement add_Card_Btn = driver.findElement(By.xpath(PageObjects.add_Card_Btn));
		add_Card_Btn.click();
		Thread.sleep(3000);
		
	}
	
	
	
	@When("Add card to list and move that to List B")
	public void add_card_to_list_and_move_that_to_list_b() throws Throwable {

		Actions a = new Actions(driver);
		
		WebElement list_A = driver.findElement(By.xpath(PageObjects.list_A));
		a.contextClick(list_A).build().perform();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		WebElement move_Btn = driver.findElement(By.xpath(PageObjects.move_Btn));
		move_Btn.click();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
//		WebElement suggested_Btn = driver.findElement(By.xpath(PageObjects.suggested_Btn));
//		suggested_Btn.click();
//		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
//		Thread.sleep(3000);
		
		WebElement dropdown = driver.findElement(By.xpath(PageObjects.dropdown));
		dropdown.click();
		Thread.sleep(1000);
		Select s = new Select(dropdown);
		s.selectByVisibleText("A");
		Thread.sleep(3000);
		
		WebElement move_Btn2 = driver.findElement(By.xpath(PageObjects.move_Btn2));
		move_Btn2.click();
		
		Thread.sleep(3000);
		try {
		int x = list_A.getLocation().getX();
		int y = list_A.getLocation().getY();
		System.out.println("The X coordinate is "+x);
		System.out.println("The Y coordinate is "+y);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		WebElement profile_Btn = driver.findElement(By.xpath(PageObjects.profile_Btn));
		profile_Btn.click();
		
		
		
		
		Thread.sleep(4000);
		WebElement logout_Btn = driver.findElement(By.xpath(PageObjects.logout_Btn));
		logout_Btn.click();
		
		Thread.sleep(10000);
		driver.close();
		driver.quit();
	}




}
