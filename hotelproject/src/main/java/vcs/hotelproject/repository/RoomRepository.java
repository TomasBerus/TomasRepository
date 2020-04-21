package vcs.hotelproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vcs.hotelproject.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	public List<Room> findByroomNumber(String number);

	@Query("Select e FROM Room e WHERE e.roomID = :roomID")
	public Room getRoomByID(@Param("roomID") long roomID);

	@Query("Select e From Room e WHERE e.roomType = :roomType")
	public List<Room> getRoomByType(@Param("roomType") String roomType);

	@Query("Select e From Room e WHERE e.buildingID = :buildingID")
	public List<Room> getRoomByBuilding(@Param("buildingID") long buildingID);
	
	@Query("Select e FROM Room e WHERE e.roomNumber = :roomNumber AND e.buildingID = :buildingID")
	public Room checkNumber(@Param("roomNumber") String roomNumber, @Param("buildingID") long buildingID);
	
	@Transactional
	@Modifying
	@Query("Delete from Room b WHERE b.roomID=:roomID")
	public Integer deleteRoom(@Param("roomID") long roomID);
	
    @Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Room c SET c.roomNumber = :roomNumber, c.roomType = :roomType, c.description = :description WHERE c.roomID = :roomID")
	public Integer updateRoom(@Param("roomNumber") String roomNumber, @Param("roomType") String roomType,
			@Param("description") String description, @Param("roomID") long roomID);

}
