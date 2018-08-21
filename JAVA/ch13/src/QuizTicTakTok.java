import java.util.Scanner;
public class QuizTicTakTok {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);	
		String[][] arr= {
				{"1","2","3"},
				{"4","5","6"},
				{"7","8","9"}
		};
		int a = 1;
		while(true) {
		//출력표
		System.out.println(arr[0][0] + " | " + arr[0][1] + " | " + arr[0][2]);
		System.out.println("---------");
		System.out.println(arr[1][0] + " | " + arr[1][1] + " | " + arr[1][2]);
		System.out.println("---------");
		System.out.println(arr[2][0] + " | " + arr[2][1] + " | " + arr[2][2]);
		//X 빙고
		if(arr[0][0]=="X" && arr[0][1]=="X" && arr[0][2]=="X") {
			System.out.println("GameOver");	break;
		}if(arr[1][0]=="X" && arr[1][1]=="X" && arr[1][2]=="X") {
			System.out.println("GameOver");	break;				
		}if(arr[2][0]=="X" && arr[2][1]=="X" && arr[2][2]=="X") {
			System.out.println("GameOver");	break;				
		}if(arr[0][0]=="X" && arr[1][0]=="X" && arr[2][0]=="X") {
			System.out.println("GameOver");	break;				
		}if(arr[0][1]=="X" && arr[1][1]=="X" && arr[2][1]=="X") {
			System.out.println("GameOver");	break;				
		}if(arr[0][2]=="X" && arr[1][2]=="X" && arr[2][2]=="X") {
			System.out.println("GameOver");	break;				
		}if(arr[0][0]=="X" && arr[1][1]=="X" && arr[2][2]=="X") {
			System.out.println("GameOver");	break;				
		}if(arr[0][2]=="X" && arr[1][1]=="X" && arr[2][0]=="X") {
			System.out.println("GameOver");	break;				
		//O 빙고
		}if(arr[0][0]=="O" && arr[0][1]=="O" && arr[0][2]=="O") {
			System.out.println("GameOver");	break;				
		}if(arr[1][0]=="O" && arr[1][1]=="O" && arr[1][2]=="O") {
			System.out.println("GameOver");	break;				
		}if(arr[2][0]=="O" && arr[2][1]=="O" && arr[2][2]=="O") {
			System.out.println("GameOver");	break;				
		}if(arr[0][0]=="O" && arr[1][0]=="O" && arr[2][0]=="O") {
			System.out.println("GameOver");	break;				
		}if(arr[0][1]=="O" && arr[1][1]=="O" && arr[2][1]=="O") {
			System.out.println("GameOver");	break;				
		}if(arr[0][2]=="O" && arr[1][2]=="O" && arr[2][2]=="O") {
			System.out.println("GameOver");	break;				
		}if(arr[0][0]=="O" && arr[1][1]=="O" && arr[2][2]=="O") {
			System.out.println("GameOver");	break;				
		}if(arr[0][2]=="O" && arr[1][1]=="O" && arr[2][0]=="O") {
			System.out.println("GameOver");	break;
		//무승부
		}if(arr[0][0]!="1" && arr[0][1]!="2" && arr[0][2]!="3" &&
			arr[1][0]!="4" && arr[1][1]!="5" && arr[1][2]!="6" &&
			arr[2][0]!="7" && arr[2][1]!="8" && arr[2][2]!="9")	{
			System.out.println("GameOver");	break;				
		}
		switch(a) {
		case 1 :
			//플레이어1번 차례
			System.out.print("플레이어1, 점령할 좌표 : ");
			int i = s.nextInt();
			if(i==1) {arr[0][0]="X";}
			if(i==2) {arr[0][1]="X";}
			if(i==3) {arr[0][2]="X";}
			if(i==4) {arr[1][0]="X";}
			if(i==5) {arr[1][1]="X";}
			if(i==6) {arr[1][2]="X";}
			if(i==7) {arr[2][0]="X";}
			if(i==8) {arr[2][1]="X";}
			if(i==9) {arr[2][2]="X";}
			a++;
			continue;
		case 2 :
			//플레이어2번 차례
			System.out.print("플레이어2, 점령할 좌표 : ");
			i = s.nextInt();
			if(i==1) {arr[0][0]="O";}
			if(i==2) {arr[0][1]="O";}
			if(i==3) {arr[0][2]="O";}
			if(i==4) {arr[1][0]="O";}
			if(i==5) {arr[1][1]="O";}
			if(i==6) {arr[1][2]="O";}
			if(i==7) {arr[2][0]="O";}
			if(i==8) {arr[2][1]="O";}
			if(i==9) {arr[2][2]="O";}
			a--;
			continue;
			}
		}
	}
}