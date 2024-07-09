package pack.business;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pack.model.JikwonDto;
import pack.model.Jikwon_Inter;

@Service
public class BusinessImpl implements BusinessInter {
    @Autowired
    private Jikwon_Inter inter;
    
    public void dataPrint() {
        List<JikwonDto> list = inter.selectDataAll();
        
        System.out.println("직원 정보:");
        for(JikwonDto j:list) {
            System.out.println(j.getJikwon_no() + " " + j.getJikwon_name() + " " + j.getBuser_num() + " " + j.getJikwon_ibsail());
        }
        
        System.out.println("\n부서별 인원수:");
        System.out.println("관리부 : " + inter.getBuserCount("10"));
        System.out.println("영업부 : " + inter.getBuserCount("20"));
        System.out.println("전산부 : " + inter.getBuserCount("30"));
        System.out.println("총무부 : " + inter.getBuserCount("40"));
        
        System.out.println("\n부서별 최대 급여자:");
        printHighestPaid("관리부", "10");
        printHighestPaid("영업부", "20");
        printHighestPaid("전산부", "30");
        printHighestPaid("총무부", "40");
    }
    
    private void printHighestPaid(String buserName, String buserNum) {
        JikwonDto highest = inter.getHighestPay(buserNum);
        if(highest != null) {
            System.out.println(buserName + " : " + highest.getJikwon_name() + " (" + highest.getJikwon_pay() + ")");
        } else {
            System.out.println(buserName + " : 데이터 없음");
        }
    }
}