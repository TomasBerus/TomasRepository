package vcs.hotelproject.aplication;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import vcs.hotelproject.repository.BookingRepository;
import vcs.hotelproject.repository.BuildingRepository;
import vcs.hotelproject.repository.ClientRepository;
import vcs.hotelproject.repository.PriceRepository;
import vcs.hotelproject.repository.RoomRepository;
import vcs.hotelproject.service.ClientService;
import vcs.hotelproject.service.RoomService;


@SpringBootApplication(scanBasePackages = {"vcs"})
@EntityScan(basePackages = {"vcs"})
@EnableJpaRepositories(basePackages = {"vcs"})
public class HotelApp implements CommandLineRunner {

	
	@Autowired
	BuildingRepository buildingRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	PriceRepository priceRepository;
	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	ClientService clientService;
	@Autowired
	RoomService roomService;
	public static void main(String[] args) {

		SpringApplication.run(HotelApp.class, args);
	}

	public void run(String... args) throws Exception {
		
		
	}

}
