package com.ibm.tomasberus.ibmCurrencyConverter.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "FxRates")
public class Currency {
	@JacksonXmlProperty(localName = "FxRate")
	@JacksonXmlElementWrapper(useWrapping = true)
	private CurrencyBase currencyBase;

	public CurrencyBase getCurrencyBase() {
		return currencyBase;
	}

	public void setCurrencyBase(CurrencyBase currencyBase) {
		this.currencyBase = currencyBase;
	}

	public Currency(CurrencyBase currencyBase) {
		super();
		this.currencyBase = currencyBase;
	}

	public Currency() {
		super();
	}

}
