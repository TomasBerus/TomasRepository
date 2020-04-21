package vcs.hotelproject.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(name = "room")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roomID;
	@ManyToOne(targetEntity = Building.class, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "buildingID")
	private Building buildingID;
	@NotEmpty
	private String roomNumber;
	@NotEmpty
	private String roomType;
	@NotEmpty
	private String description;
	@OneToMany(targetEntity = Booking.class, mappedBy = "roomID", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Booking> bookings;
	
	public long getRoomID() {
		return roomID;
	}

	public void setRoomID(long roomID) {
		this.roomID = roomID;
	}

	public Building getBuilding() {
		return buildingID;
	}

	public void setBuilding(Building buildingID) {
		this.buildingID = buildingID;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Room() {
		super();
	}

	public Room(Building building, String roomNumber, String roomType, String description) {
		super();
		this.buildingID = building;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Room [roomID=" + roomID + ", building=" + buildingID + ", roomNumber=" + roomNumber + ", roomType="
				+ roomType + description +"]";
	}

}
