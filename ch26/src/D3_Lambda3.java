interface Printable6{
	void print(String s);
}
public class D3_Lambda3 {

	public static void main(String[] args) {
		Printable6 prn = (s) -> {System.out.println(s);};
		prn.print("What is Lambda?");
	}
}