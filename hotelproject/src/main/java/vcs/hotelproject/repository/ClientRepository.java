package vcs.hotelproject.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vcs.hotelproject.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query("Select e FROM Client e WHERE e.clientID = :clientID")
	public Client getClientByID(@Param("clientID") long clientID);

	@Query("Select e FROM Client e WHERE lower(e.email) = lower(:email)")
	public Client getClientByEmail(@Param("email") String email);
	
	@Query("Select e FROM Client e WHERE e.phoneNumber = :phoneNumber")
	public Client getClientByPhone(@Param("phoneNumber") String phoneNumber);

	@Query("Select e FROM Client e WHERE lower(e.email) = lower(:email) AND lower(e.password) = lower(:password)")
	public Client getClientByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Client c SET c.email = :email, c.firstName = :firstName, c.lastName = :lastName, c.phoneNumber = :phoneNumber WHERE c.clientID = :clientID")
	public Integer updateClient(@Param("email") String email, @Param("firstName") String firstName,
			@Param("lastName") String lastName, @Param("phoneNumber") String phoneNumber,
			@Param("clientID") long clientID);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Client c SET c.password =:password WHERE c.clientID = :clientID")
	public Integer updateClientPassword(@Param("password") String password, @Param("clientID") long clientID);
}
