public class StringLength {

	public static void main(String[] args) {
		String amountLength = "";
		if(amountLength != null && amountLength.length()==11) {
			System.out.println("amountLength "+ amountLength.length());
		}else {
			System.out.println("Deductee TIN should have 11 characters. "+amountLength.length());
		}
	}
}
