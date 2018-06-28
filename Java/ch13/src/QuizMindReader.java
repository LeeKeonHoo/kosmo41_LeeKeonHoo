import java.util.Scanner;

public class QuizMindReader {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num1 = 50;
		while (true) {
			System.out.println("컴의 예상숫자는 : " + num1);
			String i = s.next();
			if (i.equals("h")) {
				num1 = num1 + ((100 - num1) / 2);
			}
			if (i.equals("l")) {
				num1 = num1 - ((100 - num1) /2);
			}
			if (i.equals("y")) 
				{
				System.out.println("요시!");
				break;
				}
	}
}
}