package com.app.account.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.account.service.AccountDetailsService;
import com.app.accounts.DAO.AccountDetailsDAO;
import com.app.accounts.DAO.impl.AccountDetailsDAOImpl;
import com.app.accounts.entity.AccountDetails;
@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {
	
	AccountDetailsDAO accountDetailsDAO=new AccountDetailsDAOImpl();

	public List<AccountDetails> getAllAccountDetailsByAadharNumber(String aadharNumber) {
		return accountDetailsDAO.getAllAccountDetailsByAadharNumber(aadharNumber);
	}

	public AccountDetails getAccountDetailsByAccountId(Integer accountId) {
		return accountDetailsDAO.getAccountDetailsByAccountId(accountId);
	}

	public AccountDetails saveAccountDetails(AccountDetails accountDetails) {
		return accountDetailsDAO.saveAccountDetails(accountDetails);
	}

	public AccountDetails saveOrUpdateAccountDetails(AccountDetails accountDetails) {
		return accountDetailsDAO.saveOrUpdateAccountDetails(accountDetails);
	}

}
