package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter

@Builder 			// 생성자 추가 
@NoArgsConstructor  // 생성자 추가(15라인)하면 꼭 같이 해주기 근데 에러 떨어짐(15라인)
@AllArgsConstructor // 이것까지 해주어야 에러 안 떨어짐 


@Entity(name="mem")						  // @Entity는 DB의 특정 테이블과 매핑 
public class MemDto { 		  			  // 주의사항 : 카멜케이스로 작성하면 자동으로 @(언더스코어) 네이밍 컨벤션을 따른다.(=해야한다)
	
	@Id
	@Column(name="num")
	private int num; 		 			  // num은 PK이니까 @Id 해준다.
	@Column(name="name", nullable = true) // 원본 테이블에서 NULL 허용이니까 표시해준다.
	private String name;	  			  // 원본 테이블과 명이 같으니까 냅둔다. 하지만 다르다면 ? => @Column(name="다른 이름") 작성해준다.
	private String addr;
}


// 21 - 30 라인 hibernate 영역 