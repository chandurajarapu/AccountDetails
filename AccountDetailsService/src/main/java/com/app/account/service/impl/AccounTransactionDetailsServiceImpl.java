package com.app.account.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.account.service.AccountTrasactionDetailsService;
import com.app.accounts.DAO.AccountTrasactionDetailsDAO;
import com.app.accounts.DAO.impl.AccountTrasactionDetailsDAOImpl;
import com.app.accounts.entity.AccountTrasactionDetails;
@Service
public class AccounTransactionDetailsServiceImpl implements AccountTrasactionDetailsService {
	
AccountTrasactionDetailsDAO accountTransactionDetailsDAO=new AccountTrasactionDetailsDAOImpl();

	public List<AccountTrasactionDetails> getAllAccountTrasactionDetailsByAccountId(Integer accountId) {
		return accountTransactionDetailsDAO.getAllAccountTrasactionDetailsByAccountId(accountId);
	}

	public AccountTrasactionDetails getAccountTrasactionDetailsByTransactionId(Integer transactionId) {
		return accountTransactionDetailsDAO.getAccountTrasactionDetailsByTransactionId(transactionId);
	}

	public AccountTrasactionDetails saveAccountTrasactionDetails(AccountTrasactionDetails accountTrasactionDetails) {
		return accountTransactionDetailsDAO.saveAccountTrasactionDetails(accountTrasactionDetails);
	}

	public AccountTrasactionDetails saveOrUpdateAccountTrasactionDetails(
			AccountTrasactionDetails accountTrasactionDetails) {
		return accountTransactionDetailsDAO.saveOrUpdateAccountTrasactionDetails(accountTrasactionDetails);
	}

}
