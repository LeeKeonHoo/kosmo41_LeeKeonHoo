import java.util.Scanner;
public class Quiz058 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("5���� ������ �Է��ϼ���");
			int num;
			int sum = 0;
			
		for(int i = 0; i < 5; i++) {
			num = s.nextInt();

			if(num < 1) {
				System.out.println("1 �̻��ǰ� �Է�");
				i--;
				continue;			
			}
			sum = sum + num;
		}			
		 System.out.println("��°� : " + sum); 

	}
}