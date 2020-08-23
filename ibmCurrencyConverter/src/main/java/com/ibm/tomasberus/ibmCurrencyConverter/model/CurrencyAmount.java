package com.ibm.tomasberus.ibmCurrencyConverter.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class CurrencyAmount {
	@JacksonXmlProperty(localName = "Ccy")
	private String Name;
	@JacksonXmlProperty(localName = "Amt")
	private double ConvertionRate;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getConvertionRate() {
		return ConvertionRate;
	}
	public void setConvertionRate(double convertionRate) {
		ConvertionRate = convertionRate;
	}
	public CurrencyAmount(String name, double convertionRate) {
		super();
		Name = name;
		ConvertionRate = convertionRate;
	}
	public CurrencyAmount() {
		super();
	}
	@Override
	public String toString() {
		return "CurrencyAmount [Name=" + Name + ", ConvertionRate=" + ConvertionRate + "]";
	}
	
}
