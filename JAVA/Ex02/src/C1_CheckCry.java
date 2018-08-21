	interface Cry
	{
		void cry();
	}
	class Cat2 implements Cry
	{
		public void cry()
		{
			System.out.println("야옹~");
		}
	}
	class Dog
	{
		public void cry()
		{
			System.out.println("멍멍!");
		}
	}
	public class C1_CheckCry {
	public static void main(String[] args) {
		Cat2 cat = new Cat2();
		Dog dog = new Dog();
		
		if (cat instanceof Cry)
		{
			cat.cry();
		}
		else
		{
			dog.cry();
		}
	}
}