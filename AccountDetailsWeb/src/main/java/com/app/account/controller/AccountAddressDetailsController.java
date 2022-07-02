package com.app.account.controller;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.account.model.RequestPayLoad;
import com.app.account.model.RootResponse;
import com.app.account.service.AccountDetailsService;
import com.app.accounts.entity.AccountAddressDetails;
import com.app.accounts.entity.AccountDetails;

@Controller
public class AccountAddressDetailsController {
	
	@Autowired
	AccountDetailsService accountDetailsService;
	
	
	 @RequestMapping(value= "/get-account-address-details-by-profile-id",method=RequestMethod.POST)
	 public ModelAndView getAccountAddressDetailsByProfileId(Integer profileId){
		return null ; 
	}
	 
	 
	 @RequestMapping(value= "/get-account-address-details-by-address-id",method=RequestMethod.POST)
	 public ModelAndView getAccountAddressDetailsByAddressId(Integer addressId){
		return null;
	}
	 @RequestMapping(value= "/save-account-address-details",method=RequestMethod.POST)
	 public ModelAndView saveAccountAddressDetails(@ModelAttribute("accountDetails")RequestPayLoad requestPayLoad,ModelMap model){
		 return null;
	 }
	 
	 
	 
	 @RequestMapping(value= "/save-or-update-account-address-details",method=RequestMethod.POST)
	 public ModelAndView saveOrUpdateAccountAddressDetails(AccountAddressDetails accountAddressDetails){
		return null;
	}
}

