//
//배열을 새로 생성하면서 복사한거
//
import java.util.Arrays;
public class F1_CopyOFArrays {
	public static void main(String[] args) {
		double[] arOrg = {1.1, 2.2, 3.3, 4.4, 5.5};
		
		//배열 전체를 복사
		double[] arCpy1 = Arrays.copyOf(arOrg, arOrg.length);
		
		//세번쨰 요소까지 복사
		double[] arCpy2 = Arrays.copyOf(arOrg, 3);
		
		for(double d : arCpy1)
			System.out.print(d + "\t");
		System.out.println();

		for(double d : arCpy2)
			System.out.print(d + "\t");
		System.out.println();
	}
}