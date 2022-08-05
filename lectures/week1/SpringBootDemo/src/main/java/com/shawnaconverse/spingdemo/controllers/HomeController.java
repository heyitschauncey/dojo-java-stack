package com.shawnaconverse.spingdemo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
//	@RequestMapping("/")
//	public String index() {
//		return "Hello There";
//	}
//	
//	@RequestMapping("/pizza/{number}")
//	public String pizza(@PathVariable("number")  String number) {
//		return "I like pizza" + number;
//	}
	
	// The route  of this is ambiguous with the above function
	// both routes are '/pizza/{variable}'
//	@RequestMapping("/pizza/{topping}")
//	public String pizzaTopping(@PathVariable("topping") String topping) {
//		return "My topping is: " + topping;
//	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("firstName", "Shawn");
		model.addAttribute("lastName", "Converse");
		
		ArrayList<String> dojos = new ArrayList<String>();
        dojos.add("Burbank");
        dojos.add("Chicago");
        dojos.add("Bellevue");
        model.addAttribute("dojosFromMyController", dojos);
		
		return "index.jsp";
	}
	
	
	
}
