package com.ibm.tomasberus.currencyConverter.service;

import org.springframework.stereotype.Service;

import com.ibm.tomasberus.currencyConverter.repository.CurrencyRepository;

@Service
public class CurrencyService {
	private CurrencyRepository currencyRepository;
	
	public CurrencyService(CurrencyRepository currencyRepository){
		this.currencyRepository = currencyRepository;
	}
	
	public String getCurrencyString() {
		return currencyRepository.findAllCurrencies().get(0);
		
	}
}
