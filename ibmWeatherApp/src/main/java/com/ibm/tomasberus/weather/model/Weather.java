package com.ibm.tomasberus.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {

	private float lat;

	private float lon;

	private Temp temp;
	@JsonProperty("observation_time")
	private Observation_Time observation_Time;

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	

	

	public Temp getTemp() {
		return temp;
	}

	public void setTemp(Temp temp) {
		this.temp = temp;
	}

	public Observation_Time getObservation_Time() {
		return observation_Time;
	}

	public void setObservation_Time(Observation_Time observation_Time) {
		this.observation_Time = observation_Time;
	}

	public Weather(int value, String units , Temp temp, Observation_Time observation_Time2) {
		super();
		
		
		this.temp = temp;
		observation_Time = observation_Time2;
	}

	public Weather() {
		super();
	}

	@Override
	public String toString() {
		return "Weather [lat=" + lat + ", lon=" + lon +  ", temp=" + temp + ", observation_Time=" + observation_Time + "]";
	}
	
	
	
	

}
