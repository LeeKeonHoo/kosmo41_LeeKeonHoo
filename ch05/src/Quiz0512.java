public class Quiz0512 {
	public static void main(String[] args) {
	int i=1;
	int k =0;
		do 
		{
			for(int j=i; j < i+1; j++)
			{
				k = k+j;
				System.out.print(j + " + ");
			}
			i++;
		} while(i <= 1000);
		System.out.println(" = " + k);	
	}
}