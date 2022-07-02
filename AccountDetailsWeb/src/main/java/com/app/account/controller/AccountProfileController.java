package com.app.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.accounts.entity.AccountProfile;

@Controller
@RequestMapping(value="/account-profile")
public class AccountProfileController {
	
	
	
	
	 @RequestMapping(value= "/get-account-profile-by-account-id",method=RequestMethod.POST)
	 public ModelAndView getAccountProfileByAccountId(Integer accountId){
		return null;
	}
	 @RequestMapping(value= "/get-account-profile-by-profile-id",method=RequestMethod.POST)
	 public ModelAndView getAccountProfileByProfileId(Integer profileId){
		return null;
	}
	 @RequestMapping(value= "/save-account-profile-profile",method=RequestMethod.POST)
	 public ModelAndView saveAccountProfile(AccountProfile accountProfile){
		return null;
	}
	 @RequestMapping(value= "/save-or-update-account-profile",method=RequestMethod.POST)
	 public ModelAndView saveOrUpdateAccountProfile(AccountProfile accountProfile){
		return null;
	}

}
