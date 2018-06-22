public class Quiz055 {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			if((i % 2) == 0)
		for(int j = 1; j <= i; j++) {
			if((j % 2) == 0)				
			System.out.print(i + " X " + j + " = " + (i * j) + " , ");			
		}
		System.out.print('\n');
	}
	}
}