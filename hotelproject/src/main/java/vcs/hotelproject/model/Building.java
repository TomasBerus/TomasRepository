package vcs.hotelproject.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(name = "building")
public class Building {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long buildingID;
	@Column(unique = true)
	@NotEmpty
	private String address;
	@NotEmpty
	private String city;
	@NotEmpty
	private String buildingType;

	@OneToMany(targetEntity = Room.class, mappedBy = "buildingID", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Room> rooms;

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public long getBuildingID() {
		return buildingID;
	}

	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public Building(String address, String city, String buildingType) {
		super();
		this.address = address;
		this.city = city;
		this.buildingType = buildingType;
	}

	public Building() {
		super();
	}

//bidirectional
	/*
	 * public void addRoom(Room tempRoom) { if (!rooms.contains(tempRoom)) {
	 * rooms.add(tempRoom); tempRoom.setBuilding(this); }
	 * 
	 * }
	 */
}
