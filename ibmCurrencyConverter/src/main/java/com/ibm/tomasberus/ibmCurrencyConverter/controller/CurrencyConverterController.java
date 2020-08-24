package com.ibm.tomasberus.ibmCurrencyConverter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ibm.tomasberus.ibmCurrencyConverter.model.ConvertionCurrency;
import com.ibm.tomasberus.ibmCurrencyConverter.model.CurrencyBase;
import com.ibm.tomasberus.ibmCurrencyConverter.service.CurrencyService;
import com.ibm.tomasberus.ibmCurrencyConverter.service.UserActionService;

@Controller
public class CurrencyConverterController {
	@Autowired
	CurrencyService currencyService;

	@Autowired
	UserActionService userActionService;

	@GetMapping("/")
    public String index()
    {
        return "redirect:/index";
    }

	@GetMapping(value = "/index")
	public String currency(Model model, Double amount) {
		amount = (double) 1;
		if (currencyService.checkCurrencyDatabase().equals(false)) {
			currencyService.addCurrencies();
			List<ConvertionCurrency> currency = currencyService.getCurrencyRatesFromDatabase();
			model.addAttribute("currency", currency);
			return "redirect:/index";
		} else {
			List<ConvertionCurrency> ConvertionCurrency = currencyService.getCurrencyRatesFromDatabase();
			model.addAttribute("ConvertionCurrency", ConvertionCurrency);

		}

		return "/index";

	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String convertCurrency(@RequestParam String toCurrency, Double amount, Model model,
			RedirectAttributes redirectAttributes) {

		if (!(amount == null)) {

			try {
				ConvertionCurrency currency = currencyService.getCurrencyRate(toCurrency);
				Double conRate = currency.getConvertionRateToEUR();
				Double result = amount * conRate;
				String currencyUsed = toCurrency;
				Double enteredAmount = amount;
				userActionService.saveUserActions(currencyUsed, enteredAmount, result);
				redirectAttributes.addFlashAttribute("result", result);
				redirectAttributes.addFlashAttribute("currencyUsed", currencyUsed);
				redirectAttributes.addFlashAttribute("enteredAmount", enteredAmount);
				redirectAttributes.addFlashAttribute("successClass", "alert-success");
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("message", "A positive number is needed");
				redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			}
		} else {
			redirectAttributes.addFlashAttribute("message", "A positive number is needed");
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		}

		return "redirect:/index";

	}
}
