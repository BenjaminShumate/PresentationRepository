package com.example.security.security_demo_003.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import com.example.security.security_demo_003.model.User;
import com.example.security.security_demo_003.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String getLoginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		String notice = null;
		if (error != null) notice = "You have entered an invalid username or password.";
		if (logout != null) notice = "You have been successfully logged out!";
		model.addAttribute("notice", (notice != null) ? notice : "");
		return "login";
	}

	@PostMapping("/login")
	public String postLoginPage() {
		return "login";
	}

	@GetMapping("/logout")
	public String getLogoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//com.web.store.music_store.model.User user = userService.findUserByUsername(auth.getName());//.findUserByUserName(auth.getName());
		if (auth != null) new SecurityContextLogoutHandler().logout(request, response, auth);
		return "redirect:/login?logout=true";
	}
	@GetMapping("/access-denied")
	public String deniedPage() {
		return "denied";
	}
}