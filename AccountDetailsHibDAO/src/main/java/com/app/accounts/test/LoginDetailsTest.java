package com.app.accounts.test;

import java.util.Date;

import com.app.accounts.DAO.LoginDetailsDAO;
import com.app.accounts.DAO.impl.LoginDetailsDAOImpl;
import com.app.accounts.entity.LoginDetails;

public class LoginDetailsTest {
	
	public static void main(String[] args) {
		LoginDetailsDAO loginDetailsDAO = new LoginDetailsDAOImpl();
	/*	LoginDetails loginDetails = new LoginDetails();
		loginDetails.setFirstName("CHandu");
		loginDetails.setMiddileName("");
		loginDetails.setLastName("Raja");
		loginDetails.setUserName("chandurajarapu");
		loginDetails.setUserPassword("Chandu@3377");
		loginDetails.setAadharNumber("123");
		loginDetails.setPanNumber("CCLPR");
		loginDetails.setEmailAddress("chandu@gmail.com");
		loginDetails.setMobileNumber("8008274487");
		loginDetails.setLastLoginDate("2022-06-09");
		loginDetails.setCreatedDate(new Date());
		loginDetails.setUpdatedDate(new Date());
		loginDetailsDAO.saveLoginDetails(loginDetails );*/
		LoginDetails loginDetails = loginDetailsDAO.getLoginDetailsByAadharNumber("123");
		System.out.println("panNumber"+loginDetails.getPanNumber());
	}
}
