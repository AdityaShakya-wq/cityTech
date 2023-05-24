package com.citytech.transactionManagement.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citytech.transactionManagement.model.TransactionDetails;

public interface TransacitonRepository extends JpaRepository<TransactionDetails, Long>{
	
	

}
