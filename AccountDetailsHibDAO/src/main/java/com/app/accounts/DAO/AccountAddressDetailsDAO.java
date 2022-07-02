package com.app.accounts.DAO;

import com.app.accounts.entity.AccountAddressDetails;

public interface AccountAddressDetailsDAO {
	AccountAddressDetails getAccountAddressDetailsByProfileId(Integer profileId);
	AccountAddressDetails getAccountAddressDetailsByAddressId(Integer addressId);
	AccountAddressDetails saveAccountAddressDetails(AccountAddressDetails accountAddressDetails);
	AccountAddressDetails saveOrUpdateAccountAddressDetails(AccountAddressDetails accountAddressDetails);
}
