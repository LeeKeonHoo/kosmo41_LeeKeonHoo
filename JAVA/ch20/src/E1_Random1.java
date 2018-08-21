import java.util.Random;
public class E1_Random1 {
	public static void main(String[] args) {
		Random rand = new Random();	//실행할떄 마다 다른결과를 출력
		for(int i=0; i<7; i++)
			System.out.println(rand.nextInt(1000));
	}
}