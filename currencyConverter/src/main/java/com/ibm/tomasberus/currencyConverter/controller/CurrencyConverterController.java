package com.ibm.tomasberus.currencyConverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.tomasberus.currencyConverter.service.CurrencyService;

@Controller()
public class CurrencyConverterController {
	@Autowired
	CurrencyService currencyService;

	@RequestMapping(method = RequestMethod.GET, value = "/cur")
	public String getCurrencies() {
		return "Hi";

	}
}
