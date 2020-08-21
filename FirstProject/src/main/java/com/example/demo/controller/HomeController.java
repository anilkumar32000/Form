package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.FormValidation;

@Controller
public class HomeController {
	
	@Autowired
	private FormValidation formvalidation;
	
	@RequestMapping(value="/fill", method =RequestMethod.GET)
	public ModelAndView startingPage(@ModelAttribute("user")StudentForm user) {
		ModelAndView mv =new ModelAndView();
		 mv.addObject("obj",user);
		 mv.setViewName("studentdetails");
		return mv;
	}

	
	@RequestMapping(value="/submitForm",method=RequestMethod.POST)
	public @ResponseBody StudentForm1 CollectedData(@RequestBody StudentForm user,HttpServletRequest request){
		return formvalidation.validate(user.getName(),user.getAge());
	}
	
}


