package com.app.account.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.account.email.config.EmailService;
import com.app.account.model.RequestPayLoad;
import com.app.account.model.RootResponse;
import com.app.account.service.AccountDetailsService;
import com.app.account.service.LoginDetailsService;
import com.app.account.util.AppConstents;
import com.app.accounts.entity.AccountDetails;
import com.app.accounts.entity.LoginDetails;

@Controller
@RequestMapping(value="/login")
public class LoginDetailsController {
	
	@Autowired
	private LoginDetailsService loginDetailsService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	AccountDetailsService accountDetailsService;
	
	 @RequestMapping(value= "/get-login-details-by-username-password",method=RequestMethod.POST)
	 public ModelAndView getLoginDetailsByUserNamePassword(@ModelAttribute("loginDetails") RequestPayLoad requestPayLoad,ModelMap model){
		 ModelAndView modelAndView = null;
		 RootResponse resp = new RootResponse();
		 
		 String userName = requestPayLoad.getUserName();
		 String userPassword = requestPayLoad.getUserPassword();
		 LoginDetails loginDetails = loginDetailsService.getLoginDetailsByUserNamePassword(userName,userPassword);
		 
		 if( loginDetails != null ){
			 System.out.println("User validated successfully...");
//			 modelAndView = new ModelAndView("profile");
			 
			 modelAndView = new ModelAndView("accountsview");
			 //aadharNumber load from login details
			 // By using aadhar number we need to get List of account details..
			 String aadharNumber=loginDetails.getAadharNumber();
			 List<AccountDetails> accountDetailsList = accountDetailsService.getAllAccountDetailsByAadharNumber(aadharNumber);
			 resp.setStatusCode("200");
			 resp.setStatusMessage("User Succeffully loged in.....");
			
			 if( accountDetailsList == null || accountDetailsList.isEmpty() ){
				 resp.setStatusCode("500");
				 resp.setStatusMessage("No account details are available..");
			 }
			 
			 resp.setResponse(accountDetailsList); // We need set the List of account Details
			 loginDetails.setLastLoginDate("29-06-2022");
			 loginDetails.setUpdatedDate(new Date(System.currentTimeMillis()));
			 loginDetailsService.saveOrUpdateLoginDetails(loginDetails);
			 
			 
			 modelAndView.addObject("userName", requestPayLoad.getUserName());		 
			 modelAndView.addObject("resp",resp);
			 
		 }else{
			 System.out.println("User details not avaiable...");
			 modelAndView = new ModelAndView("login");
			 resp.setStatusCode("500");
			 resp.setStatusMessage("Invalid user or password.");
		 }
		 
		 modelAndView.addObject("resp",resp);
		 
		 return modelAndView;
	}
	 
	 @RequestMapping(value= "/get-login-details-by-login-id",method=RequestMethod.POST)
	 public ModelAndView getLoginDetailsByLoginId(Integer loginId ){
		   return null;
	   }
	 @RequestMapping(value= "/get-login-details-by-aadhar",method=RequestMethod.POST)
	 public ModelAndView getLoginDetailsByAadharNumber(String aadharNumber ){
		   return null;
	   }
	 
	 
	 @RequestMapping(value= "/save-login-details",method=RequestMethod.POST)
	 public ModelAndView saveLoginDetails(@ModelAttribute("registerDetails") RequestPayLoad requestPayLoad,ModelMap mode){
		 String firstName=requestPayLoad.getFirstName();
		 String lastName=requestPayLoad.getLastName();
		 String emailAddress=requestPayLoad.getEmailAddress();
		 String aadharNumber=requestPayLoad.getAadharNumber();
		 String userName=requestPayLoad.getUserName();
		 String statusCode="200";
		 String statusMessage="Success";
		 if(firstName==null||firstName.trim().isEmpty()){
			 statusCode="500";
			 statusMessage="Required FirstName";
		 }else if(lastName==null||lastName.trim().isEmpty()){
			 statusCode="500";
			 statusMessage="Required LastName"; 
		 }else if(emailAddress==null||emailAddress.trim().isEmpty()){
			 statusCode="500";
			 statusMessage="Required Email Address"; 
		 }else if(aadharNumber==null||aadharNumber.trim().isEmpty()){
			 statusCode="500";
			 statusMessage="Required Aadhar Number"; 
		 }else if(userName==null||userName.trim().isEmpty()){
			 statusCode="500";
			 statusMessage="Required User Name"; 
		 }
		 
		 ModelAndView modelAndView=null;
		 if(!statusCode.equals("200")){
			modelAndView =new ModelAndView("register");
			RootResponse resp= new RootResponse();
			resp.setStatusCode(statusCode);
			resp.setStatusMessage(statusMessage);
			modelAndView.addObject("resp",resp);
			return modelAndView;
		 }
		 
		 
		System.out.println("Start : LoginDetails is saving because the mandatory fields are comming");
		LoginDetails loginDetails = new LoginDetails();
		loginDetails.setFirstName(requestPayLoad.getFirstName());
		loginDetails.setMiddileName(requestPayLoad.getMiddileName());
		loginDetails.setLastName(requestPayLoad.getLastName());
		loginDetails.setUserName(requestPayLoad.getUserName());
		loginDetails.setUserPassword(requestPayLoad.getUserPassword());
		loginDetails.setAadharNumber(requestPayLoad.getAadharNumber());
		loginDetails.setPanNumber(requestPayLoad.getPanNumber());
		loginDetails.setEmailAddress(requestPayLoad.getEmailAddress());
		loginDetails.setMobileNumber(requestPayLoad.getMobileNumber());
		
		String defultPassword = "Account@1234";
		
		loginDetails.setUserPassword(defultPassword);
		loginDetails.setLastLoginDate("01-07-2022");
		loginDetails.setCreatedDate(new Date());
		loginDetails.setUpdatedDate(new Date());
		loginDetailsService.saveLoginDetails(loginDetails );
		
		//START : Sending email process for default password to login not yet implemented 
		String to=emailAddress;
		String from=AppConstents.FROM_ADDRESS;
		String ccAddress=null;
		String sub="Login Credintial";
		String mesBody="Hi "+firstName;
		mesBody += ", \n \n Your defalut password is : "+defultPassword;
		mesBody += "\n \n Thanks, \n Account Team.";
		String fileName=null;
		
		boolean isMailSent = emailService.sendEmailWithAttachment(to, from, ccAddress, sub, mesBody, fileName);
		System.out.println("is mail sent or not "+isMailSent);
		statusMessage = "Your regestaration is completed..Please login";
		modelAndView = new ModelAndView("sucess");
		RootResponse resp = new RootResponse();
		resp.setStatusCode(statusCode);
		resp.setStatusMessage(statusMessage);
		modelAndView.addObject("resp",resp);
	   return modelAndView;
	  }
	 
	 
	 
	 @RequestMapping(value= "/save-or-update-login-details",method=RequestMethod.POST)
	 public ModelAndView saveOrUpdateLoginDetails(LoginDetails loginDetails  ){
		   return null;
	   }
	 
	 
	 @RequestMapping(value= "/update-password",method=RequestMethod.POST)
	 public ModelAndView updatePasswordLoginDetails(LoginDetails loginDetails  ){
		   return null;
	   }

}
