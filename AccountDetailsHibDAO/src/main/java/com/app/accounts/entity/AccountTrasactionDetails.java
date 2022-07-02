package com.app.accounts.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "tbl_account_tran_details")
public class AccountTrasactionDetails implements Serializable {
	@Id
	@Column(name = "transaction_id")
	@GenericGenerator(name = "autoInc", strategy = "increment")
	@GeneratedValue(generator = "autoInc")
	private Integer transactionId;
	
	@Column(name = "account_id")
	private Integer accountId;
	
	@Column(name = "transaction_type")
	private String transactionType;
	
	@Column(name = "tranasaction_amount")
	private Double transactionAmount;
	
	@Column(name = "transacation_from")
	private String transactionFrom;
	
	@Column(name = "transacation_to")
	private String transactionTo;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "updated_date")
	private Date updatedDate;
	
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionFrom() {
		return transactionFrom;
	}
	public void setTransactionFrom(String transactionFrom) {
		this.transactionFrom = transactionFrom;
	}
	public String getTransactionTo() {
		return transactionTo;
	}
	public void setTransactionTo(String transactionTo) {
		this.transactionTo = transactionTo;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
