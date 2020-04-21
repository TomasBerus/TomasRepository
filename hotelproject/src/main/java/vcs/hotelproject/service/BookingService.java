package vcs.hotelproject.service;

import org.springframework.beans.factory.annotation.Autowired;

import vcs.hotelproject.model.Booking;
import vcs.hotelproject.repository.BookingRepository;

public class BookingService {
@Autowired
BookingRepository bookingRepository;

public Booking getBookingByID(int id) {
	return null;
}
public Booking getBookingByClientID(int clientID) {
	return null;
}
public Booking getBookingByRoomID(int roomID) {
	return null;
}

public Booking getBookingByPriceMore(double price) {
	return null;
}
public Booking getBookingByPriceLess(double price) {
	return null;
}
public Booking getBookingByInData(String Date) {
	return null;
}
public Booking getBookingByOutData(String Date) {
	return null;
}
public Booking getBookingByIsPayed(boolean isPayed) {
	return null;
	
}

}