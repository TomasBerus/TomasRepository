package vcs.hotelproject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long clientID;
	@Column(unique = true)
	@NotNull
	private String email;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String password;
	@Column(unique = true)
	@NotNull
	private String phoneNumber;

	@OneToMany(targetEntity = Booking.class, mappedBy = "clientID", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Booking> bookings;

	public long getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Client() {
		super();
	}

	public Client(String email, String firstName, String lastName, String password, String phoneNumber) {
		super();

		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "ClientId: " + clientID + " firstName: " + firstName + " lastName: " + lastName + " email: " + email
				+ " password: " + password + " phoneNumber: " + phoneNumber;
	}

}
