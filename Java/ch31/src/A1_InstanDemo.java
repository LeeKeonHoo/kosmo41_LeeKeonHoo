import java.time.Duration;
import java.time.Instant;

public class A1_InstanDemo {
	public static void main(String[] args) {
		Instant start = Instant.now();	//현재 시각 정보
		System.out.println("시작 : " + start.getEpochSecond());
		//반환값은 '1970-01-01 00:00:00'을 기준으로 지나온 시간을 초 단위로 계산한 결과
		System.out.println("Time flies like an arrow");
		
		Instant end = Instant.now();	//현재 시각 정보
		System.out.println("시작 : " + end.getEpochSecond());
		
		Duration between = Duration.between(start, end);	//두시각의 차 계산
		//Duration은 시각 차를 표현하기 위한 클래스
		System.out.println("밀리 초 단위차 : " + between.toMillis());
	}
}