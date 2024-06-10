package com.shawn.sessionflash.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/getFormData")
	public String getFormData(
			@RequestParam("name") String name,
			@RequestParam(value="age", required=false) Integer age,
			HttpSession sesh,
			RedirectAttributes flash
			){
		System.out.printf("%s : %d\n", name, age); 
		
		if (age == null) {
			flash.addFlashAttribute("ageError", "Please provide a valid age.");
			return "redirect:/";
		}
		// Session values are GLOBALLY AVAILABLE
		sesh.setAttribute("name", name);
		sesh.setAttribute("age", age);
		
		return "redirect:/display";
	}
	
	@GetMapping("/display")
	public String displayFormData(HttpSession sesh) {
		System.out.println(sesh.getAttribute("name"));
		System.out.println(sesh.getAttribute("age"));
		
		if (sesh.getAttribute("age") == null) {
			return "redirect:/";
		}
		
		Integer myAge = (Integer) sesh.getAttribute("age");
		
		sesh.setAttribute("age", myAge++);
		
		return "display.jsp";
	}
	
	
}