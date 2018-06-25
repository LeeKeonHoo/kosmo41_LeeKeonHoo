public class Quiz0514 
{

	public static void main(String[] args) 
	{
		int i = 0;
		int j = 0;

		for(i= 0; i <10 ; i++) 
		{
			if(i==0)
			{
				continue;
			}
			for(j =9; j <0; j--)
				if(j==0)
				{
					continue;
				}
				System.out.println(i*10);
				System.out.println("0" + j);
				System.out.println("------------");
				System.out.println((i*10) + j);
		}
	}		
}