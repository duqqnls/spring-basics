package pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	// 메소드룰(메소드 이름)에 따른 내림차순 전체 자료 읽기
	public List<Member> findAllByOrderByNumDesc();
	
	
}
