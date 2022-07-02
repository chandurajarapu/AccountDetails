package com.app.accounts.DAO;

import com.app.accounts.entity.AccountProfile;

public interface AccountProfileDAO {
	AccountProfile getAccountProfileByAccountId(Integer accountId);

	AccountProfile getAccountProfileByProfileId(Integer profileId);

	AccountProfile saveAccountProfile(AccountProfile accountProfile);

	AccountProfile saveOrUpdateAccountProfile(AccountProfile accountProfile);
}
