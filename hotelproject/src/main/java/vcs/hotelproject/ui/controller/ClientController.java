package vcs.hotelproject.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vcs.hotelproject.model.Client;
import vcs.hotelproject.service.ClientService;

@Controller
//@RequestMapping("/client") // http://localhost:8080/client
public class ClientController {

	@Autowired
	ClientService clientService;

	@RequestMapping(value = "/clientregistry", method = RequestMethod.GET)
	public String client() {
		return "/clientregistry";

	}

	@RequestMapping(value = "/clientregistry", method = RequestMethod.POST)
	public String clientAdd(@RequestParam String email, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String password, @RequestParam String number, RedirectAttributes redirectAttributes) {
		Client testEmail = clientService.checkClientEmailAvailabilaty(email);
		Client testPhone = clientService.checkClientPhoneAvailabilaty(number);

		if (testEmail == null && testPhone == null) {
			
			clientService.saveNewClient(email, firstName, lastName, password, number);
			
			
			//Client client = clientService.findClientByEmailAndPassword(email, password);

			//redirectAttributes.addAttribute("clientID", client.getClientID());
			return "redirect:/buildings/";
		} else  {
			redirectAttributes.addFlashAttribute("message", "Email  or phone already exists");
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/clientregistry/";
		} 
		} 
	

	@RequestMapping(value = "client/{clientID}", method = RequestMethod.GET)
	public String clientView(@PathVariable int clientID, Model model) {
		model.addAttribute("client", clientService.findClientById(clientID));
		return "client";

	}

	@RequestMapping(value = "clientupdate/{clientID}", method = RequestMethod.GET)
	public String clientUpdateView(@PathVariable int clientID, Model model) {
		model.addAttribute("client", clientService.findClientById(clientID));
		return "clientupdate";
	}

	@RequestMapping(value = "clientupdate/{clientID}", method = RequestMethod.POST)
	public String clientUpdate(@PathVariable long clientID, @RequestParam String email, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String phoneNumber) {
		clientService.updateClient(email, firstName, lastName, phoneNumber, clientID);

		return "redirect:/client/{clientID}";

	}

	@RequestMapping(value = "clientpasschange/{clientID}", method = RequestMethod.GET)
	public String clientPassword(@PathVariable long clientID, Model model) {
		model.addAttribute("client", clientService.findClientById(clientID));
		return "clientpasschange";
	}

	@RequestMapping(value = "clientpasschange/{clientID}", method = RequestMethod.POST)
	public String clientPasswordChange(@PathVariable long clientID, @RequestParam String oldPassword,
			@RequestParam String newPassword, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			clientService.updateClientPassword(oldPassword, newPassword, clientID);

		return "redirect:/client/{clientID}";
	}

}
