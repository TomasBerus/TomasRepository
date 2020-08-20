package com.ibm.tomasberus.ibmCurrencyConverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.tomasberus.ibmCurrencyConverter.service.CurrencyService;

@RestController(value ="/currencies")
public class CurrencyConverterController {
	@Autowired
	CurrencyService currencyService;
	
	@GetMapping()
	public String getCurrencies() {
		return currencyService.getCurrencyString();
	}
	

}
