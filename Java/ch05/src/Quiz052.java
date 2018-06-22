import java.util.Scanner;

public class Quiz052 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("숫자개수를 입력하세요");		
		int num1 = s.nextInt();
		float nSum = 0;
		
		for(int i = 0; i < num1; i++) {
			System.out.println(" 정수를 입력하세요");
		int num2 = s.nextInt();
		nSum = nSum + num2;
		}
		
		System.out.println("평균값 = " + (nSum / num1));		
	}
	

}
