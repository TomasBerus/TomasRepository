package vcs.hotelproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vcs.hotelproject.model.Price;
import vcs.hotelproject.repository.PriceRepository;

@Service
public class PriceService {

	@Autowired
	PriceRepository priceRepository;


	public Price findPriceByID(int id) {

		Price price = priceRepository.getPriceByID(id);
		return price;

	}

	public List<Price> findAllBuildingByID(long buildingID) {
		List<Price> price = priceRepository.getPriceByBuilding(buildingID);
		return price;
	}
	public List<Price> findAllRoomByID(long roomID) {
		List<Price> price = priceRepository.getPriceByRoom(roomID);
		return price;
	}

	public void savNewPrice(long roomID, long buildingID, String priceType, double basePrice, double priceAddon) {
		priceRepository.save(new Price(roomID, buildingID, priceType, basePrice, priceAddon));
		
	}

	public void UpdateBuildingPrice(double basePrice, double priceAddon, String priceType, long priceID) {
		priceRepository.updatePrice(basePrice, priceAddon, priceType, priceID);
		
	}
	public void buildingPriceDelete(long priceID) {
		priceRepository.deletePrice(priceID);
	}
	public Price findSingleBuildingByID(long buildingID) {
		Price price = priceRepository.getPriceByBuildingSingle(buildingID);
		return price;
	}
	public Price findSingleRoomByID(long roomID) {
		Price price = priceRepository.getPriceByRoomSingle(roomID);
		return price;
	}
}
