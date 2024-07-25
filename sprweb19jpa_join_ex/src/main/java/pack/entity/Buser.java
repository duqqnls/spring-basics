package pack.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Buser {

    @Id
    @Column(name="buser_no")
    private int bno;

    @Column(name="buser_name")
    private String bname;

    @Column(name="buser_tel")
    private String btel;

    @OneToMany(mappedBy = "buser") 	 // 참조를 당하는 쪽에서 읽기만 가능 => mappedBy로 연관관계의 주인을 읽을 것이라는 명시가 중요 !!!! 
    private List<Jikwon> jikwonList; // 반대쪽은 읽기만 가능해서, Buser에서 List를 추가하기만 하면 된다.

    // 다대일 양방향 Jikwon : N - Buser : 1 => Buser에서도 Jikwon을 참조한다. 
}
