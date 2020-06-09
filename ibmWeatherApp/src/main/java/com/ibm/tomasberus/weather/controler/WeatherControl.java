package com.ibm.tomasberus.weather.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ibm.tomasberus.weather.model.PresentationData;
import com.ibm.tomasberus.weather.service.WeatherService;

@Controller
public class WeatherControl {

	@Autowired
	WeatherService weatherService;

	@RequestMapping(method = RequestMethod.GET, value = "/weather")
	public String weather(Model model) {
		List<PresentationData> weatherCheck= weatherService.checkForHistoricData();
		try {
			
			if (weatherCheck.size() < 1000) {
				weatherService.getLast30DaysTemperature();
			}
			
		} catch (Exception e) {
			
		}
		
		List<PresentationData> weather = weatherService.getWeatherData();

		model.addAttribute("weathers", weather);
		return "weather";

	}

}
