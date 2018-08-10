//
//파라미터로 람다식을 넘길 때
//
interface Printable7{
	void print(String s);
}
public class D4_Lanbda4 {
	public static void ShowString(Printable7 p, String s) {
		p.print(s);
	}
	public static void main(String[] args) {
		ShowString((s) -> {System.out.println(s);},"What is Lambda?");
	}
}