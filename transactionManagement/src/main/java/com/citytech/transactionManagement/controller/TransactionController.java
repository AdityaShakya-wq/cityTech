package com.citytech.transactionManagement.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citytech.transactionManagement.Repo.TransacitonRepository;
import com.citytech.transactionManagement.Service.TransactionService;
import com.citytech.transactionManagement.model.TransactionDetails;

@Controller
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	TransacitonRepository transacitonRepository;
	
	@RequestMapping(value="/getDetailsByDay/{merchantName}",method=RequestMethod.GET)
	@ResponseBody
	public List<TransactionDetails> getDetailsForTheDay(@PathVariable String merchantName)
	{
		List<TransactionDetails> tList = transacitonRepository.findAll(); //getting all records
		
		
		//filtering for all the transactions of a specific merchant
		List<TransactionDetails> specificPersonList =tList.stream().filter(s-> s.getMerchantName().equals(merchantName)).collect(Collectors.toList());
		
		java.sql.Date d = new java.sql.Date(System.currentTimeMillis());
		
		//Getting all the transactions a specific merchant performed today
		List<TransactionDetails> result = specificPersonList.stream().filter(t-> t.getTransactionDate().toString().equals(d.toString())).collect(Collectors.toList());
		return result;
		
	}
	
	@GetMapping(value="/getAllTransactions")
	@ResponseBody
	public List<TransactionDetails> getAllTransactions()
	{
		return transacitonRepository.findAll();
	}
	
	@GetMapping(value="/getAllTransactionsForToday")
	@ResponseBody
	public List<TransactionDetails> getAllTransactionsForToday()
	{
		List<TransactionDetails> resultList = transacitonRepository.findAll();
		java.sql.Date d = new java.sql.Date(System.currentTimeMillis());
		
		return resultList.stream().filter(t-> t.getTransactionDate().toString().equals(d.toString())).collect(Collectors.toList());
	}
	
	@GetMapping(value="/getAllTransactionOfThisMonth")
	@ResponseBody
	public List<TransactionDetails> getAllTransactionOfThisMonth()
	{
		List<TransactionDetails> initialList = transacitonRepository.findAll();
		List<TransactionDetails> resultList = new ArrayList<>();
		
		
		
		java.sql.Date d = new java.sql.Date(System.currentTimeMillis());
		
		LocalDate d1 = d.toLocalDate();
		initialList.forEach(s->{
			LocalDate temp = s.getTransactionDate().toLocalDate();
			if(temp.getMonthValue() == d1.getMonthValue())
				resultList.add(s);
		});
		
		return resultList;
		
		
	}
	

}
