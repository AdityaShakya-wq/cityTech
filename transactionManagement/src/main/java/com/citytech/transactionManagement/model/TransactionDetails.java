package com.citytech.transactionManagement.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="transactiondetails")
public class TransactionDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long iud;
	
	@Column(name="merchant_Name")
	private String merchantName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="transaction_Date")
	private Date transactionDate;
	
	private String address;
	
	@Column(name="invoice_Number")
	private long invoiceNumber;

	public TransactionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIud() {
		return iud;
	}

	public void setIud(long iud) {
		this.iud = iud;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	
	
	
	
}
