package com.shaibal.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@GetMapping("/welCome")
	public ModelAndView welCome() {
		ModelAndView modelAndView = new ModelAndView("welCome");
		modelAndView.addObject("message", "You are Welcome!");
		return modelAndView;
	}
}
