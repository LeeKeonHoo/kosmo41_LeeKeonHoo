import java.util.Scanner;
public class Quiz054 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("ù ��° ���ڸ� �Է��ϼ���");
		int num1 = s.nextInt();
		System.out.println("�� ��° ���ڸ� �Է��ϼ���");
		int num2 = s.nextInt();
		
		if(num1 > num2)
		System.out.println("�μ��� ���� " + (num1 - num2));
		else {
		if(num1 < num2)
		System.out.println("�μ��� ���� " + (num2 - num1));
		}
	}
}