package pack;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.ibatis.annotations.Results;

public class Main {
	public static void main(String[] args) {
		// Join
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		
		try {
			
			// JPQL 사용
			String jpql = "select j.jikwonNo, j.jikwonName, b.buserName, j.jikwonIbsail " + 
							"from Jikwon j join j.buser b"; // Jikwon클래스파일에서 reference하고있으니까 j.buser임
			TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class); // Object 와 같이 타입명이 없을경우엔 TypedQuery를 Query로 쓴다.
			List<Object[]> results = query.getResultList();
			
			for(Object[] result:results) {
				System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
			}
			
			System.out.println("******");
			// 1. Native SQL 사용 
			String sql = "select jikwon_no, jikwon_name, buser_name, YEAR(jikwon_ibsail) " + 
							"from jikwon join buser on buser_num=buser_no";
			
			/* 2. Native SQL 사용 - 연도만 출력한다면 이걸로 바꿔라 + 함수 만들기
			for(Object[] result:results) {
				int year = getYearMy((Date)result[3]);
				System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + year);
			}
			
			 String sql = "select jikwon_no, jikwon_name, buser_name, year(jikwon_ibsail) " + 
							"from jikwon join buser on buser_num=buser_no";
			*/
			Query query2 = em.createNativeQuery(sql);
			List<Object[]> results2 = query2.getResultList();
			
			for(Object[] result:results2) {
				System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
			}
			
		} catch (Exception e) {
			System.out.println("err : " + e);
		} finally {
			em.close();
			emf.close();
		}
	}
	
	
	private static int getYearMy(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);		
	}
}
