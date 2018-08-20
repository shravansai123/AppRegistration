package com.jda.user.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jda.user.dao.UserDao;
import com.jda.user.model.Login;
import com.jda.user.model.User;

@Controller
public class ResetController {


		@Autowired
		UserDao userDao;

		@RequestMapping(value = "/reset", method = RequestMethod.GET)
		public ModelAndView showForgot(@RequestParam("resetToken") String resetToken, HttpServletRequest request, HttpServletResponse response) {
			ModelAndView mav = null;
			User user=userDao.getUserbyToken(resetToken);
		
			if(user == null){
			
				mav=new ModelAndView("login");
				mav.addObject("message", "Oops!  This is an invalid password reset link.");
				mav.addObject("login", new Login());
				return mav;
			}
			mav=new ModelAndView("reset");
			mav.addObject("resetToken",resetToken);

			return mav;
		}

		@RequestMapping(value = "/resetProcess", method = RequestMethod.POST)
		public ModelAndView  addUser(HttpServletRequest request, HttpServletResponse response,
		      @RequestParam ("password")String password ,@RequestParam Map<String, String> requestParams) throws IOException {
			System.out.println("value of atul");
			String token = requestParams.get("resetToken");
			System.out.println("token="+token);
			ModelAndView mav = null;
			userDao.newPassword(password, token);
			mav= new ModelAndView("redirect:/");
			return mav;
		 
	}
	}
