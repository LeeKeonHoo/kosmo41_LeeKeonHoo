interface Viewable2{
	public void showIt(String str);
}

class Viewer1 implements Viewable2 {

	@Override
	public void showIt(String str) {
		System.out.println(str);
	}
}
public class D1_AtOverride {
	public static void main(String[] args) {
		Viewable2 view = new Viewer1();
		view.showIt("Hello Annotations");
	}
}