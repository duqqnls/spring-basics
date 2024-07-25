package pack.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dto.GogekDto;
import pack.dto.JikwonDto;
import pack.repository.GogekRepository;
import pack.repository.JikwonRepository;

@Controller
public class TestController {
	
	@Autowired
	private JikwonRepository jikwonRepo;
	
	@Autowired
	private GogekRepository gogekRepo;
	
	@GetMapping("/")
	public String main(Model model) {    								// Model 객체는 뷰(View)에 데이터를 전달하기 위해 사용
		// Entity to DTO								
		List<JikwonDto> jlist = jikwonRepo.findAll()					// findAll() 메서드를 호출하여 모든 Jikwon 엔티티를 데이터베이스에서 가져온다.
											.stream()					// .stread : 가져온 Jikwon 엔티티 목록을 스트림으로 변환 (함수형 프로그래밍 스타일 작업 수행을 위해)
											.map(JikwonDto::toDto)		// 스트림의 각 Jikwon 엔티티를 JikwonDto로 변환 
											.toList();					// 스트림의 변환 결과를 다시 리스트로 변환 => jlist는 JikwonDto 객체의 리스트가 된다.
		model.addAttribute("list", jlist);								// 변환된 JikwonDto 리스트를 모델에 추가, list라는 이름으로 데이터를 뷰에 전달 
		return "main";													
	}
	
	@GetMapping("/mygogek")
	public String mygogek(@RequestParam("jno") int jno, Model model) {  // 이 메서드는 URL 요청 매개변수로 jno (사원 번호)를 받는다.
		// 사원명, 직급
		JikwonDto dto = JikwonDto.toDto(jikwonRepo.findByJno(jno));		// JikwonRepo에서 jno에 해당하는 사원을 찾고, 찾은 직원 엔티티를 JikwonDto로 변환
		model.addAttribute("data", dto);								// 변환된 직원 정보를 data라는 이름으로 모델에 추가하여 뷰에 전달 
		
		// 고객 리스트
		List<GogekDto> glist = gogekRepo.findByJikwonJno(jno)			// gogekRepo에서 jno에 해당하는 직원과 관련된 모든 고객을 찾는다.
										.stream()						// 찾은 고객 엔티티 리스트를 스트림으로 변환
										.map(GogekDto::toDto)			// 각 엔티티를 GogekDto로 변환
										.toList();						// 최종적으로 리스트로 만든다.
		model.addAttribute("list", glist);								// 변환된 고객 DTO 리스트를 list라는 이름으로 모델에 추가하여 뷰에 전달
		
		// 고객 수
		model.addAttribute("listsize", glist.size());					// 고객 리스트의 크기를 listsize라는 이름으로 모델에 추가하여 뷰에 전달
		return "gogek";													// gogek 이름의 뷰를 렌더링 
		
	}
}
