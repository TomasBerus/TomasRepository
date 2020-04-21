package vcs.hotelproject.ui.controller;

import java.util.List;
import java.util.Optional;

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
import vcs.hotelproject.repository.BuildingRepository;
import vcs.hotelproject.repository.PriceRepository;
import vcs.hotelproject.service.BuildingService;
import vcs.hotelproject.service.PriceService;

@Controller
public class PriceController {
	@Autowired
	PriceRepository priceRepository;
	@Autowired
	PriceService priceService;
	BuildingService buildingService;
	@RequestMapping("/pricebuilding/{priceID}/")
	public String priceBuilding(@PathVariable long priceID, Model model) {
		Price price = priceRepository.getPriceByID(priceID);
		model.addAttribute("price", price);
		
		return "pricebuilding";
		
	}
	

	
	@RequestMapping(value = "/pricebuilding/{priceID}/",method = RequestMethod.POST)
	public String priceBuildingUpdate(@PathVariable long priceID, @RequestParam double basePrice, @RequestParam double priceAddon, @RequestParam String priceType, RedirectAttributes redirectAttributes) {
		Price price = priceRepository.getPriceByID(priceID);
		
		redirectAttributes.addAttribute("buildingID", price.getBuildingID());
		priceService.UpdateBuildingPrice(basePrice, priceAddon, priceType, priceID);
		return "redirect:/building/{buildingID}";
		
	}
	@RequestMapping("/pricebuildingdelete/{priceID}/")
	public String priceBuildingRemove(@PathVariable int priceID, 
			RedirectAttributes redirectAttributes) {
			Price price = priceService.findPriceByID(priceID);
			redirectAttributes.addAttribute("buildingID", price.getBuildingID());
			priceService.buildingPriceDelete(priceID);
			return "redirect:/building/{buildingID}";
		
	}
	@RequestMapping("/priceroom/{priceID}/")
	public String priceRoom(@PathVariable long priceID, Model model) {
		Price price = priceRepository.getPriceByID(priceID);
		model.addAttribute("price", price);
		
		return "priceroom";
		
	}
	
	@RequestMapping(value = "/priceroom/{priceID}/",method = RequestMethod.POST)
	public String priceRoomUpdate(@PathVariable long priceID, @RequestParam double basePrice, @RequestParam double priceAddon, @RequestParam String priceType, RedirectAttributes redirectAttributes) {
		Price price = priceRepository.getPriceByID(priceID);
		
		redirectAttributes.addAttribute("roomID", price.getRoomID());
		priceService.UpdateBuildingPrice(basePrice, priceAddon, priceType, priceID);
		return "redirect:/room/{roomID}";
		
	}
	@RequestMapping("/priceroomdelete/{priceID}/")
	public String priceRoomRemove(@PathVariable int priceID, 
			RedirectAttributes redirectAttributes) {
			Price price = priceService.findPriceByID(priceID);
			redirectAttributes.addAttribute("roomID", price.getRoomID());
			priceService.buildingPriceDelete(priceID);
			return "redirect:/room/{roomID}";
		
	}
	
	
	}

