package com.ibm.tomasberus.ibmCurrencyConverter.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class CurrencyRepository {

	public List<String> findAllCurrencies(){
		return Arrays.asList("USD","EUR","GBP");
		
	}

}

