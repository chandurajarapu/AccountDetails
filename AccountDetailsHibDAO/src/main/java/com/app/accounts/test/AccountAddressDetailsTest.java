package com.app.accounts.test;

import java.util.Date;

import com.app.accounts.DAO.AccountAddressDetailsDAO;
import com.app.accounts.DAO.impl.AccountAddressDetailsDAOImpl;
import com.app.accounts.entity.AccountAddressDetails;

public class AccountAddressDetailsTest {
	public static void main(String[] args) {
		AccountAddressDetailsDAO accountAddressDetailsDAO = new AccountAddressDetailsDAOImpl();
		AccountAddressDetails accountAddressDetails=new AccountAddressDetails();
		accountAddressDetails.setProfileId(2);
		accountAddressDetails.setCommunicationAddress("hyderabad");
		accountAddressDetails.setPermanentAddress("thakkellapadu");
		accountAddressDetails.setCreatedDate(new Date());
		accountAddressDetails.setUpdatedDate(new Date());
		AccountAddressDetails accountAddressDetails1 = accountAddressDetailsDAO.saveAccountAddressDetails(accountAddressDetails);
		
		/*AccountAddressDetails accountAddressDetails = accountAddressDetailsDAO.getAccountAddressDetailsByProfileId(1);
		System.out.println("communicationAddress"+accountAddressDetails.getCommunicationAddress());*/
}
}