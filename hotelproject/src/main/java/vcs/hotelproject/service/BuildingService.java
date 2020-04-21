package vcs.hotelproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vcs.hotelproject.model.Building;
import vcs.hotelproject.repository.BuildingRepository;

@Service
public class BuildingService {

	@Autowired
	BuildingRepository buildingRepository;

	public Iterable<Building> getAllBuildings() {
		Iterable<Building> iterator = buildingRepository.findAll();

		return iterator;

	}

	public void saveNewBuilding(String address, String city, String type) {
		buildingRepository.save(new Building(address, city, type));
	}

	public void printAllBuildings() {
		System.out.println("Printing all clients: ");
		ArrayList<Building> iterator = (ArrayList<Building>) getAllBuildings();

		System.out.println("All clients: ");
		iterator.forEach(buildingID -> System.out.println(buildingID));
	}

	public void printAllAdresesLike(String address) {

		List<Building> building = buildingRepository.getBuildingByAddressLike(address);
		building.forEach(add -> System.out.println(add.getAddress()));
	}

	public List<Building> getAllAdresesLike(String address) {
		List<Building> building = buildingRepository.getBuildingByAddressLike(address);
		return building;
	}

	public List<Building> getAllCities(String city) {
		List<Building> building = buildingRepository.getBuildingByCity(city);
		return building;
	}

	public void updateBuilding(String address, String city, String buildingType, long buildingID) {
		buildingRepository.updateBuilding(address, city, buildingType, buildingID);
	}
	public Building getBuilding(long buildingID) {
		Building building = buildingRepository.getBuildingByID(buildingID);
		return building;
		
	}
	
	public void deleteBuilding(long buildingID) {
		buildingRepository.deleteBuilding(buildingID);
	}
	public Building checkAddress(String address, String city) {
		try {
			Building Building = buildingRepository.getBuildingByAddressAndCity(address, city);
			
			return Building;
		} catch (Exception e) {
			return null;
		}
		
		
	}
}
