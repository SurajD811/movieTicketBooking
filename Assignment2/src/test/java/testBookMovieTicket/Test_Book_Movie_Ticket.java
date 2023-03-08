package testBookMovieTicket;

import java.awt.AWTException;

import org.testng.annotations.Test;

import genrics.BaseTest;
import pagepackage.Movie_Ticket_Booking;

public class Test_Book_Movie_Ticket extends BaseTest {
	
	@Test
	public void testBooking() throws InterruptedException, AWTException {
		
		Movie_Ticket_Booking mtb= new Movie_Ticket_Booking(driver);
		mtb.Book_Movie_Ticket();
		
	}

}
