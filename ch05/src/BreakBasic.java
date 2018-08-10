
public class BreakBasic {

	public static void main(String[] args) {
	int num =1;
	boolean search = false;
	
	while(num < 100) {
		if(((num % 5) == 0) && ((num % 7) == 0)) {
			search = true;
			break; // while문 탈출
		}
		num++;
		//num = num + 2;
	}
   if(search)
	   System.out.println("찾는 정수 : " + num);
   else
	   System.out.println("5배수와 7의 배수가 아님");
	}
   
}
