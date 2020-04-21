package vcs.hotelproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.sun.istack.NotNull;

@Entity
@Table(name = "price")
public class Price {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long priceID;
	@Nullable
	private long roomID;
	@Nullable
	private long buildingID;
	@NotNull
	String priceType;
	@NotNull
	private double basePrice;
	@NotNull
	private double priceAddon;
	public long getPriceID() {
		return priceID;
	}
	public void setPriceID(int priceID) {
		this.priceID = priceID;
	}
	public long getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public long getBuildingID() {
		return buildingID;
	}
	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}
	public String getPriceType() {
		return priceType;
	}
	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public double getPriceAddon() {
		return priceAddon;
	}
	public void setPriceAddon(double priceAddon) {
		this.priceAddon = priceAddon;
	}
	public Price(long roomID, long buildingID, String priceType, double basePrice, double priceAddon) {
		super();
		this.roomID = roomID;
		this.buildingID = buildingID;
		this.priceType = priceType;
		this.basePrice = basePrice;
		this.priceAddon = priceAddon;
	}
	public Price() {
		super();
	}
	@Override
	public String toString() {
		return "Price [priceID=" + priceID + ", roomID=" + roomID + ", buildingID=" + buildingID + ", priceType="
				+ priceType + ", basePrice=" + basePrice + ", priceAddon=" + priceAddon + "]";
	}
	
}
