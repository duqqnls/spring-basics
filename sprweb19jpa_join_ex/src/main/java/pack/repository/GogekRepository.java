package pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.entity.Gogek;

public interface GogekRepository extends JpaRepository<Gogek, Integer>{

	// query method
    List<Gogek> findByJikwonJno(int jno); 	// Jikwon_no를 넣어주면, 고객을 찾아준다. 
}
