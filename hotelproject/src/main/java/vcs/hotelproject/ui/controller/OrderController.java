package vcs.hotelproject.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vcs.hotelproject.model.Booking;
import vcs.hotelproject.model.Building;
import vcs.hotelproject.model.Client;
import vcs.hotelproject.model.Price;
import vcs.hotelproject.model.Room;
import vcs.hotelproject.repository.BookingRepository;
import vcs.hotelproject.repository.BuildingRepository;
import vcs.hotelproject.repository.RoomRepository;
import vcs.hotelproject.service.BuildingService;
import vcs.hotelproject.service.ClientService;
import vcs.hotelproject.service.PriceService;
import vcs.hotelproject.service.RoomService;

@Controller
public class OrderController {
	@Autowired
	RoomService roomService;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	BuildingService buildingService;
	@Autowired
	BuildingRepository buildingRepository;
	@Autowired
	PriceService priceService;
	@Autowired
	ClientService clientService;
	@Autowired
	BookingRepository bookingRepository;

	@RequestMapping("/ordercreate/{buildingID}")
	public String order(@PathVariable long buildingID, Model model, RedirectAttributes redirectAttributes) {
		Building building = buildingRepository.getBuildingByID((long) buildingID);
		List<Room> room = building.getRooms();
		//Price priceBuilding = priceService.findSingleBuildingByID(buildingID);
		// Price priceRoom = priceService.findSingleRoomByID(roomID);
		// double totalPrice = 200;
		// totalPrice = priceBuilding.getBasePrice() + priceRoom.getBasePrice()
		// +(priceBuilding.getBasePrice() * priceBuilding.getPriceAddon() +
		// priceRoom.getBasePrice() * priceRoom.getPriceAddon());
		// redirectAttributes.addAttribute("totalPrice", priceRoom);
		model.addAttribute("building", building);
		model.addAttribute("rooms", room);

		return "ordercreate";
	}

	@RequestMapping(value = "/ordercreate/{buildingID}", method = RequestMethod.POST)
	public String orderCreate(@PathVariable long buildingID,  @RequestParam long roomID, @RequestParam long clientID,  
			
			@RequestParam double totalPrice, @RequestParam String inDate, @RequestParam String outDate, 
			
			@RequestParam String paytype, @RequestParam String email, @RequestParam String password,
			
			Model model,RedirectAttributes redirectAttributes)  {
		
		Room room = roomRepository.getRoomByID(roomID);
		Client client = clientService.findClientByEmailAndPassword(email, password);
		
		if(client != null) {
			
		String payDate = outDate;
		
		bookingRepository.save(new Booking(room,client,totalPrice,inDate,outDate,paytype,payDate));

		return "redirect:/catalog/";
		} else {
			
			 redirectAttributes.addFlashAttribute("message", "Email or password is incorrect.");
			    redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			
		
		return "redirect:/ordercreate/{buildingID}";
	}

}}
