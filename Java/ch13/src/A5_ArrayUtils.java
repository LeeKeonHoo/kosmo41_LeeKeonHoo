import java.util.Arrays;

class A5_ArrayUtils{
	public static void main(String[] args) {
		int [] ar1 = new int [10];
		int [] ar2 = new int [10];
		
		Arrays.fill(ar1, 7);
		//ar1을 7로 초기화
		System.arraycopy(ar1, 0, ar2, 3, 4);
		//원본 , 원본읽은 위치(컨트롤c), 복사대상(컨트롤v), 쓸 위치, 얼만큼 쓸지
		for(int i=0; i< ar1.length;i++)
			System.out.print(ar1[i] + " ");
		System.out.println();  //단순한 줄바꿈
		for(int i=0; i< ar2.length; i++)
			System.out.print(ar2[i] + " ");
	}
}