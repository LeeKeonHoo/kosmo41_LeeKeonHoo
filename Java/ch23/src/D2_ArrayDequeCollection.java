import java.util.ArrayDeque;
import java.util.Deque;

public class D2_ArrayDequeCollection {
	public static void main(String[] args) {
		Deque<String> deq = new ArrayDeque<>();
		//다음문장도 구성 가능
		//Deque<String> deq = new LinkedList<>();
		
		//앞으로 넣고
		deq.offerFirst("1.Box");
		deq.offerFirst("2.Toy");
		deq.offerFirst("3.Robot");
		
		//앞에서 꺼내기
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println();

		//뒤로 넣고
		deq.offerLast("1.Box");
		deq.offerLast("2.Toy");
		deq.offerLast("3.Robot");

		//뒤로 꺼내기
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
		System.out.println();
		
		//뒤로 넣고
		deq.offerLast("1.Box");
		deq.offerLast("2.Toy");
		deq.offerLast("3.Robot");

		//앞에서 꺼내기
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
	}
}