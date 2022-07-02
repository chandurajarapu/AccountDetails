package com.app.accounts.test;

import java.sql.Date;
import java.util.List;

import com.app.accounts.DAO.AccountDetailsDAO;
import com.app.accounts.DAO.impl.AccountDetailsDAOImpl;
import com.app.accounts.entity.AccountDetails;

public class AccountDetailsTest {
	public static void main(String[] args) {
		AccountDetailsDAO accountDetailsDAO = new AccountDetailsDAOImpl();
		AccountDetails accountDetails=new AccountDetails();
		accountDetails.setAccountId(1);
		accountDetails.setAccountName("rajarapu shanthi");
		accountDetails.setAccountType("credit");
		accountDetails.setAadharNumber("4313151665163");
		accountDetails.setCreatedDate(new Date(System.currentTimeMillis()));
		accountDetails.setUpdatedDate(new Date(System.currentTimeMillis()));
		//accountDetailsDAO.saveAccountDetails(accountDetails);
		List<AccountDetails> accountDetails1 = accountDetailsDAO.getAllAccountDetailsByAadharNumber("4313151665163");
		for (AccountDetails accountDetails2 : accountDetails1) {
			System.out.println("AccountId:"+accountDetails2.getAccountId());
			System.out.println("AccountName:"+accountDetails2.getAccountName());
			System.out.println("AccountType:"+accountDetails2.getAccountType());
			System.out.println("AadharNumber:"+accountDetails2.getAadharNumber());
			System.out.println("CreatedDate:"+accountDetails2.getCreatedDate());
			System.out.println("UpdatedDate:"+accountDetails2.getUpdatedDate());
			
		}
		/*AccountDetails accountDetails = accountDetailsDAO.getAccountDetailsByAccountId(2);
		System.out.println("AccountType"+accountDetails.getAccountType());*/
		
	}

}
