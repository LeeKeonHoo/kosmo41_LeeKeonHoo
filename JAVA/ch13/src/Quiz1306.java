//class Quiz{
//	int num=0;
//	int num2=0;
//	int num3=0;
//
//	for(num=2; num<5;num++) {
//		for(num2=1; num2<10;num2++);
//		num3 = num*num2;
//}
public class Quiz1306 {
	public static void main(String[] args) {
	int[][] arr = new int[3][9];
	
	//배열에 값을 저장
	for(int i= 0; i < arr.length; i++) {
		for(int j=0; j< arr[i].length;j++) {
					arr[i][j] = (i+2) * (j+1);
			}
		}
	//배열에 저장된 값을 출력
	for(int i =0; i< arr.length; i++) {
		for(int j=0; j< arr[i].length; j++) {
			System.out.print(arr[i][j] + "\t");
		}
		System.out.println();
	}	
	}
}