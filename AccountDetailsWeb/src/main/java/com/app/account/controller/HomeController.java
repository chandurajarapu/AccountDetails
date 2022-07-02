package com.app.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.account.model.RequestPayLoad;

@Controller
public class HomeController {
	@RequestMapping("/")
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("requestpayload", new RequestPayLoad());
		return mav;
	}
	@RequestMapping("/login")
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("loginDetails", new RequestPayLoad());
		mav.addObject("stateNames",new String[]{"","INDIA","AUSIS","SRILANKHA","US","RUSYA"});
		return mav;
	}
	@RequestMapping("/register")
	public ModelAndView registerPage() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("registerDetails", new RequestPayLoad());
		return mav;
	}
	@RequestMapping("/accounts")
	public ModelAndView accountDetailsPage() {
		ModelAndView mav = new ModelAndView("accountdetail");
		mav.addObject("accountDetails", new RequestPayLoad());
		return mav;
	}
	

	@RequestMapping("/forgotpassword")
	public ModelAndView forgotPasswordPage() {
		ModelAndView mav = new ModelAndView("forgotpassword");
		mav.addObject("forgotPasswordDetails", new RequestPayLoad());
		return mav;
	}
	@RequestMapping("/transaction")
	public ModelAndView transactionPage() {
		ModelAndView mav = new ModelAndView("transactiondetails");
		mav.addObject("transactionDetails", new RequestPayLoad());
		return mav;
	}
}
