package pack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.MemberDto;
import pack.repository.MemberDao;
import org.springframework.web.bind.annotation.PutMapping;


// @Controller
// @ResponseBody
@RestController // RESTPUL 개발을 진행시 @ResponseBody 또는 @RestController을 걸어준다.
// @RestController : 객체 데이터를 JSON 형태로 변환해 반환하는 역할
public class MemberController {
	@Autowired
	private MemberDao dao;
	
	/*											26 - 31 라인 : 타임리프 
	@GetMapping("/members")
	public String list(Model model) {
		List<MemberDto> list = dao.getList();
		model.addAttribute("list", list);
		return "list";		
	}
	
	
	@GetMapping("/members")
	public MemberDto list(Model model) {
		MemberDto dto = new MemberDto();
		dto.setNum(1);
		dto.setName("껌먹는중");
		dto.setAddr("여기가 어딘지 모르겠어");
		return dto;
	}
	
	
	@GetMapping("/insertform")
	public String insertform() {
		return "insertform";		
	}
	
	@PostMapping("/insert")
	public String insert(@RequestParam("name")String name,
			@RequestParam("addr")String addr) {
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		dao.insert(dto);
		
		return "redirect:/insert"; // 추가 후 목록보기 
	}
	*/
	
	// ----- REST 요청 처리 ----- //
	@GetMapping("/members")
	public List<MemberDto> getList() {
		// DB 자료를 읽어 
		// HTML 파일로 반환 X 
		// JSON 형태로 변환해 클라이언트 (JavaScript Ajax 요청)에 반환
		System.out.println("get 요청 시작");
		return dao.getList();
	}	
	
	@PostMapping("/members")
	public Map<String, Object> insert(@RequestBody MemberDto dto) {
		// @RequestBody : 요청 본문에 담긴 값(json)을 자바 객체로 변환 
		dao.insert(dto);
		
		// 메세지 전달여부를 확인하도록 만든 MAP
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSuccess", true);
		
		return map;
	}
	
	// 자료 한 개 읽기 
	@GetMapping("/members/{num}") // http://localhost:80/members/3
	public MemberDto getData(@PathVariable("num")int num){
		return dao.getData(num);
	}	
	
	// 회원 수정
	@PutMapping("/members/{num}")
	public Map<String, Object> update(@PathVariable("num") int num,
			@RequestBody MemberDto dto) {
		dto.setNum(num);
		dao.update(dto);
		
		return Map.of("isSuccess", true);
	}
	
	@DeleteMapping("/members/{num}") 
	public Map<String, Object> delete(@PathVariable("num") int num){
		dao.delete(num);
		return Map.of("isSuccess", true);
	}
}
