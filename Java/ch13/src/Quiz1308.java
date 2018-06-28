import java.util.Scanner;
public class Quiz1308 {

	public static void main(String[] args) {
		int[][] arr = new int[4][4];
		int num1=0;
		int num2=0;
		int num3=0;
		int num4=0;

		Scanner s = new Scanner(System.in);

		//배열에 값을 저장
		System.out.println("점수를 입력하세요");		
		for(int i= 0; i < arr.length; i++) {
			for(int j=0; j< arr[i].length;j++) {
				arr[i][j] = s.nextInt();
			}
		}
		//배열에 저장된 값을 출력
		System.out.println("구분" + "   이순신" + "   강감찬" + "   을지문덕" + "  권율 ");
		for(int i =0; i< arr.length; i++) {
			for(int j=0; j< arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}		
		//1열 총합
		for(int i= 0; i < 1; i++) {
			for(int j=0; j< 4;j++) {
					num1 += arr[j][i];
				}
			}
		System.out.print(num1 + "\t");

		//2열 총합
		for(int i= 1; i < 2; i++) {
			for(int j=0; j< 4;j++) {
					num2 += arr[j][i];
				}
			}
		System.out.print(num2 + "\t");

		//3열 총합
		for(int i= 2; i < 3; i++) {
			for(int j=0; j< 4;j++) {
					num3 += arr[j][i];
				}
			}
		System.out.print(num3 + "\t");

		//4열 총합
		for(int i= 3; i < 4; i++) {
			for(int j=0; j< 4;j++) {
					num4 += arr[j][i];
				}
			}
		System.out.print(num4 + "\t");		
	}
}