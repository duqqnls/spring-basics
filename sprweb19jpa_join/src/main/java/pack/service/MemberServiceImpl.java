package pack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pack.dto.MemberDto;
import pack.entity.Member;
import pack.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberRepository memRepository;
	
	@Override
	public void getList(Model model) {
		/*
		// 방법 1 : member 전체 자료 반환 : 기본 메소드 사용
		// Member 엔티티를 MemberDto 객체로 전달
		List<Member> entityList = memberRepository.findAll(); 		// entityList : 
		List<MemberDto> list = new ArrayList<MemberDto>(); 			// list 	  :
		for(Member temp:entityList) {
			MemberDto dto = new MemberDto();
			dto.setNum(temp.getNum());
			dto.setName(temp.getName());
			dto.setAddr(temp.getAddr());
			list.add(dto);
		}
		
		*/		
		// 방법 2 : List<Member>를 Stream으로 변경해서 map()를 사용 List<MemberDto>로 변경하기
		List<MemberDto> list = memRepository
								.findAllByOrderByNumDesc()
								.stream()
								.map(item -> MemberDto.toDto(item)).toList();
		/*
		// 방법 3 : 람다 표현식을 메소드 참조 표현식으로 기술 		클래스명 :: 메소드명 
		List<MemberDto> list2 = memRepository
								 .findAllByOrderByNumDesc()
								 .stream()
								 .map(MemberDto::toDto).toList();
		*/
		model.addAttribute("list", list); // 컨트롤러에 MemberDto가 담긴 list를 전달 
	}
		
	@Override
	public void insert(MemberDto dto) {
		// Jpa 작업 영역 내로 들어갈 때, 일반 자료 전달용 (Dto, FormBean) 객체를 대응 엔티티로 변환
		memRepository.save(Member.toEntity(dto)); // controller -> server -> jsp -> dto -> entity 
		
	}
	
	// 수정 자료 읽기 
	@Override
	public void getData(Long num, Model model) { 	  // void이지만, model은 spring이 관리해서, 63라인처럼 작성
		Member m = memRepository.findById(num).get(); // 1. 수정할 엔티티를 가져온다.
		model.addAttribute("dto", MemberDto.toDto(m));
		
	}
	
	@Override
	public void update(MemberDto dto) {
		memRepository.save(Member.toEntity(dto)); // MemberDto를 Member로 바꾸어줘야한다.
	}
	
	@Override
	public void update2(MemberDto dto) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Long num) {
		memRepository.deleteById(num);		
	}
}
