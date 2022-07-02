package com.app.account.service;

import java.util.List;

import com.app.accounts.entity.AccountTrasactionDetails;

public interface AccountTrasactionDetailsService {
	List<AccountTrasactionDetails> getAllAccountTrasactionDetailsByAccountId(Integer accountId);
    AccountTrasactionDetails getAccountTrasactionDetailsByTransactionId(Integer transactionId);
	AccountTrasactionDetails saveAccountTrasactionDetails(AccountTrasactionDetails accountTrasactionDetails);
	AccountTrasactionDetails saveOrUpdateAccountTrasactionDetails(AccountTrasactionDetails accountTrasactionDetails);
}
