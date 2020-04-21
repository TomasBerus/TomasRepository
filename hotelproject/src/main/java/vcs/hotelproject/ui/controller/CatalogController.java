package vcs.hotelproject.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vcs.hotelproject.repository.BuildingRepository;
import vcs.hotelproject.repository.ClientRepository;
import vcs.hotelproject.repository.RoomRepository;

@Controller
public class CatalogController {
	
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	BuildingRepository buildingRepository;
	@Autowired
	ClientRepository clientRepository;
	
	@RequestMapping(value = "/catalog/", method = RequestMethod.GET)
	public String catalogList(@PathVariable long clientID,Model model) {
		model.addAttribute("client", clientRepository.findById(clientID));
		model.addAttribute("buildings", buildingRepository.findAll());
		return "catalog";
}}
