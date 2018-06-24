import java.util.Scanner;
public class Quiz0511 
{

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("입력 정수 : ");
		int i = s.nextInt();
		int j = 1;
		while(i >= 1) 
		{
				j = j * i;
				System.out.print(i + " * ");
				i--;
		}
		System.out.println(" = "+ j);
	}			
}