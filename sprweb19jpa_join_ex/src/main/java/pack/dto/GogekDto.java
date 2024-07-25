package pack.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.entity.Gogek;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GogekDto {
	
	// 고객번호, 고객명, 성별, 나이, 전화
	private int gno;
	private String gname;
	private String gtel;
	private int age;
	private String gender;

	public static GogekDto toDto(Gogek gogek) {
		// 고객 나이
		int age = LocalDate.now().getYear() - Integer.parseInt("19" + gogek.getJumin().substring(0, 2));    
		
//		나이 
//		1. LocalDate.now().getYear()  = 로컬 날짜 클래스로 날짜 정보만 출력 ! 예 : 2024-07-25
//		2. gogek.getJumin().substring(0, 2): 주민등록번호의 앞 두 자리를 가져옴 예 : 주민등록번호가 "970101-1234567"이라면 "97"이 반환
//		3. "19" + gogek.getJumin().substring(0, 2): 위에서 가져온 앞 두 자리에 "19"를 붙임 예 : 앞 두 자리가 "97"이면 "1997"
//		4. Integer.parseInt("19" + gogek.getJumin().substring(0, 2)): 문자열 "1997"을 정수 1997로 변환
//		5. LocalDate.now().getYear() - Integer.parseInt("19" + gogek.getJumin().substring(0, 2)): 현재 연도에서 1997을 빼서 나이를 계산

		// 고객 성별
		String gender = "";
		int a = Integer.parseInt(gogek.getJumin().substring(7, 8));
		if(a == 1 || a == 3) {
			gender = "남";
		} else if(a == 2 || a == 4) {
			gender = "여";
		} else {
			
		}
		
//		성별
//		1. String gender = "";: 성별을 저장할 변수를 초기화
//		2. int a = Integer.parseInt(gogek.getJumin().substring(7, 8));: 주민등록번호에서 7번째 인덱스의 숫자를 가져와 정수로 변환
//		3. if(a == 1 || a == 3) {: 만약 숫자가 1 또는 3이라면, 남
//		4. if(a == 2 || a == 4) {: 만약 숫자가 2 또는 4이라면, 여
//		5, } else {: 그 외의 경우, 현재 코드는 아무 동작도 하지 않음
		
		// Entity to DTO
		return GogekDto.builder()
				.gno(gogek.getGno())
				.gname(gogek.getGname())
				.gtel(gogek.getGtel())
				.age(age)
				.gender(gender)
				.build();
		
	}
}
