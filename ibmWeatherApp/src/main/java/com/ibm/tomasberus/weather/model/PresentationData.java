package com.ibm.tomasberus.weather.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PresentationData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int value;
	
	private String observation_time;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getObservation_time() {
		return observation_time;
	}

	public void setObservation_time(String observation_time) {
		this.observation_time = observation_time;
	}

	public PresentationData(int value, String ot) {
		super();
		this.value = value;
		this.observation_time = ot;
	}

	public PresentationData() {
		super();
	}

	

	@Override
	public java.lang.String toString() {
		return "PresentationData [value=" + value + ", observation_time=" + observation_time + "]";
	}
	
	
}
