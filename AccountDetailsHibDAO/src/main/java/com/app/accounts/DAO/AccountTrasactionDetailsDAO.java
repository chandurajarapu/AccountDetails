package com.app.accounts.DAO;

import java.util.List;

import com.app.accounts.entity.AccountTrasactionDetails;

public interface AccountTrasactionDetailsDAO {
	List<AccountTrasactionDetails> getAllAccountTrasactionDetailsByAccountId(Integer accountId);
    AccountTrasactionDetails getAccountTrasactionDetailsByTransactionId(Integer transactionId);
	AccountTrasactionDetails saveAccountTrasactionDetails(AccountTrasactionDetails accountTrasactionDetails);
	AccountTrasactionDetails saveOrUpdateAccountTrasactionDetails(AccountTrasactionDetails accountTrasactionDetails);
}
