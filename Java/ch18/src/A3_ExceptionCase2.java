import java.util.InputMismatchException;
import java.util.Scanner;

public class A3_ExceptionCase2 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		try {			//입력 오류에 대한 예외의 관점에서 보았을 때 이는 하나의 작업
			System.out.print("a/b...a?");
			int n1 = kb.nextInt(); 
			System.out.print("a/b...b?");
			int n2 = kb.nextInt(); 			
			System.out.printf("%d / %d = %d \n",n1,n2, n1/n2);
			}
		catch(InputMismatchException e) {
			e.getMessage();
		}
		System.out.println("Good bye~!");
}
}