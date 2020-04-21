package vcs.hotelproject.model;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.*;

import com.sun.istack.NotNull;


@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingID;
	@ManyToOne(targetEntity = Room.class,cascade = { CascadeType.MERGE } )
	@JoinColumn(name = "roomID")
	private Room roomID;
	@ManyToOne(targetEntity = Client.class,cascade = { CascadeType.MERGE })
	@JoinColumn(name = "clientID")
	private Client clientID;
	@NonNull
	private double totalPrice;
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private String inDate;
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private String outDate;
	@NotNull
	private String payType;
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private String payDate;
	@NotNull
	private boolean isPayed;
	@NotNull
	private String status = "Confirmed";
	
	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	public Room getRoomID() {
		return roomID;
	}
	public void setRoomID(Room roomID) {
		this.roomID = roomID;
	}
	public Client getClient() {
		return clientID;
	}
	public void setClient(Client clientID) {
		this.clientID = clientID;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public boolean isPayed() {
		return isPayed;
	}
	public void setPayed(boolean isPayed) {
		this.isPayed = isPayed;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	
	public Booking(Room roomID, Client clientID, double totalPrice, String inDate, String outDate, String payType,
			String payDate) {
		super();
		this.roomID = roomID;
		this.clientID = clientID;
		this.totalPrice = totalPrice;
		this.inDate = inDate;
		this.outDate = outDate;
		this.payType = payType;
		this.payDate = payDate;
	}
	
	public Booking(Room roomID, Client clientID, double totalPrice, String inDate, String outDate, String payType,
			String payDate, boolean isPayed, String status) {
		super();
		this.roomID = roomID;
		this.clientID = clientID;
		this.totalPrice = totalPrice;
		this.inDate = inDate;
		this.outDate = outDate;
		this.payType = payType;
		this.payDate = payDate;
		this.isPayed = isPayed;
		this.status = status;
	}
	
	
	
	
}
