import java.util.Scanner;
class Test 
{
		int j = 0, k = 0;

		Test() 
		{

		}

		Test(int[] arr) 
		{
			for (int i = 0; i < arr.length; i++) 
			{
				if (arr[i] % 2 == 1) 
				{
					j = arr[i];
					j++;
				} else 
					{
					k = arr[i];
					k++;
				
					}
			}
		}

		void print1() {
			System.out.print("홀수 출력 : ");
			for (j = 0; j < 100;) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

		void print2() {
			System.out.print("짝수 출력 : ");
			for (k = 0; k < 100;) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
}
		public class Quiz1303 {
		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			int[] arr = new int[10];
			System.out.println("10개 숫자를 입력하세요");
			arr[0] = s.nextInt();
			arr[1] = s.nextInt();
			arr[2] = s.nextInt();
			arr[3] = s.nextInt();
			arr[4] = s.nextInt();
			arr[5] = s.nextInt();
			arr[6] = s.nextInt();
			arr[7] = s.nextInt();
			arr[8] = s.nextInt();
			arr[9] = s.nextInt();
			Test hol = new Test();
			hol.print1();
			Test jak = new Test();
			jak.print2();
		}
	}

	
	
	// 과거 작업물
	// }
	// for(조건문) {
	// if(in_ar[i] % 2 == 1) {
	// 홀수 배열[j] = in_ar[i];
	// j++;
	// }
	// else {
	// 짝수 배열[k] = in_ar[i];
	// k++;
	// }

	// void 홀수_프린트{
	// System.out.print("홀수 출력 : ");
	// for(조건) {
	// System.out.print(홀수배열[i] + " ");
	// }
	// System.out.println();
	// }
	//
	// void 짝수_프린트{
	// System.out.print("짝수 출력 : ");
	// for(조건) {
	// System.out.print(짝수배열[i] + " ");
	// }
	// System.out.println();
	// }
	//
	// }
	
	// for(int i=0; i<10; i++) {
	// arr[i] = s.nextInt();
	// }

	// 클래스 생성;
	// 클래스 변수 생성 해서 클래스에 배열모양으로 넣기;
	//
	// 클래스 변수.홀수_프린트;
	// 클래스 변수.짝수_프린트;
	//
	/*
	 * for(int i= 0; i <arr.length;i++) { if(arr[i] % 2 == 1) { 홀수배열[j] = arr[i];
	 * j++; System.out.println("홀수 출력 : " + arr[i]); }else {
	 * System.out.println("짝수 출력 : " + arr[i]); } }
	 */
		