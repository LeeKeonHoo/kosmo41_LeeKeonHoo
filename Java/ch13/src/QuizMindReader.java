import java.util.Scanner;

public class QuizMindReader {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int nmax = 100;
		int nmin = 0;
		int num1 = 50;
		while (true) 
		{
			System.out.println("컴의 예상숫자는 : " + num1);
			String i = s.next();
			if (i.equals("h")) 
			{
				nmax = num1;
				num1 = (nmax+nmin)/ 2;
			}
			else if (i.equals("l"))
			{
				nmin = num1;
				num1 = (nmax+nmin)/ 2;
			}
			else if (i.equals("y")) 
			{
				System.out.println("요시!");
				break;
			}
		}
	}
}