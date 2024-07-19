package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="sangdata")
public class Sangpum { // Sangpum이 엔티티기 때문에, 쓰고싶은 애들만 써도 되고, 새로 추가해도 된다.
	@Id
	private int code;
	
	@Column(nullable = false)
	private String sang;

	private int su;
	private int dan;
	
}
