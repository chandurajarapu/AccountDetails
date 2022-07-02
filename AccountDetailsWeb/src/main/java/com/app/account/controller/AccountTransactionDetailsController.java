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
import com.app.account.service.AccountTrasactionDetailsService;
import com.app.accounts.entity.AccountTrasactionDetails;

@Controller
@RequestMapping("/account-transaction-details")
public class AccountTransactionDetailsController {
	
	@Autowired
	AccountTrasactionDetailsService accountTrasactionDetailsService;
	
	
	 @RequestMapping(value= "/get-account-transaction-details-by-account-id",method=RequestMethod.POST)
	public ModelAndView getAllAccountTrasactionDetailsByAccountId(Integer accountId){
		return null;
	}
	 
	 @RequestMapping(value= "/get-account-transaction-details-by-transaction-id",method=RequestMethod.POST)
    public ModelAndView getAccountTrasactionDetailsByTransactionId(Integer transactionId){
    	return null;
    }
	 
	 
	 
	 @RequestMapping(value= "/save-account-transaction-details",method=RequestMethod.POST)
	public ModelAndView saveAccountTrasactionDetails(@ModelAttribute("transactionDetails")RequestPayLoad requestPayLoad,ModelMap model){
		 Integer accountId=requestPayLoad.getAccountId();
		 String transactionType=requestPayLoad.getTransactionType();
		 Double transactionAmount=requestPayLoad.getTransactionAmount();
		 String transactionTo=requestPayLoad.getTransactionTo();
		 String transactionFrom=requestPayLoad.getTransactionFrom();
		 String transactionDate=requestPayLoad.getTransactionDate();
		 
		String statusCode="200";
		String statusMessage="Success";
		if(accountId==null){
			statusCode="500";
			statusMessage="required AccountId";
		}
		else if(transactionType==null||transactionType.trim().isEmpty()){
			statusCode="500";
			statusMessage="required TransactionType";
		}
		else if(transactionAmount==null){
			statusCode="500";
			statusMessage="required TransactionAmount";
		}
		else if(transactionTo==null||transactionTo.trim().isEmpty()){
			statusCode="500";
			statusMessage="required AccountTo";
		}
		else if(transactionFrom==null||transactionFrom.trim().isEmpty()){
			statusCode="500";
			statusMessage="required AccountFrom";
		}
		
		 ModelAndView modelandview=null;
		 if(!statusCode.equals("200")){
			 modelandview=new ModelAndView("transactiondetails");
			 RootResponse resp=new RootResponse();
			 resp.setStatusCode(statusCode);
			 resp.setStatusMessage(statusMessage);
			 modelandview.addObject("resp",resp);
			 return modelandview;
		 }
		//Need save the account transaction details 
		AccountTrasactionDetails accountTransactionDetails=new AccountTrasactionDetails();
		accountTransactionDetails.setAccountId(accountId);
		accountTransactionDetails.setTransactionType(transactionType);
		accountTransactionDetails.setTransactionAmount(transactionAmount);
		accountTransactionDetails.setTransactionTo(transactionTo);
		accountTransactionDetails.setTransactionFrom(transactionFrom);
		accountTransactionDetails.setCreatedDate(new Date(System.currentTimeMillis()));
		accountTrasactionDetailsService.saveAccountTrasactionDetails(accountTransactionDetails );
		statusMessage = "Your transaction details is saved..Please login";
		modelandview = new ModelAndView("sucess");
		RootResponse resp = new RootResponse();
		resp.setStatusCode(statusCode);
		resp.setStatusMessage(statusMessage);
		modelandview.addObject("resp",resp);
	   return modelandview;
	}
	 
	 
	 
	 @RequestMapping(value= "/save-or-update-account-transaction-details",method=RequestMethod.POST)
	public ModelAndView saveOrUpdateAccountTrasactionDetails(AccountTrasactionDetails accountTrasactionDetails){
		return null;
	}

}
