import java.util.Scanner;


public class Quiz05 {

	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		
        int sum = 0;
        int num = 0;
       
        System.out.println("�Է���");
        
        
        do {
        	num = s.nextInt();
        	sum = sum + num;
        	System.out.println("�߰��� : " + sum);
        }while(num != 0);
        
        System.out.println("��°� : " + sum);
        
	}
	
}