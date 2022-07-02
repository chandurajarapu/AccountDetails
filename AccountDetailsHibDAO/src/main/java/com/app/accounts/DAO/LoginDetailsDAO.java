package com.app.accounts.DAO;

import com.app.accounts.entity.LoginDetails;

public interface LoginDetailsDAO {
	 LoginDetails getLoginDetailsByUserNamePassword(String userName ,String userPassword);
	   LoginDetails getLoginDetailsByLoginId(Integer loginId );
	   LoginDetails getLoginDetailsByAadharNumber(String aadharNumber );
	   LoginDetails saveLoginDetails(LoginDetails loginDetails  );
	   LoginDetails saveOrUpdateLoginDetails(LoginDetails loginDetails  );
}