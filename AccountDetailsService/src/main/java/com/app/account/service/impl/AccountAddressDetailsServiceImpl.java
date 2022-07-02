package com.app.account.service.impl;

import org.springframework.stereotype.Service;

import com.app.account.service.AccountAddressDetailsService;
import com.app.accounts.DAO.AccountAddressDetailsDAO;
import com.app.accounts.DAO.impl.AccountAddressDetailsDAOImpl;
import com.app.accounts.entity.AccountAddressDetails;
@Service
public class AccountAddressDetailsServiceImpl implements AccountAddressDetailsService {
	
	AccountAddressDetailsDAO accountAddressDetailsDAo=new AccountAddressDetailsDAOImpl();

	public AccountAddressDetails getAccountAddressDetailsByProfileId(Integer profileId) {
		return accountAddressDetailsDAo.getAccountAddressDetailsByProfileId(profileId);
	}

	public AccountAddressDetails getAccountAddressDetailsByAddressId(Integer addressId) {
		return accountAddressDetailsDAo.getAccountAddressDetailsByAddressId(addressId);
	}

	public AccountAddressDetails saveAccountAddressDetails(AccountAddressDetails accountAddressDetails) {
		return accountAddressDetailsDAo.saveAccountAddressDetails(accountAddressDetails);
	}

	public AccountAddressDetails saveOrUpdateAccountAddressDetails(AccountAddressDetails accountAddressDetails) {
		return accountAddressDetailsDAo.saveOrUpdateAccountAddressDetails(accountAddressDetails);
	}

}
