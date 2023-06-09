package com.shawnaconverse.introtospring.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String hello(Model model) {
		model.addAttribute("value1", "Hello There");
		model.addAttribute("value2", "General Kenobi");
		
		ArrayList<String> dogNames = new ArrayList<String>();
		dogNames.add("Vicky");
		dogNames.add("Leia");
		dogNames.add("Elvis");
		dogNames.add("Wu, short for Wu-Tang");
		dogNames.add("Nori");
		dogNames.add("Spike");
		dogNames.add("Max");
		dogNames.add("Fido");
		dogNames.add("Ein");
		dogNames.add("Scooby");
		model.addAttribute("dogNames", dogNames);

		return "index.jsp";
	}
	
	@RequestMapping("/hello")
	public String hello2() {
		return "index.jsp";
	}
	
//	@RequestMapping("/greeting")
//	public String greeting() {
//		return "Hello there, person!";
//	}
//	
//	@RequestMapping("/greeting/{name}")
//	public String specifcGreeting(@PathVariable("name") String name) {
//		return "Hello there, " + name + "!";
//	}
	
	
	// Query Param
	// route?key1=value1&key2=value2
	// param syntax : annotation datatype param
//	@RequestMapping("/search")
//	public String search(@RequestParam(value = "q") String value1, @RequestParam(value = "y", required = false) String value2) {
//		if (value2 == null) {
//		 	return "You searched for: " + value1;
//		} else {
//			return "You searched for: " + value1 + " " + value2;
//		}
//	}
}

				