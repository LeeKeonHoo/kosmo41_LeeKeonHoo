import java.util.Scanner;

public class Quiz052 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("���ڰ����� �Է��ϼ���");		
		int num1 = s.nextInt();
		float nSum = 0;
		
		for(int i = 0; i < num1; i++) {
			System.out.println(" ������ �Է��ϼ���");
		int num2 = s.nextInt();
		nSum = nSum + num2;
		}
		
		System.out.println("��հ� = " + (nSum / num1));		
	}
	

}
