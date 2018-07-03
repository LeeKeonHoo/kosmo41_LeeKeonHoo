import java.util.Scanner;

public class Quiz_Puzzle {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);	
		String[][] arr1= {
				{"1","2","3"},
				{"4","X","5"},
				{"6","7","8"}
		};

		String num1;
		int n1 = 1;
		int n2 = 1;	
		while(true) {		
		System.out.println(arr1[0][0] + " " + arr1[0][1] + " " + arr1[0][2]);
		System.out.println(arr1[1][0] + " " + arr1[1][1] + " " + arr1[1][2]);
		System.out.println(arr1[2][0] + " " + arr1[2][1] + " " + arr1[2][2]);
		System.out.print("이동할 좌표");		
		int i = s.nextInt();
		if(i == 1) {	//좌
			num1 = arr1[n1][n2];
			arr1[n1][n2] = arr1[n1][n2-1];
			arr1[n1][n2-1] = num1;
			n2--;
			if(n2 < 0) {
				break;
			}else continue;
			}
		if(i == 2) {	//우
			n2++;
			if(n2 > 3)
			continue;
			else {
			num1 = arr1[n1][n2-1];
			arr1[n1][n2-1] = arr1[n1][n2];
			arr1[n1][n2] = num1;
			}
		}
		if(i == 3) {	//위
			int test = n1-1;
			if(test > 0) {
				num1 = arr1[n1+1][n2];
			arr1[n1+1][n2] = arr1[n1][n2];
			arr1[n1][n2] = num1;
			}
			else {
				continue;
			}
		}
		if(i == 4) {	//아래
			n1++;
			if(n1 > 3)
				continue;
			else {
			num1 = arr1[n1-1][n2];
			arr1[n1-1][n2] = arr1[n1][n2];
			arr1[n1][n2] = num1;
			}
		}
		}
	}
	}