package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessImpl implements BusinessInter {

    @Autowired
    private SangpumInter sangpumInter;

    /*
    @Override
    public void selectProcess() {
    	for (SangpumDto s:sangpumInter.selectAll()) {
                System.out.println(s.getCode() + " " +
                		s.getSang() + " " +
                        s.getSu() + " " +
                        s.getDan());
            }
        }
    	*/
    
    @Override
    public void selectProcess() {
    	// 람다 표현식
    	sangpumInter.selectAll().forEach(s ->
    	System.out.println(s.getCode() + " " +
    					   s.getSang() + " " +
    					   s.getSu() + " " + 
    					   s.getDan()));
    }
}
