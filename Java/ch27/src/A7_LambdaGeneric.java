//함수형 인터페이스 : 추상 메서드가 딱 하나만 존재하는 인터페이스

@FunctionalInterface
interface Calculate3 <T>{		//제너릭 기반의 함수형 인터페이스
	T cal(T a, T b);
}
public class A7_LambdaGeneric {
	public static void main(String[] args) {
		Calculate3<Integer> ci = (a, b) -> a+ b;
		System.out.println(ci.cal(4,3));

		Calculate3<Double> cd = (a, b) -> a+ b;
		System.out.println(cd.cal(4.32,3.45));
	}
}