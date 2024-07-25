package pack.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Jikwon {

	@Id
	@Column(name = "jikwon_no")
	private int jno;

	@Column(name = "jikwon_name")
	private String jname;

	@Column(name = "jikwon_jik")
	private String jik;
	
	@ManyToOne(fetch = FetchType.EAGER) 						// @ManyToOne : 다대일 [N:1] // FetchType.EAGER : 즉시 로딩
	@JoinColumn(name = "buser_num")								// 외래키 
	private Buser buser;										// Jikwon에서 Buser을 참조한다.

	@OneToMany(mappedBy = "jikwon", fetch = FetchType.EAGER)	// @OneToMany : 일대다 [1:N] => Gogek이 연관관계의 주인 
	private List<Gogek> gogekList;								// 한 명의 직원이 여러명의 고객을 갖고있으므로 직원 리스트에 담아둔다. 

}
