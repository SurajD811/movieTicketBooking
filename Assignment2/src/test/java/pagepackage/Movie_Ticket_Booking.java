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
	
	@FindBy(xpath="//span[text()='Mumbai']") WebElement Select_City;
	@FindBy(id="2") WebElement Search_Box;
	@FindBy(xpath="//input[@placeholder='Search for Movies, Events, Plays, Sports and Activities']") WebElement Movie_Search;
	@FindBy(id="page-cta-container") WebElement Book_Ticket;
	@FindBy(xpath="//div[@class='sc-vhz3gb-3 dRokFO']/descendant::span[text()='2D']") WebElement format;
	@FindBy(xpath="//a[@href='/buytickets/pathaan-mumbai/movie-mumbai-ET00323848-MT/20230311']")WebElement Date;
	@FindBy(xpath="//a[@href='/booktickets/GATY/56125']") WebElement Select_Time;
	@FindBy(id="btnPopupAccept") WebElement Accept_Terms;	
	@FindBy(id="pop_4") WebElement Select_Seats;
	@FindBy(id="proceed-Qty") WebElement Proceed;
	@FindBy(id="B_4_012") WebElement Seat;
	
	
	public Movie_Ticket_Booking(WebDriver driver) 
    {
		PageFactory.initElements(driver,this);
	}

	



public void Book_Movie_Ticket() throws InterruptedException, AWTException {
	WebDriverCommonLib wdc= new WebDriverCommonLib();
	Robot rb=new Robot();
	
	//Search Movie
	Select_City.click();
	
	Search_Box.click();
	
	Movie_Search.sendKeys("Pathaan");
	wdc.wait(1000);
	rb.keyPress(KeyEvent.VK_ENTER);
	rb.keyRelease(KeyEvent.VK_ENTER);
	
	String Title = driver.getTitle();
	System.out.println(Title);
	Assert.assertEquals(Title.contains("Pathaan (2023) - Movie | Reviews, Cast & Release Date in mumbai- BookMyShow"), true);
	
	//Booking a Movie
	Book_Ticket.click();
	
	if(format.isDisplayed()==true) {
	     format.click();
	}
	
	Date.click();
	
	//Selecting The Timing
	wdc.javaScript(0,100);
	Select_Time.click();
	
	//Terms and Conditions
	Accept_Terms.click();
	
	//Seat Selection
	Select_Seats.click();
	Proceed.click();
	Seat.click();
	
	
	
	String title_of_the_page = driver.getTitle();
	Assert.assertEquals(title_of_the_page.contains("Pathaan 2D Movie, Showtimes in Mumbai & Online Ticket Booking"),true);
	
	
}
}
