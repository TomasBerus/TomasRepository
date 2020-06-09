package com.ibm.tomasberus.weather.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ibm.tomasberus.weather.model.PresentationData;

public interface PresentationDataRepository extends JpaRepository<PresentationData, Long> {

	
	@Query(value = "SELECT * from presentationdata WHERE observation_time LIKE '%:50:%' ORDER BY observation_time DESC;",nativeQuery = true)
	public List<PresentationData> getData();
	
	@Query(value= "SELECT * from presentationdata",  nativeQuery = true)
	public List<PresentationData> checkData();
	
}
