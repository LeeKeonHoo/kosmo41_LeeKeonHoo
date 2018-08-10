import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class E2_ObjectInputStream {
	public static void main(String[] args) {
		try(ObjectInputStream oi =
				new ObjectInputStream(new FileInputStream("Object.bin"))){
			SBox box1 = (SBox) oi.readObject();
			System.out.println(box1.get());
			SBox box2 = (SBox) oi.readObject();
			System.out.println(box2.get());
	}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
}
}