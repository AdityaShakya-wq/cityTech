package com.citytech.transactionManagement.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citytech.transactionManagement.Repo.TransacitonRepository;
import com.citytech.transactionManagement.Service.TransactionService;
import com.citytech.transactionManagement.model.TransactionDetails;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Override
	public List<TransactionDetails> getAllDetailsForToday(String merchantName) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
