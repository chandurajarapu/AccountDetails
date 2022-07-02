package com.app.account.service;

import com.app.accounts.entity.AccountAddressDetails;

public interface AccountAddressDetailsService {
	AccountAddressDetails getAccountAddressDetailsByProfileId(Integer profileId);
	AccountAddressDetails getAccountAddressDetailsByAddressId(Integer addressId);
	AccountAddressDetails saveAccountAddressDetails(AccountAddressDetails accountAddressDetails);
	AccountAddressDetails saveOrUpdateAccountAddressDetails(AccountAddressDetails accountAddressDetails);
}
