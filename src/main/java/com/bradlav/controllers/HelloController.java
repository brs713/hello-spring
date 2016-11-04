package com.bradlav.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bradlav.models.HelloMessage;


@Controller
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello(HttpServletRequest query) {
		
		//gets the parameter passed in & stores it to a variable
		//the arg for getParameter should match the name from the name=value pair passed in from the http request
		//e.g.  localhost8080/hello?name=Jabba&title=TheHut could have 2 possible values for getParameter, name & title
		String name = query.getParameter("name");
		
		if (name == null) {
			return "<h1>Hi, All!</h1>";
		}
		else {
			return "<h1>"+ HelloMessage.getMessage(name) +"</h1>";
		}
	}
}
