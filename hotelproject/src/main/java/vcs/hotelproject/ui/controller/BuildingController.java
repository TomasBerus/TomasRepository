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
import vcs.hotelproject.repository.BuildingRepository;
import vcs.hotelproject.repository.RoomRepository;
import vcs.hotelproject.service.BuildingService;
import vcs.hotelproject.service.PriceService;
import vcs.hotelproject.service.RoomService;

@Controller
public class BuildingController {
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

	@RequestMapping("/building/{buildingID}")
	public String building(@PathVariable int buildingID, Model model) {
		
		Building building = buildingService.getBuilding(buildingID);
		List<Room> room = building.getRooms();
		List<Price> price = priceService.findAllBuildingByID(buildingID);
		model.addAttribute("building", (Building) buildingRepository.findById((long) buildingID).get());
		model.addAttribute("rooms", room);
		model.addAttribute("prices", price);
		return "building";

	}

	@RequestMapping(value = "buildings", method = RequestMethod.GET)
	public String buildingsList(Model model) {
		model.addAttribute("buildings", buildingRepository.findAll()); 
		return "buildings";

	}

	@RequestMapping(value = "/buildings", method = RequestMethod.POST)
	public String buildingsAdd(@RequestParam String address, @RequestParam String city,
			@RequestParam String buildingType, Model model, RedirectAttributes redirectAttributes) {

		Building testAdress = buildingService.checkAddress(address, city);
		
		if (testAdress == null) {
			Building newBuilding = new Building();
			newBuilding.setAddress(address);
			newBuilding.setCity(city);
			newBuilding.setBuildingType(buildingType);

			buildingRepository.save(newBuilding);
			model.addAttribute("building", newBuilding);
			model.addAttribute("buildings", buildingRepository.findAll());
			return "redirect:/building/" + newBuilding.getBuildingID();
		}else {
			redirectAttributes.addFlashAttribute("message", "Adress exists in this city");
		    redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		return "redirect:/buildings/";}
		}
		
	

	@RequestMapping(value = "/building/{buildingID}/", method = RequestMethod.POST, params = { "createRoom",
			"!createBuildingPrice" })
	public String buildingsAddRoom(@PathVariable Long buildingID, @RequestParam String roomNumber,
			@RequestParam String roomType, @RequestParam String description, Model model, RedirectAttributes redirectAttributes) {
		Building CurrentBuilding = buildingRepository.getBuildingByID(buildingID);

		Room test = roomService.checkNumber(roomNumber, buildingID);
		
		if(test == null) {
			
			roomRepository.save(new Room(CurrentBuilding, roomNumber, roomType, description));
			model.addAttribute("building", buildingRepository.findById(buildingID));
			model.addAttribute("rooms", roomRepository.findAll());
			return "redirect:/building/" + CurrentBuilding.getBuildingID();
		} else {
			redirectAttributes.addFlashAttribute("message", "Room Number already exists");
		    redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/building/{buildingID}";
		}
		
	}

	@RequestMapping(value = "/buildingupdate/{buildingID}/", method = RequestMethod.GET)
	public String buildingUpdate(@PathVariable int buildingID, Model model) {
		model.addAttribute("building", (Building) buildingRepository.findById((long) buildingID).get());
		return "buildingupdate";
	}

	@RequestMapping(value = "/buildingupdate/{buildingID}/", method = RequestMethod.POST)
	public String buildingUpdateActive(@PathVariable int buildingID, @RequestParam String address,
			@RequestParam String city, @RequestParam String buildingType, Model model) {
		model.addAttribute("building", (Building) buildingRepository.findById((long) buildingID).get());
		buildingService.updateBuilding(address, city, buildingType, buildingID);
		return "redirect:/buildings/";
	}

	@RequestMapping("/buildingdelete/{buildingID}")
	public String buildingDelete(@PathVariable long buildingID) {
		buildingService.deleteBuilding(buildingID);
		return "redirect:/buildings/";

	}

	@RequestMapping(value = "/building/{buildingID}/", method = RequestMethod.POST, params = { "createBuildingPrice",
			"!createRoomPrice" })
	public String createBuildingPrice(@PathVariable long buildingID, @RequestParam String priceType,
			@RequestParam double basePrice, @RequestParam double priceAddon, Model model) {
		long roomID = 0;
		priceService.savNewPrice(roomID, buildingID, priceType, basePrice, priceAddon);
		List<Price> price = priceService.findAllBuildingByID(buildingID);
		model.addAttribute("prices", price);
		return "redirect:/building/{buildingID}";
	}

}
