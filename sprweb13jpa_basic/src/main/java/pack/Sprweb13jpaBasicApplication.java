package pack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import other.OtherClass;

@SpringBootApplication
@ComponentScan(basePackages = {"other"})
public class Sprweb13jpaBasicApplication {

	public static void main(String[] args5) {
		SpringApplication.run(Sprweb13jpaBasicApplication.class, args5)
			.getBean(Sprweb13jpaBasicApplication.class).myExecute();
	}
	
	@Autowired
	ProductCrudRepository crudRepository;
	
	@Autowired
	OtherClass class1;
	
	private void myExecute() {
		System.out.println("독립적인 프로그램으로 실행");
		
		insData();
		delData();
		selectData();
		
		class1.abc();
	}
	
	private void insData() {
		// ProductVo productVo = new ProductVo();
		// productVo.setCode(4);
		// ..
		// ProductVo productVo = new ProductVo(null, "볼펜", 2, 1000); // 1. 번호를 주지않으면 insert
		
		ProductVo productVo = new ProductVo(2, "사랑비", 10, 2000); 	  // 2. 번호를 넣으면 update
		// System.out.println(productVo.toString());
		crudRepository.save(productVo);
	}
	
	private void delData() {
		crudRepository.deleteById(3);
	}
	
	private void selectData() { 
		// 전체 레코드 읽기
		List<ProductVo> list = (List<ProductVo>)crudRepository.findAll(); // findAll()는 crudRepository에서 지원 
		// System.out.println(list.get(0).getSang());
		for(ProductVo p:list) {
			System.out.println(p.getCode() + " " + 
						p.getSang() + " " + 
						p.getSu() + " " + 
						p.getDan());
		}
		
		System.out.println();
		// 1개 레코드 읽기
		ProductVo vo = crudRepository.findById(2).get();
		System.out.println(vo.getCode() + " " + 
				vo.getSang() + " " + 
				vo.getSu() + " " + 
				vo.getDan());
	}
}