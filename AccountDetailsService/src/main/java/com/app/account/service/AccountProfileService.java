package com.app.account.service;

import com.app.accounts.entity.AccountProfile;

public interface AccountProfileService {
	AccountProfile getAccountProfileByAccountId(Integer accountId);

	AccountProfile getAccountProfileByProfileId(Integer profileId);

	AccountProfile saveAccountProfile(AccountProfile accountProfile);

	AccountProfile saveOrUpdateAccountProfile(AccountProfile accountProfile);
}
