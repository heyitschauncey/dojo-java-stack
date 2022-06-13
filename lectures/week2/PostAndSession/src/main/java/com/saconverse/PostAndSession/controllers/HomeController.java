package com.saconverse.PostAndSession.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);			
		}
		
		return "index.jsp";
	}
	
	
//	@RequestMapping("/tacos")
	@GetMapping("/tacos")
	public String tacos(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		
		session.setAttribute("count", currentCount + 1);
		System.out.println(session.getAttribute("count"));
		
		return "tacos.jsp";
	}
	
//	@RequestMapping(value = "/order", method = RequestMethod.POST)
	@PostMapping("/order")
	public String orderPizza(
			@RequestParam(value = "cheese") String cheese, 
			@RequestParam(value = "sauce") String sauce, 
			@RequestParam(value = "topping") String topping,
			@RequestParam Map<String, String> requestParams,
			HttpSession session) {
//		requestParams.get("cheese");
		System.out.println(cheese);
		System.out.println(sauce);
		System.out.println(topping);
		session.setAttribute("cheese", cheese);
		session.setAttribute("sauce", sauce);
		session.setAttribute("topping", topping);
		
		
		return "redirect:/showOrder";
//		return "index.jsp";
	}
	
	@RequestMapping("/showOrder")
	public String showOrder(HttpSession session, Model model) {
		model.addAttribute("cheese", session.getAttribute("cheese"));
		model.addAttribute("sauce", session.getAttribute("sauce"));
		model.addAttribute("topping", session.getAttribute("topping"));
		
		return "showOrder.jsp";
	}
	
}
