package com.saconverse.BeltDemo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.saconverse.BeltDemo.models.IceCream;
import com.saconverse.BeltDemo.models.User;
import com.saconverse.BeltDemo.services.IceCreamService;
import com.saconverse.BeltDemo.services.UserService;

@Controller
public class IceCreamController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private IceCreamService iceCreamServ;
	
	// ========== Display =======================
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("user", userServ.getOne((Long) session.getAttribute("uuid")));
		model.addAttribute("iceCreams", iceCreamServ.getAll());
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/icecreams/new")
	public String newIceCream(@ModelAttribute("iceCream") IceCream iceCream, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		return "newIceCream.jsp";
	}
	
	// ========== Action ========================
	
	@PostMapping("/icecreams/create")
	public String createIceCream(@Valid @ModelAttribute("iceCream") IceCream iceCream, BindingResult result, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		if (result.hasErrors()) {
			return "newIceCream.jsp";
		}
		
		User user = userServ.getOne((Long) session.getAttribute("uuid"));
		iceCream.setCreator(user);
		
		iceCreamServ.save(iceCream);
		
		return "redirect:/dashboard";
	}
}
