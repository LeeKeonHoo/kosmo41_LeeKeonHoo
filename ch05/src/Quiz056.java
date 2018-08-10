import java.util.Scanner;
public class Quiz056 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("정수를 입력하세요");		
		int i = s.nextInt();
		for(i = i; i > 1; ) {			
		for(int j = i; j >= 1; j--) {
			System.out.print(i + " X " + j + " = " + (i * j) + " , ");
		}System.out.print('\n');
		break;
}
}
}