package com.ibm.tomasberus.ibmCurrencyConverter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibm.tomasberus.ibmCurrencyConverter.model.ConvertionCurrency;

@Repository
public interface CurrencyRepository extends JpaRepository<ConvertionCurrency, Long>{

	@Query(value= "SELECT * from convertioncurrency LIMIT 5",  nativeQuery = true)
	public List<ConvertionCurrency> checkData();
	@Query(value= "select * from convertioncurrency u where u.currencyName = ?1",  nativeQuery = true)
	public ConvertionCurrency findCurrency(String currencyName);

}

