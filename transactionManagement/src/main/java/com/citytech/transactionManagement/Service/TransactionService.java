package com.citytech.transactionManagement.Service;

import java.util.List;

import com.citytech.transactionManagement.model.TransactionDetails;

public interface TransactionService {
	
	List<TransactionDetails> getAllDetailsForToday(String merchantName);

}
