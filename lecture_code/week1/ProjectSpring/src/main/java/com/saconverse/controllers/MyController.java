package com.saconverse.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
//	@app.route("/")
//	def index():
//		return "Hello world!"
	
	@RequestMapping("/")
	public String index(@RequestParam(value = "q", required = false) String param) {
		if (param == "" || param == null) {
			return "Hello World!";			
		} else {
			return "This is the param sent in the url: " + param;
		}
	}
	
	@RequestMapping("/hello")
    public String hello(){
      return "Hello world! What route did you use to access me?";
    }
    @RequestMapping("/goodbye")
    public String world(){
      return "Goodbye world!";
    }
    
    @RequestMapping("/greeting/{name}")
    public String greeting(@PathVariable("name") int name) {
    	return "Hello There, " + name + "!";
    }
}
