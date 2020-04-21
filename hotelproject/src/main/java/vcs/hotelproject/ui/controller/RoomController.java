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

import vcs.hotelproject.model.Building;
import vcs.hotelproject.model.Price;
import vcs.hotelproject.model.Room;
import vcs.hotelproject.repository.RoomRepository;
import vcs.hotelproject.service.PriceService;
import vcs.hotelproject.service.RoomService;

@Controller
public class RoomController {
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	RoomService roomService;
	@Autowired
	PriceService priceService;

	@RequestMapping("/room/{roomID}")
	public String room(@PathVariable long roomID, Model model) {
		Room room = (Room) roomRepository.findById((long) roomID).get();
		Building building = room.getBuilding();
		List<Price> price = priceService.findAllRoomByID(roomID);
		model.addAttribute("building", building);
		
		model.addAttribute("room", (Room) roomRepository.findById((long) roomID).get());
		model.addAttribute("prices", price);
		return "room";
	}

	@RequestMapping(value = "/room/{roomID}/", method = RequestMethod.POST)
	public String roomUpdate(@PathVariable long roomID, @RequestParam String roomNumber, @RequestParam String roomType,
			@RequestParam String description, Model model) {
		roomService.updateRoom(roomNumber, roomType, description, roomID);
		model.addAttribute("room", (Room) roomRepository.findById((long) roomID).get());

		return "redirect:/room/{roomID}";

	}

	@RequestMapping("/roomdelete/{roomID}/")
	public String roomRemove(@PathVariable int roomID,

			RedirectAttributes redirectAttributes) {
		Room room = roomRepository.findById((long) roomID).get();
		Building building = room.getBuilding();

		redirectAttributes.addAttribute("buildingID", building.getBuildingID());
		roomRepository.delete(room);

		return "redirect:/building/{buildingID}";

	}

	@RequestMapping(value = "/room/{roomID}/", method = RequestMethod.POST, params = { "createRoomPrice",
			"!createBuildingPrice" })
	public String createBuildingPrice(@PathVariable long roomID, @RequestParam String priceType,
			@RequestParam double basePrice, @RequestParam double priceAddon, Model model) {
		long buildingID = 0;
		priceService.savNewPrice(roomID, buildingID, priceType, basePrice, priceAddon);
		List<Price> price = priceService.findAllRoomByID(roomID);
		model.addAttribute("prices", price);
		return "redirect:/room/{roomID}/";
	}

}
