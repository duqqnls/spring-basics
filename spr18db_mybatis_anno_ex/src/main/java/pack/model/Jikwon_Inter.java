package pack.model;
import java.util.List;

public interface Jikwon_Inter {
    List<JikwonDto> selectDataAll();
    int getBuserCount(String buserNum);
    JikwonDto getHighestPay(String buserNum);
    
}