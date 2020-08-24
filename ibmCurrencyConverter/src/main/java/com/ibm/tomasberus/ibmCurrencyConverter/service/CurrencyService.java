package com.ibm.tomasberus.ibmCurrencyConverter.service;

import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ibm.tomasberus.ibmCurrencyConverter.model.ConvertionCurrency;
import com.ibm.tomasberus.ibmCurrencyConverter.model.CurrencyAmount;
import com.ibm.tomasberus.ibmCurrencyConverter.model.CurrencyBase;
import com.ibm.tomasberus.ibmCurrencyConverter.repository.CurrencyRepository;

@Service
public class CurrencyService {
	@Autowired
	private CurrencyRepository currencyRepository;
	
	
	@Scheduled(cron = "0 0 0 * * MON-FRI", zone="GMT+3")
	public void addCurrencies() {
		XmlMapper xmlMapper = new XmlMapper();
		List<CurrencyBase> currencyList = null;
		try {
			currencyList = xmlMapper.readValue(
					new URL("https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=eu"),
					new TypeReference<List<CurrencyBase>>() {
					});

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			for (int a = 0; a < currencyList.size(); a++) {
				CurrencyBase currencyBase = currencyList.get(a);
				String date = currencyBase.getDate();
				List<CurrencyAmount> currencyAmount = currencyBase.getCurrencyAmount();
				String currencyName = currencyAmount.get(1).getName();

				Double rate = currencyAmount.get(1).getConvertionRate();
				currencyRepository.save(new ConvertionCurrency(currencyName, date, rate));

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Boolean checkCurrencyDatabase() {
		Boolean status = false;
		try {
			List<ConvertionCurrency> currency = currencyRepository.checkData();
			if (currency.isEmpty()) {
				return status;
			} else {
				status = true;

			}
		} catch (Exception e) {

		}
		return status;
	}
	public List<ConvertionCurrency> getCurrencyRatesFromDatabase(){
		List<ConvertionCurrency> currencies = currencyRepository.findAll();
		return currencies;
		
	}

	public ConvertionCurrency getCurrencyRate(String toCurrency) {
		ConvertionCurrency currency = currencyRepository.findCurrency(toCurrency);
		return currency;
	}
}