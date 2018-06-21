import java.util.Scanner;


public class Quiz05 {

	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		
        int sum = 0;
        int num = 0;
       
        System.out.println("입력해");
        
        
        do {
        	num = s.nextInt();
        	sum = sum + num;
        	System.out.println("중간값 : " + sum);
        }while(num != 0);
        
        System.out.println("출력값 : " + sum);
        
	}
	
}