import java.util.*;

public class DateAfter {

	public static void main(String[] args) {

		// create 2 dates
	      Date DocumentDate = new Date(2010, 1, 22);
	      Date AoDate = new Date(2011, 1, 21);
	      
	      if(AoDate.before(DocumentDate) || AoDate.equals(DocumentDate)) {
	    	  System.out.println("Ao Date is big or equal: ");
	      }else {
	    	  System.out.println("Ao Date is small");
	      }
	}

}
