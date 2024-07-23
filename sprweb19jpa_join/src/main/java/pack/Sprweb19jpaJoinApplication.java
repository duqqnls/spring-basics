package pack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@SpringBootApplication
public class Sprweb19jpaJoinApplication {
	// 1) 어플리케이션에서 SQL 처리용 메소드 연습
	// 2) @MVC로 회원자료 처리
	// 3) @MVC로 직원자료 처리 (조인)
	// 4) JPQL 연습용 화면 작성 : Ajax
	
	@Autowired
	private EntityManagerFactory emf;
	
	// 생성자 이후 자동 실행
	@PostConstruct
	public void initMembers() {
		// Hibernate 객체 사용 : dept, emp 샘플 데이터를 JPQL 이용해 저장하기
		EntityManager em = emf.createEntityManager();		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			List<String> queries = new ArrayList<String>();
			queries.add("INSERT INTO DEPT VALUES (10, 'ACCOUNTING', 'NEW YORK');");
			queries.add("INSERT INTO DEPT VALUES (20, 'RESEARCH', 'DALLAS');");
			queries.add("INSERT INTO DEPT VALUES (30, 'SALES', 'CHICAGO');");
			queries.add("INSERT INTO DEPT VALUES (40, 'OPERATIONS', 'BOSTON');");
			
			queries.add("INSERT INTO emp VALUES (7839,'KING','PRESIDENT',NULL,'17-NOV-81',5000,NULL,10);");
			tx.commit();
		} catch (Exception e) {
			System.out.println("err : " + e);
			tx.rollback();
		} finally {
			em.close();
			emf.close();			
		}		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Sprweb19jpaJoinApplication.class, args);
	}

}
