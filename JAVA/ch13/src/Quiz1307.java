public class Quiz1307 {
	public static void main(String[] args) {
		int num=0;
		int[][] arr1= {
			{1,2,3,4},
			{5,6,7,8}
			};
		int[][] arr2= new int[4][2];
		
		for(int i= 0; i < arr2.length; i++) {
			for(int j=0; j< arr2[i].length;j++) {
						arr2[i][j] = arr1[j][i];				
			}
		}
		
		//배열에 저장된 값을 출력
		for(int i =0; i< arr2.length; i++) {
			for(int j=0; j< arr2[i].length; j++) {
				System.out.print(arr2[i][j] + "\t");
			}
			System.out.println();
		}
	}
}