package by.ecp.telephone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class handbooks {

	@GetMapping("/handbooks")
	public String showLoginPage() {
		return "handbooks";
	}
}
