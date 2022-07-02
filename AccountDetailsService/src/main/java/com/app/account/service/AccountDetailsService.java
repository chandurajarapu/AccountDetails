package com.app.account.service;

import java.util.List;

import com.app.accounts.entity.AccountDetails;

public interface AccountDetailsService {

	List<AccountDetails> getAllAccountDetailsByAadharNumber(String aadharNumber);
	AccountDetails getAccountDetailsByAccountId(Integer accountId);
	AccountDetails saveAccountDetails( AccountDetails accountDetails);
	AccountDetails saveOrUpdateAccountDetails(AccountDetails accountDetails);
}
