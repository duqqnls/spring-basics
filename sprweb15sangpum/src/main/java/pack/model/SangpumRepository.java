package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SangpumRepository extends JpaRepository<Sangpum, Integer>{ // int의 래퍼 클래스 ?
	// 검색
	// 메소드 네이밍룰  : findBy[엔티티명]칼럼명.어쩌구저쩌구, readBy[엔티티명]칼럼명.어쩌구저쩌구,getBy[엔티티명]칼럼명.어쩌구저쩌구
	// findBy변수명And변수명, findBy변수명Or변수명, findBy변수명 GreaterThenEqual 등...,
	
	// findByIdSangContaing(svalue)를 네이밍룰에 맞춰서 작성해보자 
	List<Sangpum> findBySangContaining(String svalue);    // 검색어가 포함된 : like '%검색어%'와 같은 기능
	List<Sangpum> findBySangStartingWith(String svalue);  // 검색어로 시작되는 : like '검색어%' 
	List<Sangpum> findBySangEndingWith(String svalue);    // 검색어로 끝나는 : like '%검색어'
	
	// JPQL 사용
	@Query(value = "select s from Sangpum as s where s.sang like %:svalue%") // 이름에 의한 매핑이므로 param 사용
	List<Sangpum> searchLike(@Param("svalue") String svalue);
}
