import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class SBox implements java.io.Serializable{
	String s;
	public SBox(String s) {this.s = s;}
	public String get() {return s;}
}

public class E1_ObjectOutputStream {
	public static void main(String[] args) {
		SBox box1 = new SBox("Robot");
		SBox box2 = new SBox("Strawberry");
		
		try(ObjectOutputStream oo =
				new ObjectOutputStream(new FileOutputStream("Object.bin"))){
			oo.writeObject(box1);
			oo.writeObject(box2);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}