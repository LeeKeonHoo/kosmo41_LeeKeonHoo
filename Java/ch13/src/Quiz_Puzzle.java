
import java.util.Random;
import java.util.Scanner;
public class Quiz_Puzzle {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);	
		Random rand = new Random();
		String[][] arr1= {
				{"1","2","3"},
				{"4","X","5"},
				{"6","7","8"}
		};

		String num1;
		int n1 = 1;
		int n2 = 1;	

		for(int k = 0;k <100;k++) {
			int r = rand.nextInt(4)+1;	
				if(r==1) { //좌
					n2 = n2-1;
					if(n2 == -1) {
						n2 = n2 + 1;
						continue;
					}else {
						num1 = arr1[n1][n2+1];
						arr1[n1][n2+1] = arr1[n1][n2];
						arr1[n1][n2] = num1;
						continue;
					}		
				}
			
			else
				if(r==2) { //우
					n2 = n2+1;
					if(n2 == 3) {
						n2 = n2 - 1;
						continue;
					}else {
						num1 = arr1[n1][n2-1];
						arr1[n1][n2-1] = arr1[n1][n2];
						arr1[n1][n2] = num1;
						continue;
					}		
				}
			
			else
				if(r==3) { //상
					n1 = n1-1;
					if(n1 == -1) {
						n1 = n1 + 1;
						continue;
					}else {
						num1 = arr1[n1+1][n2];
						arr1[n1+1][n2] = arr1[n1][n2];
						arr1[n1][n2] = num1;
						continue;
					}		
				}	
			
			else
				if(r==4) { //하
					n1 = n1+1;
					if(n1 == 3) {
						n1 = n1 - 1;
						continue;
					}else {
						num1 = arr1[n1-1][n2];
						arr1[n1-1][n2] = arr1[n1][n2];
						arr1[n1][n2] = num1;
						continue;
					}		
				}
				}
			
				
		while(true) {		
		System.out.println(arr1[0][0] + " " + arr1[0][1] + " " + arr1[0][2]);
		System.out.println(arr1[1][0] + " " + arr1[1][1] + " " + arr1[1][2]);
		System.out.println(arr1[2][0] + " " + arr1[2][1] + " " + arr1[2][2]);
		System.out.print("이동할 좌표");
		int i = s.nextInt();
		
		if(i==1) { //좌
			n2 = n2-1;
			if(n2 == -1) {
				n2 = n2 + 1;
				continue;
			}else {
				num1 = arr1[n1][n2+1];
				arr1[n1][n2+1] = arr1[n1][n2];
				arr1[n1][n2] = num1;
				continue;
			}		
		}
		if(i==2) { //우
			n2 = n2+1;
			if(n2 == 3) {
				n2 = n2 - 1;
				continue;
			}else {
				num1 = arr1[n1][n2-1];
				arr1[n1][n2-1] = arr1[n1][n2];
				arr1[n1][n2] = num1;
				continue;
			}		
		}
		if(i==3) { //상
			n1 = n1-1;
			if(n1 == -1) {
				n1 = n1 + 1;
				continue;
			}else {
				num1 = arr1[n1+1][n2];
				arr1[n1+1][n2] = arr1[n1][n2];
				arr1[n1][n2] = num1;
				continue;
			}		
		}		
		if(i==4) { //하
			n1 = n1+1;
			if(n1 == 3) {
				n1 = n1 - 1;
				continue;
			}else {
				num1 = arr1[n1-1][n2];
				arr1[n1-1][n2] = arr1[n1][n2];
				arr1[n1][n2] = num1;
				continue;
			}		
		}
		}
	}
}