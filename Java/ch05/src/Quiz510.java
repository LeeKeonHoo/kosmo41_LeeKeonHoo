import java.util.Scanner;
public class Quiz510 
{

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("ù ��° ���ڸ� �Է��ϼ���");
		int i = s.nextInt();
		System.out.println("�� ��° ���ڸ� �Է��ϼ���");
		int j = s.nextInt();
		int h = 0;
		
		if(i > j)
		{
			for(int k = i; k >= j; k--) 
			{
				h = h + k;
			}
			System.out.println("����1 " + h);
		}
		else {
			{
			for(int l = j; l >= i; l--)
			{
					h = h + l;
			}
			System.out.println("����2 " + h);
			}				
			
		}
	}

}
