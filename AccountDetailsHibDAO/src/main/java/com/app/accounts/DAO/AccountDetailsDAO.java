package com.app.accounts.DAO;

import java.util.List;

import com.app.accounts.entity.AccountDetails;

public interface AccountDetailsDAO {
	List<AccountDetails> getAllAccountDetailsByAadharNumber(String aadharNumber);
	AccountDetails getAccountDetailsByAccountId(Integer accountId);
	AccountDetails saveAccountDetails( AccountDetails accountDetails);
	AccountDetails saveOrUpdateAccountDetails(AccountDetails accountDetails);
}
