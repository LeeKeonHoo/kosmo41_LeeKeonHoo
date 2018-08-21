
public class Quiz059 
{

	public static void main(String[] args) 
	{
	int i =0;
	int j =0;
		do 
		{ 
			if((i % 2) == 0)
			{			
			j = j + i;			
			}		
			i++;
		}while(i < 100);
		System.out.println(j);
	}
}