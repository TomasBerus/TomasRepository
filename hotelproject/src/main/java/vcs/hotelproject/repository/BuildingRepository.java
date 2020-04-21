package vcs.hotelproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vcs.hotelproject.model.Building;


@Repository
public interface BuildingRepository extends JpaRepository<Building, Long>{


	@Query("Select e FROM Building e WHERE e.buildingID = :buildingID")
	public Building getBuildingByID(@Param("buildingID")Long buildingID);
	@Query("Select e FROM Building e WHERE e.address = :address AND e.city = :city")
	public Building getBuildingByAddressAndCity(@Param("address")String address, @Param("city") String city);
	
	@Query("Select e FROM Building e WHERE lower(e.address) LIKE lower(concat('%', :address, '%'))")
	public List<Building> getBuildingByAddressLike(@Param("address") String address);
	
	@Query("Select e FROM Building e WHERE lower(e.buildingType) = lower(:buildingType)")
	public List<Building> getBuildingByType(@Param("buildingType") String type);
	
	@Query("Select e FROM Building e WHERE lower(e.city) = lower(:city)")
	public List<Building> getBuildingByCity(@Param("city") String city);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Building c SET c.address = :buildingAddress, c.city = :buildingCity, c.buildingType = :buildingType WHERE c.buildingID = :buildingID")
	public Integer updateBuilding(@Param("buildingAddress") String buildingAddress, @Param("buildingCity") String buildingCity, @Param("buildingType") String buildingType,
			@Param("buildingID") long buildingID);
	
	@Transactional
	@Modifying
	@Query("Delete from Building b WHERE b.buildingID=:buildingID")
	public Integer deleteBuilding(@Param("buildingID") long buildingID);
}
