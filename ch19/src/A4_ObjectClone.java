class Point implements Cloneable{
	private int xPos;
	private int yPos;
	
	public Point(int x, int y) {
	xPos = x;
	yPos = y;
}
	public void showPosition() {
		System.out.printf("[%d, %d]", xPos, yPos);
		System.out.println();
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();	//Object 클래스의 clone 메소드 호출
	}
}

public class A4_ObjectClone {
	public static void main(String[] args) {
		Point org = new Point(3, 5);
		Point cpy;
		
		try {
			cpy = (Point)org.clone();
			org.showPosition();
			cpy.showPosition();
		}
		catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}