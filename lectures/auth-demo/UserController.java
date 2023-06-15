package com.heidichen.authdemo.controllers;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index(Model model) {
        // require empty User() & empty LoginUser() for 2 form:form
		return "logreg.jsp";
	}
	
	@PostMapping("/register")
	public String processRegister(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result, Model model, HttpSession session) {
        // 1. get the registeredUser by calling register in service and make use of the binding result

        // 2. check for result errors
        // 2.1 if there are errors, put the missing model in and return jsp
        // 2.2 if no errors, set userId in session and redirect
	}
	
	@PostMapping("/login")
	public String processLogin(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
			BindingResult result, Model model, HttpSession session) {
         // 1. get the user by calling login in service and make use of the binding result

        // 2. check for result errors
        // 2.1 if there are errors, put the missing model in and return jsp
        // 2.2 if no errors, get the user info from user and set userId in the session
        }
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
        // clear session using session.invalidate()
		return "redirect:/";
	}
	
	@GetMapping("/donations")
	public String dashboard(HttpSession session) {
        // add route protection by checking the session
		return "dashboard.jsp";
	}
	
	
}
