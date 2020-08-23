package com.ibm.tomasberus.ibmCurrencyConverter.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.tomasberus.ibmCurrencyConverter.model.UserAction;
import com.ibm.tomasberus.ibmCurrencyConverter.repository.UserActionRepository;




@Service
public class UserActionService {
	@Autowired
	UserActionRepository userActionRepository;
	
	public void saveUserActions(String currencyUsed, Double enteredAmount, Double result ) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime dateNow = LocalDateTime.now();  
		  String date = dateFormat.format(dateNow); 
		
		  userActionRepository.save(new UserAction(currencyUsed, enteredAmount, result, date));
	}
	
}
