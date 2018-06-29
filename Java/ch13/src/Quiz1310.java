public class Quiz1310 {
	public static void main(String[] args) {
		int[][] arr1= {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
				};
		int[][] arr2= new int[4][4];
		int[][] arr3= new int[4][4];
		int[][] arr4= new int[4][4];
		//첫번쨰 배열출력
		for(int i =0; i< arr1.length; i++) {
			for(int j=0; j< arr1[i].length; j++) {
				System.out.print(arr1[i][j] + "\t");
			}
			System.out.println();
		}

		for(int i= 0,k=3; i < 4; i++) {
			for(int j=0; j< 4;j++) {
						arr2[j][i+k] = arr1[i][j];
			}
			k = k-2;
		}	
		for(int i= 0,k=3; i < 4; i++) {
			for(int j=0; j< 4;j++) {
						arr3[j][i+k] = arr2[i][j];
			}
			k = k-2;
		}	
		for(int i= 0,k=3; i < 4; i++) {
			for(int j=0; j< 4;j++) {
						arr4[j][i+k] = arr3[i][j];
			}
			k = k-2;
		}	
		//2번째 배열 출력
		System.out.println();
		for(int i =0; i< 4; i++) {
			for(int j=0; j< 4; j++) {
				System.out.print(arr2[i][j] + "\t");
			}
			System.out.println();
		}
		//3번째 배열 출력
		System.out.println();
		for(int i =0; i< 4; i++) {
			for(int j=0; j< 4; j++) {
				System.out.print(arr3[i][j] + "\t");
			}
			System.out.println();
		}
		//4번째 배열 출력
		System.out.println();
		for(int i =0; i< 4; i++) {
			for(int j=0; j< 4; j++) {
				System.out.print(arr4[i][j] + "\t");
			}
			System.out.println();
		}
	}
}