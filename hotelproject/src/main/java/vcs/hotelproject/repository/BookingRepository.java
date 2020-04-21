package vcs.hotelproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vcs.hotelproject.model.Booking;
import vcs.hotelproject.model.Client;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
	@Query("Select e FROM Booking e WHERE e.clientID = :clientID")
	public List<Booking> getBookingByID(@Param("clientID")int clientID);
}
