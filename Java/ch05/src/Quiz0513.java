public class Quiz0513 {

	public static void main(String[] args) {
		int i= 0;
		int j =0;
		int k= 0;
		int h =0;
		
		System.out.println("세로");
		for(i = 2; i<10; i++) 
		{
			for(j =1; j<10; j++)
			System.out.print(i + " x " + j + " = " + (i * j) + "  ");
			System.out.print('\n'); //세로 완성
		}
			
		System.out.println("가로");
		for(k = 1; k<10; k++) 
		{
			for(h =2; h<10; h++) 
			System.out.print(h + " x " + k + " = " + (k * h) + "  ");
			System.out.print('\n'); //세로 완성
			}			
		}
}