package com.chibamu.photospin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value ="/")
public class IndexController {
	
	@RequestMapping (value = "welcome", method = RequestMethod.GET)
	public ModelAndView welcome(){
		ModelAndView modelView = new ModelAndView("welcome");
		return modelView;
	}
}
