import java.util.Scanner;
public class Quiz057 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		int i = s.nextInt();
		int j = s.nextInt();
		int k = s.nextInt();
		
		if((i+j+k) / 3 >= 90)
		System.out.println(" A ");
		else {
			if((i+j+k) / 3 >= 80)
			System.out.println(" B ");
			else {
				if((i+j+k) / 3 >= 70)
				System.out.println(" C ");
				else {
					if((i+j+k) / 3 >= 50)
					System.out.println(" D ");
					else {
						System.out.println(" F ");
					}
			}
		}
		}
	}
}