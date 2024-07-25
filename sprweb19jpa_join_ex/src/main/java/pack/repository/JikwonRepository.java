package pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.entity.Jikwon;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{

	// query method
	Jikwon findByJno(int jno); // Jikwon_no를 넣어주면, 해당하는 직원을 찾아준다.

}
