public class UpperCase {

	public static void main(String[] args) {
		//String name = "java";
		//String name = "Person";
		//String name = " company ";
		//String name = " person";
		//String name = " Company ";
		//String name = "Assosiation Of Persons (AOP)";
		String name = "java vamsi";
		String trimName = name.trim();
		System.out.println("trim name is: "+trimName);
		trimName = trimName.substring(0, 1).toUpperCase() + 
				trimName.substring(1).toLowerCase();
		System.out.println("name is:"+trimName);
		if("Java Vamsi".equalsIgnoreCase(trimName)) {
			System.out.println("is equal");
		}else {
			System.out.println("is not equal");
		}
	}
}