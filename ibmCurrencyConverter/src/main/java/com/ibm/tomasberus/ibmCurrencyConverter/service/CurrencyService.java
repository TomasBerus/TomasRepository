package com.ibm.tomasberus.ibmCurrencyConverter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.tomasberus.ibmCurrencyConverter.repository.CurrencyRepository;

@Service
public class CurrencyService {
	@Autowired
	private CurrencyRepository currencyRepository;
	
	public CurrencyService(CurrencyRepository currencyRepository){
		this.currencyRepository = currencyRepository;
	}
	
	public String getCurrencyString() {
		return currencyRepository.findAllCurrencies().get(0);
		
	}
}