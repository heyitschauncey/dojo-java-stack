package com.shawn.session.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@GetMapping("/")
	public String index(HttpSession session) {
		System.out.println("Hello there");
		
		session.setAttribute("name", "Shawn");
		
		return "index.jsp";
	}
	
	@GetMapping("/other")
	public String otherPage(HttpSession sesh) {
		if (sesh.getAttribute("name") == null) {
			return "redirect:/";
		}
		return "other.jsp";
	}
	
	@GetMapping("/form")
	public String formPage() {
		return "form.jsp";
	}
	
	@PostMapping("/processPayment")
	public String processPayment(
			@RequestParam(value="creditCardNumber") Integer creditCardNumber,
			@RequestParam(value="expDate") String expDate,
			@RequestParam(value="productId") Integer productId,
			HttpSession sesh
			) {
		sesh.setAttribute("creditCardNumber", creditCardNumber);
		sesh.setAttribute("expDate", expDate);
		sesh.setAttribute("productId", productId);
		
		
		return "redirect:/results";
	}
	
	@GetMapping("/results")
	public String displayResults() {
		return "results.jsp";
	}
	
}
