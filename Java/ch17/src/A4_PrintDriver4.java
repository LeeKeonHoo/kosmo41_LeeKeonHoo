interface Printable4{
	void print(String doc);
	default void printCMYK(String doc) {}
}
class Prn731Drv4 implements Printable4{
	@Override
	public void print(String doc) {
		System.err.println("From MD-731 printer");
		System.out.println(doc);
	}	
}
class Prn909Drv4 implements Printable4{
	@Override
	public void print(String doc) {
		System.err.println("From MD-909 black & white ver");
		System.out.println(doc);
	}	
	@Override
	public void printCMYK(String doc) {
		System.err.println("From MD-909 CMYK ver");
		System.out.println(doc);
	}	
}

public class A4_PrintDriver4 {
	public static void main(String[] args) {
	}
}