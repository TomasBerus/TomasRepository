package com.ibm.tomasberus.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Observation_Time {
@JsonProperty("value")
private String observation_time;

public String getObservation_time() {
	
	return observation_time;
}

public void setObservation_time(String observation_time) {
	this.observation_time = observation_time;
}

public Observation_Time(String observation_time) {
	super();
	this.observation_time = observation_time;
}

public Observation_Time() {
	super();
}

@Override
public String toString() {
	return "Observation_Time [observation_time=" + observation_time + "]";
}


}


