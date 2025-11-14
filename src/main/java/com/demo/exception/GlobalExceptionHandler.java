package com.demo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	//@ResponseBody
	@ExceptionHandler(userException.class)
	public String userRelatedException(userException userException,Model model)
	{
		System.out.println("User Related Exception");
		String exceptionMsg = userException.getExceptionMsg();
		model.addAttribute("exceptionmsg",exceptionMsg);
		return "UserRegistrationPage";
	}

}
