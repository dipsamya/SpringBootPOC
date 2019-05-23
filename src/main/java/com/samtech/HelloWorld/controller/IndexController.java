package com.samtech.HelloWorld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@RequestMapping("/welcome")
	public String getIndex() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("welcome");
		return "welcome";
	}
}
