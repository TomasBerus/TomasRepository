package com.ibm.tomasberus.weather.service;

import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.tomasberus.weather.model.PresentationData;
import com.ibm.tomasberus.weather.model.Weather;

import com.ibm.tomasberus.weather.repository.PresentationDataRepository;

@Service
public class WeatherService {

	@Autowired
	PresentationDataRepository presentationDataRepository;

	@Scheduled(cron = "0 55 * * * *")
	public void getTemperature() {

		ObjectMapper objectMapper = new ObjectMapper();
		Weather weather = null;
		try {
			weather = objectMapper.readValue(new URL(
					"https://api.climacell.co/v3/weather/realtime?lat=54.687157&lon=25.279652&unit_system=si&fields=temp&apikey=QX2rRsJDxDQhhgTaR3g6QMZF2reuM7gs"),
					Weather.class);
			int temp = weather.getTemp().getValue();
			String ot = weather.getObservation_Time().getObservation_time();
			ot = ot.replace("T", " ");
			ot = ot.replace(".000Z", "");

			presentationDataRepository.save(new PresentationData(temp, ot));

		} catch (JsonParseException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	public void getLast30DaysTemperature() {
		int b = 1;
		ObjectMapper objectMapper = new ObjectMapper();
		List<Weather> weatherList = null;
		TypeReference<List<Weather>> typeReference = new TypeReference<List<Weather>>() {
		};
		LocalDate startDate = LocalDate.now().minusMonths(1);

		LocalDate endDate = LocalDate.now().plusDays(1);
		String endTime = "T00%3A00%3A00Z";

		List<LocalDate> date = getDatesBetweenDates(startDate, endDate);
		for (int i = 0; i < date.size(); i++, b++) {
			if (b == date.size()) {
				b = i;
				endTime = "now";
			}
			String URL = "https://api.climacell.co/v3/weather/historical/station?lat=54.687157&lon=25.279652&start_time="
					+ date.get(i) + "T00%3A00%3A00Z&end_time=" + date.get(b) + endTime
					+ "&fields%5B%5D=temp&apikey=QX2rRsJDxDQhhgTaR3g6QMZF2reuM7gs";
			try {
				weatherList = (objectMapper.readValue(new URL(URL), typeReference));
				for (int a = 0; a < weatherList.size(); a++) {
					Weather weather = weatherList.get(a);
					int temp = weather.getTemp().getValue();
					String ot = weather.getObservation_Time().getObservation_time();

					ot = ot.replace("T", " ");
					ot = ot.replace(".000Z", "");

					presentationDataRepository.save(new PresentationData(temp, ot));
				}
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void saveNewWeather(int temp, String ot) {

		presentationDataRepository.save(new PresentationData(temp, ot));
	}

	public List<PresentationData> checkForHistoricData() {
		List<PresentationData> weather = presentationDataRepository.checkData();
		return weather;

	}

	public List<LocalDate> getDatesBetweenDates(LocalDate startDate, LocalDate endDate) {

		return startDate.datesUntil(endDate).collect(Collectors.toList());
	}

	public List<PresentationData> getWeatherData() {
		List<PresentationData> weather = presentationDataRepository.getData();
		return weather;
	}

}
