package vcs.hotelproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vcs.hotelproject.model.Building;
import vcs.hotelproject.model.Room;
import vcs.hotelproject.repository.BuildingRepository;
import vcs.hotelproject.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	RoomRepository roomRepository;
	@Autowired
	BuildingRepository buildingRepository;

	public Iterable<Room> getAllRooms() {
		Iterable<Room> iterator = roomRepository.findAll();

		return iterator;

	}

	public void addNewRoom(Building b, String adresss, String type, String description) {
		roomRepository.save(new Room(b, adresss, type, description));
	}

	public void printAllRooms() {
		System.out.println("Printing all rooms: ");
		ArrayList<Room> iterator = (ArrayList<Room>) getAllRooms();

		System.out.println("All clients: ");
		iterator.forEach(roomID -> System.out.println(roomID));
	}

	public Room findRoomById(long roomID2) {
		Room RoomID = roomRepository.getRoomByID(roomID2);
		return RoomID;
	}

	public List<Room> findRoomByType(String type) {
		List<Room> room = roomRepository.getRoomByType(type);
		return room;
	}

	public String getRoomsAddress(int roomID) {
		Room room = roomRepository.getRoomByID(roomID);
		Building building = room.getBuilding();
		String address = building.getAddress();
		return address;
	}
	public void updateRoom(String roomNumber, String roomType, String description, long roomID) {
		roomRepository.updateRoom(roomNumber, roomType, description, roomID);
		
	}
	
	public void deleteRoom(long roomID) {
		roomRepository.deleteRoom(roomID);
		
	}
	public Room checkNumber(String roomNumber, long buildingID) {
		try {
			Room room = roomRepository.checkNumber(roomNumber, buildingID);
			return room;
		} catch (Exception e) {
			return null;
		}
	}
	
}
