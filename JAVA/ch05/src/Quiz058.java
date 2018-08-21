import java.util.Scanner;
public class Quiz058 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("5개의 정수를 입력하세요");
			int num;
			int sum = 0;
			
		for(int i = 0; i < 5; i++) {
			num = s.nextInt();

			if(num < 1) {
				System.out.println("1 이상의값 입력");
				i--;
				continue;			
			}
			sum = sum + num;
		}			
		 System.out.println("출력값 : " + sum); 

	}
}