import java.util.Random;
import java.util.Scanner;
public class QuizBaseballGame {

	public static void main(String[] args) {
		int num =0;
		int num1 =0;
		int num2 =0;
		int num3 =0;
		Random rand = new Random();
		while(true)
		{
			if((num1 != num2) && (num2 != num3) && (num3 != num1))
			{
				break;
			}
			// 랜덤 숫자 구하기
			num = rand.nextInt(900)+100;   //0~899 + 100
			num1 = num / 100;     
			num2 = (num -num1 *100) /10;    
			num3 = num - num1 *100 -num2 *10;
		}
		System.out.println(num1 *100 + num2* 10 + num3);
		// System.out.println(num1 + "" + num2 + "" + num3); //숫자출력하는 다른 방법			

		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		
//		if(num1 && num2 && num3) System.out.println("이김");

	}
}