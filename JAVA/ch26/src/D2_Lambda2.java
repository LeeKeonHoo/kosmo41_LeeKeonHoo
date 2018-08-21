interface Printable5{
	void print(String s);
}
public class D2_Lambda2 {
	public static void main(String[] args) {
		Printable5 prn = new Printable5() {
			public void print(String s) {
				System.out.println(s);
			}
		};
		prn.print("What is Lambda?");
	}
}