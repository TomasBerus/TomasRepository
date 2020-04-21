package vcs.hotelproject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import vcs.hotelproject.model.Client;
import vcs.hotelproject.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	public ArrayList<Client> getAllClients() {
		Iterable<Client> iterator = clientRepository.findAll();
		ArrayList<Client> client = new ArrayList();
		client = (ArrayList<Client>) iterator;
		return client;

	}

	public void printAllClients() {
		System.out.println("Printing all clients: ");
		ArrayList<Client> iterator = (ArrayList<Client>) getAllClients();

		System.out.println("All clients: ");
		iterator.forEach(clientID -> System.out.println(clientID));
	}

	public void saveNewClient(String email, String fistName, String LastName, String password, String number) {

		clientRepository.save(new Client(email, fistName, LastName, password, number));
	}

	public Client findClientById(long clientID) {
		Client clientByID = clientRepository.getClientByID(clientID);
		return clientByID;
	}

	public Client findClientByEmail(String email) {
		Client clientByEmail = clientRepository.getClientByEmail(email);
		return clientByEmail;
	}

	public Client findClientByEmailAndPassword(String email, String password) {
		try {
			Client ClientByEmailAndPassword = clientRepository.getClientByEmailAndPassword(email, password);
			return ClientByEmailAndPassword;
		} catch (Exception e) {
			return null;
		}

	}

	public void updateClient(String email, String firstName, String lastName, String phoneNumber, long clientID) {
		clientRepository.updateClient(email, firstName, lastName, phoneNumber, clientID);
	}

	public void updateClientPassword(String oldPassword, String newPassword, long clientID) {
		clientRepository.updateClientPassword(newPassword, clientID);
	}

	public Client checkClientEmailAvailabilaty(String email) {
		try {
			Client clientByEmail = clientRepository.getClientByEmail(email);
			return clientByEmail;
		} catch (Exception e) {
			return null;
		}

	}

	public Client checkClientPhoneAvailabilaty(String phoneNumber) {
		try {
			Client clientByPhone = clientRepository.getClientByPhone(phoneNumber);
			return clientByPhone;
		} catch (Exception e) {
			return null;
		}

	}

}
