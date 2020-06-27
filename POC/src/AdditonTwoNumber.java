
public class AdditonTwoNumber {

	public static void main(String[] args) {
		int a = 10, b = 10;
		 add(a, b);
	}

	public static int add(int a, int b) {
		System.out.println("a: "+ a);
		System.out.println("b: "+ b);
		int total = a + b;
		int mulTotal = a*b;
		System.out.println("Mul Total is: "+mulTotal);
		System.out.println("Total is: "+total);
		return total;
	}
}
