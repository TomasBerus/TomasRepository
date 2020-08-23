package com.ibm.tomasberus.ibmCurrencyConverter.model;

import javax.persistence.Entity; 
import javax.persistence.Id;



@Entity
public class ConvertionCurrency {
	
	@Id
	private String currencyName;
	private String date;
	private double convertionRateToEUR;
	
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getConvertionRateToEUR() {
		return convertionRateToEUR;
	}
	public void setConvertionRateToEUR(double convertionRateToEUR) {
		this.convertionRateToEUR = convertionRateToEUR;
	}
	public ConvertionCurrency( String currencyName, String date, double convertionRateToEUR) {
		super();
		
		this.currencyName = currencyName;
		this.date = date;
		this.convertionRateToEUR = convertionRateToEUR;
	}
	public ConvertionCurrency() {
		super();
	}
	@Override
	public String toString() {
		return "ConvertionCurrency currencyName=" + currencyName + ", date=" + date
				+ ", convertionRateToEUR=" + convertionRateToEUR + "]";
	}
	
	}
	
