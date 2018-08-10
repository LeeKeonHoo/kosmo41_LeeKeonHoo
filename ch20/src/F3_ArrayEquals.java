//
//매개변수 a와 a2로 전달된 배열의 내용을 비교하여 true 또는 false 반환
//내용이 같을때 true 반환(배열의 길이가 다르면 false 반환)
import java.util.Arrays;
public class F3_ArrayEquals {
	public static void main(String[] args) {
		int[] ar1 = {1, 2, 3, 4, 5};
		int[] ar2 = Arrays.copyOf(ar1, ar1.length);
		System.out.println(Arrays.equals(ar1, ar2));
	}
}