class Counter2{
	int count = 0;
	synchronized public void increment() {
		synchronized(this) {
		count++;		
		}
	}
	synchronized public void decrement() {
		synchronized(this) {
		count--;
		}
	}
	public int getCount() {return count;}
}
public class A7_MutualAccessSync {
	public static Counter2 cnt = new Counter2();
	public static void main(String[] args) throws InterruptedException {
		Runnable task1 = () -> {	
				for(int i=0; i < 1000; i++) 
				cnt.increment();	//값음 1 증가
		};
		Runnable task2 = () -> {	
			for(int i=0; i < 1000; i++) 
				cnt.decrement();	//값을 1 감소
		};
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		t1.start();
		t2.start();
		t1.join();	//t1이 참조하는 쓰레드의 종료를 기다림
		t2.join();	//t2가 참조하는 쓰레드의 종료를 기다림
		System.out.println(cnt.getCount());
	}
}