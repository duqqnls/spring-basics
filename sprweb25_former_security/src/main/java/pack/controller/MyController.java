package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(name="userid")String userid,
			@RequestParam(name="password")String password,
			HttpSession session, Model model) {
		String valiId = "duqqnls";
		String validPassword = "123";
		
		if(userid.equals(valiId) && password.equals(validPassword)) {
			session.setAttribute("user", userid);
			return "redirect:/success";
		}else {
			model.addAttribute("error", "잘못된 id 또는 password 입니다.");
			return "login";
		}
	}
	
	@GetMapping("/success")
	public String success(HttpSession session, Model model) {
		String user = (String)session.getAttribute("user");
		
		if(user != null) {
			model.addAttribute("myuser", user);
			return "success";
		}else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// session.invalidate();  			  a라는 클라이언트의 전체 session을 지움
		session.removeAttribute("user");   // a라는 클라이언트의 부분 session을 지움 
		return "redirect:/login";
		
	}
	
	@GetMapping("/gugu")
	public String gugu(HttpSession session) {
		if(session.getAttribute("user") != null) {
			return "gugu";
		}else {								
			return "redirect:/login";	// user가 아니라면 로그인 페이지로 이동
		}
	}
	
	@PostMapping("/auth/gugu")
	public String gugu(@RequestParam(name="num")int num, HttpSession session, Model model) {
		if(session.getAttribute("user") != null) {
			model.addAttribute("num", num);
			return "guguresult";
		}else {								
			return "redirect:/login";	
		}
	}
}
