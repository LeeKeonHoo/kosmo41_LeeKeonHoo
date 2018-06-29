public class Quiz1309 {
	public static void main(String[] args) {
		int[] arr = new int[]{210, 19, 72, 129, 34};
		int num1=0;
		int j = 1;
		for(int i=0;i<=3;i++)
		{
			for(j=1;j<=4;j++) 
			{
			if(arr[j-1] > arr[j])
				{
				num1 = arr[j];		
				arr[j]=arr[j-1];
				arr[j-1]=num1;
				}
			}
		}
		System.out.print(arr[0]+ ", ");		
		System.out.print(arr[1]+ ", ");	
		System.out.print(arr[2]+ ", ");		
		System.out.print(arr[3]+ ", ");		
		System.out.print(arr[4]+ ", ");		
	}
}