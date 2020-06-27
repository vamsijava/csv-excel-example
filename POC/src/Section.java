import java.util.ArrayList;
import java.util.List;

public class Section {

	public static void main(String[] args) {
		List<String> listOfSection = new ArrayList<String>();
		listOfSection.add("194C");
		listOfSection.add("194c");
		listOfSection.add("188K");
		listOfSection.add("123T");
		listOfSection.add("187K");
		listOfSection.add("vamsi");
		listOfSection.add("196D");
		if (!listOfSection.isEmpty()) {
			for (String section : listOfSection) {
				System.out.println("section is: " + section);
				if (section.equals("194c")) {
					System.out.println("section is: " + section);
				} else {
					System.out.println("haii vamii");
					System.out.println("Section is not match" + section);
				}
			}
		}
	}
}
