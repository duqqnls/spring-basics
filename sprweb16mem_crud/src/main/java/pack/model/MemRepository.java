package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemRepository extends JpaRepository<Mem, Integer> {
	// num 자동 증가용	
	@Query(value="select max(m.num) from Mem as m")
	// @Query(value="select max(num) from mem", nativeQuery = true)
	int findByMaxNum();
	
	@Query(value="select m from Mem as m where m.num=?1") // 매핑 활용 - 매개변수 1개짜리 plsql 
	Mem findByNum(String num);
	
}
