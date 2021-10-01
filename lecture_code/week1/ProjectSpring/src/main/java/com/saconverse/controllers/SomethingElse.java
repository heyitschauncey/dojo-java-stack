package com.saconverse.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saconverse.test.Thing;

@Controller
public class SomethingElse {
	@RequestMapping("/first_jsp")
	public String hurray() {
		Thing thing = new Thing("Shawn");
		
		return "first_jsp.jsp";
	}
	
	@RequestMapping("hot_dog")
	public String hot_dog(Model model) {
		ArrayList<String> toppings = new ArrayList<String>();
		toppings.add("peanut butter");
		toppings.add("ranch");
		toppings.add("jalapanos");
		toppings.add("pineapple");
		toppings.add("hard to pronounce sauce");
		
		model.addAttribute("toppings", toppings);
		
		return "something.jsp";
	}
	
//	def index():
//		return render_template("index.html", toppings = ["t1", "t2", "t3"])
	
}
