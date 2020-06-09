package com.ibm.tomasberus.weather.model;


public class Temp {
	

	private int value;
	
	private String units;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public Temp(int value, String units) {
		super();
		this.value = value;
		this.units = units;
	}

	public Temp() {
		super();
	}

	@Override
	public String toString() {
		return "Temp [value=" + value + ", units=" + units + "]";
	}

	
	
	
	
	 
}
