import com.company.area.Circle;
public class A2_Circle {

	public static void main(String[] args) {
		Circle c1 = new Circle(3.5);
		System.out.println("반지름 3.5 원의 넓이  : " + c1.getArea());
		Circle c2 = new Circle(5.5);
		System.out.println("반지름 3.5 원의 넓이  : " + c2.getArea());
	}
}