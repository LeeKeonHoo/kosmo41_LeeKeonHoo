import java.util.StringTokenizer;

public class E3_TokenizeString {
	public static void main(String[] args) {
		StringTokenizer st1 = new StringTokenizer("PM:08:45", ":");
		
		while(st1.hasMoreElements())
		System.out.print(st1.nextToken() + ' ');
		System.out.println();
		
		StringTokenizer st2 = new StringTokenizer("12 + 36 - 8 / 2 = 44", "+-/=");
		
		while(st2.hasMoreElements())
		System.out.print(st2.nextToken() + ' ');
		System.out.println();		
	}
}