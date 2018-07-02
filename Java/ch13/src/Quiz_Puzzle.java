import java.util.Scanner;

public class Quiz_Puzzle {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num1= 0;
		int[][] arr1= {
				{1,2,3},
				{4,5,6},
				{7,8,00}
		};
		

		System.out.print("이동할 좌표");
		int i=s.nextInt();
		int j,k;
		for(j=1; j < j+1;j++) {
			for(k=2;k > k-1;k--) {
		if(i==1) 
		{
			num1=arr1[j][k];
			arr1[j][k]=arr1[j][j];
			arr1[j][j]=num1;
			k++;
		}else 
		{
				if(i == 2) 
				{
				num1=arr1[0][0];
				arr1[0][0]=arr1[0][0];
				arr1[0][0]=num1;					
				}else 
				{
					if(i == 3) 
					{
					num1=arr1[0][0];
					arr1[0][0]=arr1[0][0];
					arr1[0][0]=num1;
					}else
						if(i == 4)
						{
							num1=arr1[0][0];
							arr1[0][0]=arr1[0][0];
							arr1[0][0]=num1;
						}
				}
		}
	}
	}
		
		System.out.println(arr1[0][0] + " " + arr1[0][1] + " " + arr1[0][2]);
		System.out.println(arr1[1][0] + " " + arr1[1][1] + " " + arr1[1][2]);
		System.out.println(arr1[2][0] + " " + arr1[2][1] + " " + arr1[2][2]);
	}
	}
