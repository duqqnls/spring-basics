package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface {

    @Override
    public List<MemDto> selectDataAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        
        List<MemDto> list = null;

        try {
            System.out.println("*** 부분 자료 읽기 (단일 엔티티) find() 메소드 ***");
            MemDto mdto = em.find(MemDto.class, 1);
            if (mdto != null) {
                System.out.println(mdto.getNum() + " " + mdto.getName() + " " + mdto.getAddr());
            } else {
                System.out.println("No entity found for ID 1");
            }

            System.out.println("*** 부분 자료 읽기 (복수 엔티티) ***");
            List<MemDto> listPart = findByAddr(em, "강남");
            for (MemDto m : listPart) {
                System.out.println(m.getNum() + " " + m.getName() + " " + m.getAddr());
            }

            System.out.println("*** 전체 자료 읽기 ***");
            list = em.createQuery("select e from MemDto as e", MemDto.class).getResultList();
            for (MemDto m : list) {
                System.out.println(m.getNum() + " " + m.getName() + " " + m.getAddr());
            }

        } catch (Exception e) {
            System.out.println("err : " + e);
        } finally {
            em.close();
            emf.close();
        }

        return list;
    }

    public List<MemDto> findByAddr(EntityManager em, String ss) {
        String jpql = "SELECT m FROM MemDto m WHERE m.addr LIKE :ss";
        
        TypedQuery<MemDto> query = em.createQuery(jpql, MemDto.class);
        query.setParameter("ss", ss + "%");
        return query.getResultList();
    }

    public<T> List<T> findAll(EntityManager em, Class<T> cla) {
        return em.createQuery("select e from " + cla.getSimpleName() + " e", cla).getResultList();
    }
}
