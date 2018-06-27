//
//	static 초기화 블록
//
import java.time.LocalDate;

public class A3_DateOFExecution {
	static String date;	// 프로그램의 실행 날짜를 저장하기 위한 변수
	
	//인스턴스 생성과 관계 없이 static 변수가 메모리 공간에 할당될 떄 실행이 된다.
	static {
		LocalDate nDate = LocalDate.now();
		date =nDate.toString();
	}
	public static void main(String[] args) {
		System.out.println(date);
	}
}