package com.app.account.service.impl;

import org.springframework.stereotype.Service;

import com.app.account.service.LoginDetailsService;
import com.app.accounts.DAO.LoginDetailsDAO;
import com.app.accounts.DAO.impl.LoginDetailsDAOImpl;
import com.app.accounts.entity.LoginDetails;
@Service
public class LoginDetailsServiceImpl implements LoginDetailsService {
	LoginDetailsDAO loginDetailsDAO=new LoginDetailsDAOImpl(); 
	public LoginDetails getLoginDetailsByUserNamePassword(String userName, String userPassword) {
		return loginDetailsDAO.getLoginDetailsByUserNamePassword( userName,userPassword) ;
	}

	public LoginDetails getLoginDetailsByLoginId(Integer loginId) {
		return loginDetailsDAO.getLoginDetailsByLoginId(loginId);
	}

	public LoginDetails getLoginDetailsByAadharNumber(String aadharNumber) {
		return loginDetailsDAO.getLoginDetailsByAadharNumber(aadharNumber) ;
	}

	public LoginDetails saveLoginDetails(LoginDetails loginDetails) {
		return loginDetailsDAO.saveLoginDetails(loginDetails);
	}

	public LoginDetails saveOrUpdateLoginDetails(LoginDetails loginDetails) {
		return loginDetailsDAO.saveOrUpdateLoginDetails(loginDetails);
	}

}
