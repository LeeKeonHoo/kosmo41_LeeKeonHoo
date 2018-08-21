import java.util.Scanner;
public class Quiz1301 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int [] ar = new int[5];
		ar[0] = s.nextInt();
		ar[1] = s.nextInt();
		ar[2] = s.nextInt();
		ar[3] = s.nextInt();
		ar[4] = s.nextInt();
		int ssum =100;
		int csum =0;
		int sum=0;
		for(int j : ar) {
			sum += j;
		}
		for(int i= 0; i < ar.length; i++) {
			if(ar[i]>csum) {
			csum = ar[i];
			}
			if(ar[i] < ssum) {
			ssum= ar[i];
			}
		}		
		System.out.println("최소값 : " + ssum);		
		System.out.println("최댓값 : " + csum);		
		System.out.println("총합 : " + sum);
	}
}