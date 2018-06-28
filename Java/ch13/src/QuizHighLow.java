import java.util.Random;
import java.util.Scanner;

public class QuizHighLow {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner s = new Scanner(System.in);
		int num1 = rand.nextInt(100);
		System.out.println("정답 :" + num1);
		int num2 = 6;

		while (true) {
			System.out.print("몇이라고 생각하십니까 :  ");
			int i = s.nextInt();
			if (i < num1)
				System.out.println(i + " 는 제가 정한 숫자보다 작습니다.");
			if (i > num1)
				System.out.println(i + " 는 제가 정한 숫자보다 큽니다.");
			if (i == num1)
				System.out.println(i + " 는 제가 정한 숫자입니다.");

			if (i == num1) {
				System.out.println("정답입니다");
				System.out.println("high/low를 해주셔서 감사합니다");
				System.out.print("다시하시겠습니까?");
				num2 = 6;
				String j = s.next();
				if (!j.equals("y")) {
					break;
				}else {
					continue;
				}
			}
			if (num2 == 0) {
				System.out.println("게임오버");
				System.out.println("high/low를 해주셔서 감사합니다");
				System.out.print("다시하시겠습니까?");
				num2 = 6;
				String k = s.next();
				if (!k.equals("y")) {
					break;
				}else {
					continue;
				}
			}
			System.out.println((num2 - 1) + "번의 기회가 남았습니다");
			num2--;
		}
	}
}