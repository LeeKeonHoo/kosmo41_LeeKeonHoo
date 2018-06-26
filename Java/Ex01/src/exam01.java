class Calc4
{
	int x1;
	int x2;
	
	Calc4()
	{
		
	}

	Calc4(int n1, int n2)
	{
		x1= n1 + x1;
		x2= n2 = x2;
	}
	int Add(int n1, int n2)
	{
		int nResult = n1 + n2;
		System.out.println(nResult);
		return nResult;
	}
}

public class exam01 {

	public static void main(String[] args) {
		int num1= 5;
		int num2 = 7;
		
		Calc4 myCal = new Calc4(num1, num2);
		int num3 = myCal.Add(num1, num2);
		
		int num4 = num3 * 10 -20;
		System.out.println(num4);
	}
}