interface HowLong{
	int len(String s);	//값을 반환하는 메소드
}
public class A5_OneParamAndReturn {
	public static void main(String[] args) {
		HowLong h1 = s -> s.length();
		System.out.println(h1.len("I am so happy"));
	}
}