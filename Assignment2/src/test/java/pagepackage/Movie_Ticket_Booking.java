package pagepackage;




import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

import genrics.BaseTest;
import genrics.WebDriverCommonLib;

public class Movie_Ticket_Booking extends BaseTest {
	
	@FindBy(xpath="//span[text()='Mumbai']")private WebElement Select_City;
	@FindBy(id="2")private WebElement Search_Box;
	@FindBy(xpath="//input[@placeholder='Search for Movies, Events, Plays, Sports and Activities']")private WebElement Movie_Search;
	@FindBy(id="page-cta-container")private WebElement Book_Ticket;
	@FindBy(xpath="//a[@href='/booktickets/FMMA/152504']")private WebElement Select_Time;
	@FindBy(id="btnPopupAccept")private WebElement Accept_Terms;	
	@FindBy(id="pop_4")private WebElement Select_Seats;
	@FindBy(id="proceed-Qty")private WebElement Proceed;
	
	
	public Movie_Ticket_Booking(WebDriver driver) 
    {
		PageFactory.initElements(driver,this);
	}

	
	public WebElement getSelect_City() {
		return Select_City;
	}


	public WebElement getSearch_Box() {
		return Search_Box;
	}


	public WebElement getMovie_Search() {
		return Movie_Search;
	}


	public WebElement getBook_Ticket() {
		return Book_Ticket;
	}


	public WebElement getSelect_Time() {
		return Select_Time;
	}


	public WebElement getAccept_Terms() {
		return Accept_Terms;
	}


	public WebElement getSelect_Seats() {
		return Select_Seats;
	}


	public WebElement getProceed() {
		return Proceed;
	}





@Test
public void Book_Movie_Ticket() throws InterruptedException, AWTException {
	
	Select_City.click();
	Search_Box.click();
	Movie_Search.sendKeys("Pathaan");
	Thread.sleep(2000);
	Robot rb=new Robot();
	rb.keyPress(KeyEvent.VK_ENTER);
	rb.keyRelease(KeyEvent.VK_ENTER);
	Book_Ticket.click();
	WebDriverCommonLib wdc= new WebDriverCommonLib();
	wdc.javaScript(0,400);
	Select_Time.click();
	Accept_Terms.click();
	Select_Seats.click();
	Proceed.click();
	String title_of_the_page = driver.getTitle();
	Assert.assertEquals(title_of_the_page.contains("Pathaan 2D Movie, Showtimes in Mumbai & Online Ticket Booking"),true);
	
	
}
}
