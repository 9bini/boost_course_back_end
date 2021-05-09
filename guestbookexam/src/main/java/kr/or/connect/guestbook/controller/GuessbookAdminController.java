package kr.or.connect.guestbook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GuessbookAdminController {
	@GetMapping("/loginform")
	public String loginform() {
		return "loginform";
	}

	@PostMapping("/login")
	public String login(@RequestParam(name = "passwd") String password, HttpSession session,
			RedirectAttributes redirect) {

		if ("1234".equals(password)) {
			session.setAttribute("isAdmin", "true");
		} else {
			redirect.addFlashAttribute("errorMessage", "암호가 틀렸습니다.");
			return "redirect:/loginform";
		}

		return "redirect:/list";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("isAdmin");
		return "redirect:/list";
	}

}