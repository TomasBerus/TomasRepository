package vcs.hotelproject.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vcs.hotelproject.model.Client;
import vcs.hotelproject.service.ClientService;

@Controller
public class LoginController {
	@Autowired
	ClientService clientService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginClient(@RequestParam String email, @RequestParam String password,
			RedirectAttributes redirectAttributes, Model model) {
		
		
		Client client = clientService.findClientByEmailAndPassword(email, password);
		
		if(client != null) {
			
		//redirectAttributes.addAttribute("clientID", client.getClientID());

		return "redirect:/buildings/";
		} else {
			
			 redirectAttributes.addFlashAttribute("message", "Email or password is incorrect.");
			    redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/login/";}
	}

}
