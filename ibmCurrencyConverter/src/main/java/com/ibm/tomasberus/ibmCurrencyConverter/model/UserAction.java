package com.ibm.tomasberus.ibmCurrencyConverter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String usedCurrency;
	private double amountEntered;
	private double result;
	private String date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsedCurrency() {
		return usedCurrency;
	}

	public void setUsedCurrency(String usedCurrency) {
		this.usedCurrency = usedCurrency;
	}

	public double getAmountEntered() {
		return amountEntered;
	}

	public void setAmountEntered(double amountEntered) {
		this.amountEntered = amountEntered;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public UserAction(String usedCurrency, double amountEntered, double result, String date) {
		super();
		this.usedCurrency = usedCurrency;
		this.amountEntered = amountEntered;
		this.result = result;
		this.date = date;
	}

	public UserAction() {
		super();
	}

	@Override
	public String toString() {
		return "UserActionService [id=" + id + ", usedCurrency=" + usedCurrency + ", amountEntered=" + amountEntered
				+ ", result=" + result + ", date=" + date + "]";
	}

}
