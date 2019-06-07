package com.samtech.HelloWorld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
private static final	Logger logger = LoggerFactory.getLogger(IndexController.class);
	@RequestMapping("/welcome")
	public String getIndex() {
		logger.debug("index controller are executed");
		System.out.println("executed---[        main]");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("welcome");
		return "welcome";
	}
}
