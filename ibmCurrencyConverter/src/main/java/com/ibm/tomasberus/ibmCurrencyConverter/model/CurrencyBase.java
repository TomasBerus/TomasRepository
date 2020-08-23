package com.ibm.tomasberus.ibmCurrencyConverter.model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class CurrencyBase {
	@JacksonXmlProperty(localName = "Tp")
	private String type;
	@JacksonXmlProperty(localName = "Dt")
	private String date;
	@JacksonXmlProperty(localName = "CcyAmt")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<CurrencyAmount> currencyAmount;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<CurrencyAmount> getCurrencyAmount() {
		return currencyAmount;
	}
	public void setCurrencyAmount(List<CurrencyAmount> currencyAmount) {
		this.currencyAmount = currencyAmount;
	}
	public CurrencyBase(String type, String date, List<CurrencyAmount> currencyAmount) {
		super();
		this.type = type;
		this.date = date;
		this.currencyAmount = currencyAmount;
	}
	public CurrencyBase() {
		super();
	}
	@Override
	public String toString() {
		return "CurrencyBase [type=" + type + ", date=" + date + ", currencyAmount=" + currencyAmount + "]";
	}
	
	
	
}
