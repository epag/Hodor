import java.util.Scanner;


public class Concept {

	
	public static void main (String []args) {
		
		
		Scanner scanner = new Scanner (System.in);
		
		String question = "";
		System.out.println("Welcome to the Hodor personal assistant! Please ask the popular Game of Thrones charater, Hodor, anything! " +
				"When you are done talking to Hodor simply respond with \"Thank You\"" );
		
		while (!question.equals("thank you")) {
			question = scanner.nextLine();
			System.out.println("Hodor!");
			question.toLowerCase();
		}
		
		System.out.println("Hodor!");
	}
}
