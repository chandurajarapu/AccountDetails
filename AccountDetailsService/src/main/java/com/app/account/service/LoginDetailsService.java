package com.app.account.service;

import com.app.accounts.entity.LoginDetails;

public interface LoginDetailsService {
		LoginDetails getLoginDetailsByUserNamePassword(String userName ,String userPassword);
	   LoginDetails getLoginDetailsByLoginId(Integer loginId );
	   LoginDetails getLoginDetailsByAadharNumber(String aadharNumber );
	   LoginDetails saveLoginDetails(LoginDetails loginDetails  );
	   LoginDetails saveOrUpdateLoginDetails(LoginDetails loginDetails  );
}