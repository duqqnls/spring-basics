package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import pack.model.DataDao;
import pack.model.SangpumDto;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class ListController {
	@Autowired // 포함관계임을 작성
	private DataDao dataDao;
	
	@GetMapping("testdb")
	public String listProcess(Model model) {
		ArrayList<SangpumDto> list = dataDao.selectAll();
		//System.out.println("list : " + list.size());
		model.addAttribute("datas", list);  // request.setAttribute("datas", list)
		return "list";
	}
}
