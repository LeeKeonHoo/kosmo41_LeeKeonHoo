class Box7<T extends Number>{
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	public T get() {
		return ob;
	}
}
public class B3_BoundedBox {
	public static void main(String[] args) {
		Box7<Integer> iBox = new Box7<>();
		iBox.set(24);
		
		Box7<Double> dBox = new Box7<>();
		dBox.set(5.97);
		
		System.out.println(iBox.get());
		System.out.println(dBox.get());
	}
}