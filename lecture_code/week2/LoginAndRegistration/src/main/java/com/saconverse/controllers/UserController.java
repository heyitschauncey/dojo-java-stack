package com.saconverse.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.saconverse.models.LoginUser;
import com.saconverse.models.User;
import com.saconverse.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService serv;
	
	@GetMapping("/")
    public String index(Model model, HttpSession session) {
		if (session.getAttribute("uuid") != null) {
			return "redirect:/dashboard";
		}
		
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        serv.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            
            return "index.jsp";
        }
        
        session.setAttribute("uuid", newUser.getId());
        
        return "redirect:/dashboard";
    }
	
	@PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = serv.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            
            return "index.jsp";
        }
        
        session.setAttribute("uuid", user.getId());
        
        return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("uuid");
		
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("loggedInUser", serv.getOne((Long) session.getAttribute("uuid")));
		
		return "dashboard.jsp";
	}
}










