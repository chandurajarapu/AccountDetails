package com.app.accounts.test;

import java.sql.Date;
import java.util.List;

import com.app.accounts.DAO.AccountTrasactionDetailsDAO;
import com.app.accounts.DAO.impl.AccountTrasactionDetailsDAOImpl;
import com.app.accounts.entity.AccountTrasactionDetails;

public class AccountTransactionDetailsTest {

	public static void main(String[] args) {
		AccountTrasactionDetailsDAO accountTransactionDetailsDAO = new AccountTrasactionDetailsDAOImpl();
		AccountTrasactionDetails accountTransactionDetails=new AccountTrasactionDetails();
		accountTransactionDetails.setTransactionId(1);
		accountTransactionDetails.setAccountId(1);
		accountTransactionDetails.setTransactionType("saving");
		accountTransactionDetails.setTransactionFrom("icici");
		accountTransactionDetails.setTransactionTo("sbi");
		accountTransactionDetails.setCreatedDate(new Date(System.currentTimeMillis()));
		accountTransactionDetails.setUpdatedDate(new Date(System.currentTimeMillis()));
		accountTransactionDetailsDAO.saveAccountTrasactionDetails(accountTransactionDetails);
		
		List<AccountTrasactionDetails> accountTransactionDetails1 = accountTransactionDetailsDAO.getAllAccountTrasactionDetailsByAccountId(1);
		for (AccountTrasactionDetails accountTransactionDetails2 : accountTransactionDetails1) {
			System.out.println("AccountId:"+accountTransactionDetails2.getAccountId());
			System.out.println("TransactionId:"+accountTransactionDetails2.getTransactionId());

			System.out.println("TransactionType:"+accountTransactionDetails2.getTransactionType());
			System.out.println("TransactionFrom:"+accountTransactionDetails2.getTransactionFrom());
			System.out.println("TransactionTo:"+accountTransactionDetails2.getTransactionTo());
			System.out.println("CreatedDate:"+accountTransactionDetails2.getCreatedDate());
			System.out.println("UpdatedDate:"+accountTransactionDetails2.getUpdatedDate());
			List<AccountTrasactionDetails> AccountTransactionDetails = accountTransactionDetailsDAO.getAllAccountTrasactionDetailsByAccountId(2);
			System.out.println("TransactionType"+accountTransactionDetails.getTransactionType());
		}
	}

}

