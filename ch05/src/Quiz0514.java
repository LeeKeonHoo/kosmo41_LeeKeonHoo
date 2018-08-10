public class Quiz0514 
{
	public static void main(String[] args) 
	{
		int i = 0;
		int j = 0;

		for(i= 0; i <10 ; i++) 
		{
			for(j =0; j <10; j++)
			{
				if((i*10+j) + (j*10+i) ==99)
				{
					System.out.println(i + " " + j);					
					System.out.println(j + " " + i);
					System.out.println("------------");
					System.out.println("9 9");
				}
			}
		}
	}
}