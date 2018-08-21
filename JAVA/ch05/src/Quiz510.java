import java.util.Scanner;
public class Quiz510 
{

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("첫 번째 숫자를 입력하세요");
		int i = s.nextInt();
		System.out.println("두 번째 숫자를 입력하세요");
		int j = s.nextInt();
		int h = 0;
		
		if(i > j)
		{
			for(int k = i; k >= j; k--) 
			{
				h = h + k;
			}
			System.out.println("답은1 " + h);
		}
		else {
			{
			for(int l = j; l >= i; l--)
			{
					h = h + l;
			}
			System.out.println("답은2 " + h);
			}				
			
		}
	}

}
