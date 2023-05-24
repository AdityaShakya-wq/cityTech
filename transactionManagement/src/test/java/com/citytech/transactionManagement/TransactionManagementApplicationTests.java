package com.citytech.transactionManagement;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.citytech.transactionManagement.controller.TransactionController;

@SpringBootTest
class TransactionManagementApplicationTests {
	
	@Autowired
	TransactionController transactionController;

	@Test
	void contextLoads() throws Exception{
		
		assertThat(transactionController).isNotNull();
	}

}
