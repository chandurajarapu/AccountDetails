package com.app.accounts.test;

import java.util.Date;

import com.app.accounts.DAO.AccountProfileDAO;
import com.app.accounts.DAO.impl.AccountProfileDAOImpl;
import com.app.accounts.entity.AccountProfile;
import com.app.accounts.entity.LoginDetails;

public class AccountProfileTest {

	public static void main(String[] args) {
		AccountProfileDAO accountProfileDAO = new AccountProfileDAOImpl();
			AccountProfile accountProfile = new AccountProfile();
			accountProfile.setProfileId(3);
			accountProfile.setFirstName("CHandu");
			accountProfile.setLastName("rajarapu");
			accountProfile.setCreatedDate(new Date());
			accountProfile.setUpdatedDate(new Date());
			/*AccountProfileDAO.saveAccountProfile(accountProfile );
			AccountProfile accountProfile = AccountProfileDAO.getAccountProfileByAccountId(3);
			System.out.println("panNumber"+loginDetails.getPanNumber());*/
		}

}
