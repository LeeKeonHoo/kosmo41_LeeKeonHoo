
public class Quiz053 {

	public static void main(String[] args) {
		
		for(int num1 = 1; num1 < 100 ; num1++) {
			if(((num1 % 7) == 0) && ((num1 % 9) == 0)) 
				System.out.println(num1);
			else {
			if(((num1 % 7) == 0) || ((num1 % 9) == 0))
				System.out.println(num1);
			else continue;
			}
			}
	 }
	}	