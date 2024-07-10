package pack;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="jikwon")
public class Jikwon {
	@Id
	@Column(name="jikwon_no")
	private int jikwonNo;
	
	@Column(name="jikwon_name")
	private String jikwonName;
	
	@ManyToOne 			 // 여러개의 부서는 한 개의 직원을 가질 수 있다. = 다대일 관계 = N:1 , N:M <==> 1:1 , 1: N (=@OneToMany 사용)
	@JoinColumn(name="buser_num", referencedColumnName = "buser_no")
	private Buser buser; // 29라인의 부서는 Buser.class파일의 21라인 class 'Buser'를 가르킨다 *해석* : join을 위해 ~ 
	
	@Column(name="jikwon_ibsail")
	private Date jikwonIbsail;	
}
