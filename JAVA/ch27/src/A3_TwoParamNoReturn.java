interface Calculate{
	void cal(int a, int b);	//매개변수 둘,반환셩 void
}
public class A3_TwoParamNoReturn {
	public static void main(String[] args) {
		Calculate c;
		c = (a,b) -> System.out.println(a+ b);
		c.cal(4, 3);	//이번엔 덧셈이 진행

		c = (a,b) -> System.out.println(a- b);
		c.cal(4, 3);	//이번엔 뻴셈이 진행
		
		c = (a,b) -> System.out.println(a* b);
		c.cal(4, 3);	//이번엔 곱셈이 진행
	}
}