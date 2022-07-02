package com.app.account.controller;

import java.sql.Date;
import java.util.List;

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
import com.app.accounts.entity.AccountDetails;

@Controller
@RequestMapping("/account-details")
public class AccountDetailsController {
	
	
	@Autowired
	AccountDetailsService accountDetailsService;
	
	 @RequestMapping(value= "/get-all-account-details-by-aadhar",method=RequestMethod.POST)
	public ModelAndView getAllAccountDetailsByAadharNumber(String aadharNumber){
		return null;
	}
	 
	 
	 
	 @RequestMapping(value= "/get-account-details-by-account-id",method=RequestMethod.POST)
	public ModelAndView getAccountDetailsByAccountId(Integer accountId){
		return null;
	}
	 
	 
	 
	 @RequestMapping(value= "/save-account-details",method=RequestMethod.POST)
	public ModelAndView saveAccountDetails(@ModelAttribute("accountDetails")RequestPayLoad requestPayLoad,ModelMap model){
		 
		// Check aadharnumber , account type , amount , 
		 String aadharNumber=requestPayLoad.getAadharNumber();
		 String accountType=requestPayLoad.getAccountType();
		 Double amount=requestPayLoad.getAmount();
		String statusCode="200";
		String statusMessage="Success";
		if(aadharNumber==null||aadharNumber.trim().isEmpty()){
			statusCode="500";
			statusMessage="required AadharNumber";
		}
		else if(accountType==null||accountType.trim().isEmpty()){
			statusCode="500";
			statusMessage="required AccountType";
		}
		else if(amount==null){
			statusCode="500";
			statusMessage="required Amount";
		}
		 ModelAndView modelandview=null;
		 if(!statusCode.equals("200")){
			 modelandview=new ModelAndView("accountdetails");
			 RootResponse resp=new RootResponse();
			 resp.setStatusCode(statusCode);
			 resp.setStatusMessage(statusMessage);
			 return modelandview;
		 }
		//Need save the account details 
		AccountDetails accountDetails=new AccountDetails();
		accountDetails.setAadharNumber(aadharNumber);
		accountDetails.setAccountType(accountType);
		accountDetails.setAmount(amount);
		accountDetails.setCreatedDate(new Date(System.currentTimeMillis()));
		accountDetails.setCreatedDate(new Date(System.currentTimeMillis()));
		accountDetailsService.saveAccountDetails(accountDetails );
		statusMessage = "Your account details is saved..Please login";
		modelandview = new ModelAndView("sucess");
		RootResponse resp = new RootResponse();
		resp.setStatusCode(statusCode);
		resp.setStatusMessage(statusMessage);
		modelandview.addObject("resp",resp);
	   return modelandview;
	}
	 
	 
	 @RequestMapping(value= "/save-or-update-account-details",method=RequestMethod.POST)
	public ModelAndView saveOrUpdateAccountDetails(AccountDetails accountDetails){
		return null;
	}
}
		
