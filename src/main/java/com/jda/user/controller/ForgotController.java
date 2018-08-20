package com.jda.user.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jda.user.dao.UserDao;
import com.jda.user.model.Login;
import com.jda.user.model.User;
import com.jda.user.service.MailService;

@Controller
public class ForgotController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value = "/forget")
	  public ModelAndView showForgot(HttpServletRequest request, HttpServletResponse response) {
	    return new ModelAndView("forget");
	  }
	
	 @RequestMapping(value = "/forgotProcess", method = RequestMethod.POST)
	  public void forgotProcess(HttpServletRequest request, HttpServletResponse response,
			  @RequestParam("email") String email) {
		 ModelAndView mav ;
		 User user=userDao.validateEmail(email);
		 if(user!=null){
			 user.setToken(UUID.randomUUID().toString());
			 userDao.saveToken(user.getToken(), user.getEmail());
			 String appUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getServletContext().getContextPath();
			 
			 mailService.sendMail(user.getEmail(), "reset password", "To reset your password, click the link below:\n" + appUrl + "/reset?resetToken="
						+ user.getToken());
		 }
		 else{
			 System.out.println("false");
		 }
	 }
}
