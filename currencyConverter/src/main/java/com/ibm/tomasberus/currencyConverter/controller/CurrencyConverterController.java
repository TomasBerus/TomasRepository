package com.ibm.tomasberus.currencyConverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.tomasberus.currencyConverter.service.CurrencyService;

@RestController(value ="/currencies")
public class CurrencyConverterController {
	@Autowired
	CurrencyService currencyService;
	
	@RequestMapping(value ="/currencies")
	public String getCurrencies() {
		return currencyService.getCurrencyString();
	}
	

}
