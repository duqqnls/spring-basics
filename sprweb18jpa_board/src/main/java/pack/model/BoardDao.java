package pack.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.controller.BoardBean;

@Repository
public class BoardDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataRepository dataRepository;
	
	public List<Board> list() { // 전체 자료 읽기
		List<Board> list = dataRepository.findAll();
		logger.info("list size : " + list.size());	
		
		return list;
	}
	
	public List<Board> search(BoardBean bean) { // 검색 자료 읽기
		List<Board> slist = null;
		
		if(bean.getSearchName().equals("author")) {
			slist = dataRepository.searchLike(bean.getSearchValue());
		}else {
			slist = dataRepository.searchLike(bean.getSearchValue());
		}
		return slist;
	}
	
	@Transactional // 프록시 객체는 해당 메서드가 처리되될 때 commit or rollback 수행  
	// CheckedException 또는 예외가 없는 경우 Commit 수행
	// unCheckedException가 발생하면 Rollback 수행 
	public String insertData(BoardBean bean) {
		try {
			// 새글 입력 시 가장 큰 번호를 얻어 + 1
			int max = dataRepository.maxNum();
	
			Board dto = new Board(); 
			dto.setNum(max + 1);
			dto.setAuthor(bean.getAuthor());
			dto.setTitle(bean.getTitle());
			dto.setContent(bean.getContent());
			dto.setBwrite(Timestamp.valueOf(LocalDateTime.now()));
			dto.setReadcnt(0);
			dataRepository.save(dto);
			
			return "success";
		} catch (Exception e) {
			return "입력 오류 : " + e.getMessage();
		}		
	}
	
	// 상세보기용
	@Transactional
	public Board detail(int num) {
		// 조회수 증가
		dataRepository.updateReadcnt(num);

		// Optional<T> 클래스를 사용해 NPE를 방지할 수 있도록 도와준다. = NULL포인트 EXCEPTION 방지 가능 
		// Spring Data JPA를 사용할 때 Repository에서 findById()의 반환값은 Optional 타입 => java의 optional 메소드 
		Optional<Board> board = dataRepository.findById(num);
		logger.info("board :: {}", board.get());
		
		if(board.isPresent()) {
			return board.get();
		}else {
			return new Board();
		}
	}
	
	@Transactional
	public String updateData(BoardBean bean) {
		try {
			// 조회수도 수정 참여하기 위한 선행 작업 									// *1 방법	
			Optional<Board> board = dataRepository.findById(bean.getNum()); // 1. 수정할 레코드를 읽는다.
			Board imsi = board.get(); 										// 2. 선행작업 
			
			/*
			Board dto = new Board(); 
			dto.setNum(bean.getNum());  	// 이미 등록된 번호 (Num)이므로 수정 작동 
			dto.setAuthor(bean.getAuthor());
			dto.setTitle(bean.getTitle());									
			dto.setContent(bean.getContent());
			dto.setReadcnt(imsi.getReadcnt());								// 3. 마무리 
				
			dataRepository.save(dto);										// 4. 저장 				
			*/
			
			imsi.setAuthor(bean.getAuthor());								// *2 방법 사용시 save 안해도 됌 
			imsi.setTitle(bean.getTitle());
			imsi.setContent(bean.getContent());
			imsi.setReadcnt(bean.getReadcnt());
			
			return "success";
		} catch (Exception e) {
			return "수정 오류 : " + e.getMessage();
		}
	}
	
	@Transactional
	public String deleteData(int num) {
		try {
			dataRepository.deleteById(num);
			
			return "success";
		} catch (Exception e) {
			return "삭제 오류 : " + e.getMessage();
		}
	}
}
