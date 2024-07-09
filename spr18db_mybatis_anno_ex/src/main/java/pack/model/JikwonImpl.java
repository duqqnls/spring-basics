package pack.model;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import pack.mybatis.SqlMapConfig;

@Repository
public class JikwonImpl implements Jikwon_Inter {
    private SqlSessionFactory sessionFactory = SqlMapConfig.getSqlSession();

    @Override
    public List<JikwonDto> selectDataAll() {
        SqlSession sqlSession = sessionFactory.openSession();
        List<JikwonDto> list = null;
        
        try {
            SqlMapperInter mapper = sqlSession.getMapper(SqlMapperInter.class);
            list = mapper.selectDataAll();
        } catch (Exception e) {
            System.out.println("selectDataAll error : " + e);
        } finally {
            if(sqlSession != null) sqlSession.close();
        }
        
        return list;
    }

    @Override
    public int getBuserCount(String buserNum) {
        SqlSession sqlSession = sessionFactory.openSession();
        int count = 0;

        try {
            SqlMapperInter mapper = sqlSession.getMapper(SqlMapperInter.class);
            count = mapper.buserCount(buserNum);
        } catch (Exception e) {
            System.out.println("getBuserCount error : " + e);
        } finally {
            if(sqlSession != null) sqlSession.close();
        }

        return count;
    }

    @Override
    public JikwonDto getHighestPay(String buserNum) {
        SqlSession sqlSession = sessionFactory.openSession();
        JikwonDto highestPaid = null;

        try {
            SqlMapperInter mapper = sqlSession.getMapper(SqlMapperInter.class);
            highestPaid = mapper.getHightPay(buserNum);
        } catch (Exception e) {
            System.out.println("getHighestPay error : " + e);
        } finally {
            if(sqlSession != null) sqlSession.close();
        }

        return highestPaid;
    }
}