package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.checkerframework.checker.units.qual.t;
import org.springframework.stereotype.Repository;


@Repository
public class DataImpl implements DataInterface{

	@Override
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml파일의 6라인 name을 적어줌으로, DB연동! 매우 중요 
		EntityManager em = emf.createEntityManager();	 // 엔티티의 생명주기를 관리. CRUD를 수행
		EntityTransaction tx = em.getTransaction(); 	 // Transaction을 관리하는 인터페이스 
		
		List<MemDto> list = null;
		
		System.out.println("*** 전체 자료 읽기 ***");
		list = findAll(em, MemDto.class);
		for(MemDto m : list) {
			System.out.println(m.getNum() + " " + m.getName() + " " + m.getAddr());
		}
		
		return list;
	}
	
	public<T> List<T> findAll(EntityManager em, Class<T> cla) { // 전체 자료를 읽어오기 위한 메서드
		return em.createQuery("select e from " + cla.getName() + " e", cla).getResultList();
	}
}
