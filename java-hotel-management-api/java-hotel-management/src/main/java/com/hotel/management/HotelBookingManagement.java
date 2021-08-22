package com.hotel.management;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

public class HotelBookingManagement {
	int rooms;
	List<Booking> bookings = new ArrayList<Booking>();
	
	public HotelBookingManagement() {
		this.rooms = 20;
	}
	
	
	public HotelBookingManagement(int rooms) {
		this.rooms = rooms;
	}
	
	@RequestMapping("/bookRoom")
	public Boolean bookRoom(String name, String date) {
		int num = availableRooms(date);

		if (num > 0) {
			bookings.add(new Booking(name, rooms - num + 1, date));
			return true;
		}
		return false;
	}

	@RequestMapping("/availableRooms")
	public int availableRooms(String date) {
		int availableRooms = rooms;
		for (Booking booking : bookings) {
			if (date == booking.date) {
				availableRooms--;
			}
		}
		return availableRooms;
	}

	@RequestMapping("/guestRooms")
	public List<Booking> guestBookings(String name) {
		List<Booking> bookings = new ArrayList<Booking>();

		for (Booking booking : this.bookings) {
			if (booking.name == name) {
				bookings.add(booking);
			}
		}
		return bookings;
	}
	
}