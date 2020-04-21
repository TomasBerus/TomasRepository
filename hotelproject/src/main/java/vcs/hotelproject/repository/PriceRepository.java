package vcs.hotelproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vcs.hotelproject.model.Building;
import vcs.hotelproject.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{

	@Query("Select e FROM Price e WHERE e.priceID = :priceID")
	public Price getPriceByID(@Param("priceID")long priceID);
	
	@Query("Select e FROM Price e WHERE buildingID = :buildingID")
	public List<Price> getPriceByBuilding(@Param("buildingID") long buildingID);
	
	@Query("Select e FROM Price e WHERE roomID = :roomID")
	public List<Price> getPriceByRoom(@Param("roomID") long roomID);
	
	@Query("Select e FROM Price e WHERE roomID = :roomID")
	public Price getPriceByRoomSingle(@Param("roomID") long roomID);
	
	@Query("Select e FROM Price e WHERE buildingID = :buildingID")
	public Price getPriceByBuildingSingle(@Param("buildingID") long buildingID);
	
	 @Transactional
		@Modifying(clearAutomatically = true)
		@Query("UPDATE Price c SET c.basePrice = :basePrice, c.priceAddon = :priceAddon, c.priceType = :priceType WHERE c.priceID = :priceID")
		public Integer updatePrice(@Param("basePrice") double basePrice, @Param("priceAddon") double priceAddon,
				@Param("priceType") String priceType, @Param("priceID") long priceID);
	 
	 	@Transactional
		@Modifying
		@Query("Delete from Price b WHERE b.priceID=:priceID")
		public Integer deletePrice(@Param("priceID") long priceID);

}
