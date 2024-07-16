package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.MemberDto;
import pack.model.MemberDao;

@Controller
public class ListController {
	
	@Autowired
	private MemberDao memberDao; // DB 처리 
	
	@GetMapping("list") 
	public String listProcess(Model model) {
		List<MemberDto> list = memberDao.getMemberList();
		
		model.addAttribute("list", list);
		return "list";
	}
	
}
