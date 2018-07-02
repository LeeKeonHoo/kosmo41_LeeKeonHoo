	interface Animal3
	{
		void cry();
	}
	class Cat3 implements Animal3
	{
		public void cry()
		{
			System.out.println("야옹~");
		}
	}
	class Dog2 implements Animal3
	{
		public void cry()
		{
			System.out.println("멍멍!");
		}
	}
	public class C2_Checkcry {
	public static void main(String[] args) {
		Animal3 cat = new Cat3();
		Animal3 dog = new Dog2();
		
		checkAnimal(cat);
		checkAnimal(dog);
	}
	public static void checkAnimal(Animal3 animal) {
		if(animal instanceof Cat3)
		{
			System.out.println("고양이");
			animal.cry();
		}else if(animal instanceof Dog2)
		{
			System.out.println("강아지");
			animal.cry();
		}
	}
}