package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dto.MemberDto;
import pack.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService mservice;	
	
	@GetMapping("/member/mlist")
	public String memlist(Model model) {
		mservice.getList(model);  	 
		// model.addAttribute("mlist", model);
		return "member/mlist";			// return : c -> s -> jpa -> db -> mlist.html을 부른다. 
	}
	
	@GetMapping("/member/insertform")
	public String insertform() {
		return "member/insertform";	
	}
	
	@PostMapping("/member/insert")
	public String insert(MemberDto fbean) {
		mservice.insert(fbean); 	 
		return "member/insert";			
	}
	
	// 회원 수정
	@GetMapping("/member/updateform")
	public String updateform(@RequestParam("num") Long num, Model model) {
		mservice.getData(num, model); // 1. 자료를 읽어온다. 2. MemberService에서 작업 
		return "member/updateform";	
	}
	
	@PostMapping("/member/update")
	public String update(MemberDto fbean) {
		//mservice.update(fbean);
		mservice.update2(fbean);
		return "member/update";			
	}

	// 회원 삭제
	@GetMapping("/member/delete")
	public String delete(@RequestParam("num") Long num) {
		mservice.delete(num); 
		return "redirect:/member/mlist";	
	}
}
