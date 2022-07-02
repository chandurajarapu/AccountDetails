package com.app.account.service.impl;

import org.springframework.stereotype.Service;

import com.app.account.service.AccountProfileService;
import com.app.accounts.DAO.AccountProfileDAO;
import com.app.accounts.DAO.impl.AccountProfileDAOImpl;
import com.app.accounts.entity.AccountProfile;
@Service
public class AccountProfileServiceImpl implements AccountProfileService {
	
	AccountProfileDAO accountProfileDAO=new AccountProfileDAOImpl();
	
	public AccountProfile getAccountProfileByAccountId(Integer accountId) {
		return accountProfileDAO.getAccountProfileByAccountId(accountId);
	}

	public AccountProfile getAccountProfileByProfileId(Integer profileId) {
		return accountProfileDAO.getAccountProfileByProfileId(profileId);
	}

	public AccountProfile saveAccountProfile(AccountProfile accountProfile) {
		return accountProfileDAO.saveAccountProfile(accountProfile);
	}

	public AccountProfile saveOrUpdateAccountProfile(AccountProfile accountProfile) {
		return accountProfileDAO.saveOrUpdateAccountProfile(accountProfile);
	}

}
