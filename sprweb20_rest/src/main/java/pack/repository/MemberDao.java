package pack.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pack.dto.MemberDto;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSession session;
	
	// 회원자료 전체읽기
	public List<MemberDto> getList() {
		return session.selectList("member.getList");
	}
}