package com.hotel.management.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.hotel.management.Booking;
import com.hotel.management.HotelBookingManagement;

public class HotelBookingManagementTest {

	

	@Test
	public void book_1st_Room() {
		HotelBookingManagement management = new HotelBookingManagement(2);
		//assert
		assertEquals(true, management.bookRoom("john", "05/12/2021"));
	}

	@Test
	public void book_Room_If_No_Room_Available() {
		HotelBookingManagement management = new HotelBookingManagement(1);
		management.bookRoom("mike", "05/12/2021");
		//assert
		assertEquals(false, management.bookRoom("john", "05/12/2021"));
	}
	
	@Test
	public void Check_Rooms_Available_On_Given_Date() {
		HotelBookingManagement management = new HotelBookingManagement(5);
		management.bookRoom("mike", "05/12/2021");
		management.bookRoom("john", "08/12/2021");
		management.bookRoom("siren", "05/12/2021");
		//assert
		assertEquals(3, management.availableRooms("05/12/2021"));
	}
	
	@Test
	public void Check_Guest_Bookings() {
		HotelBookingManagement management = new HotelBookingManagement(5);
		management.bookRoom("mike", "05/12/2021");
		management.bookRoom("john", "04/5/2021");
		management.bookRoom("siren", "08/1/2021");
		management.bookRoom("mike", "20/11/2021");
		List<Booking> bookings = management.guestBookings("mike");
		//assert
		assertEquals(2, bookings.size());
	}
}
