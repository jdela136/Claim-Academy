import java.util.Scanner;

public class MainMenu{
	private DuplicateFinder object1;
	private LetterCounter object2;
	private StringReverser object3;
	private WhiteSpaceRemover object4;
	private Scanner in;
	
	public void runMenu() {
		boolean continuePlay = true;
		do {
			System.out.println("\t\t\tMenu");
			System.out.println("------------------------------------------------------");
			System.out.println("What would you like to do? Press a number between 1-5");
			System.out.println("1: Find duplicate letters");
			System.out.println("2: Count how many (a)s are in a word");
			System.out.println("3: Reverse a phrase");
			System.out.println("4: Remove white space");
			System.out.println("5: Quit");
			
			in = new Scanner(System.in);
			int choice = in.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter a word: ");
				Scanner in2 = new Scanner(System.in);
				String word = in2.next();
				char[] arr = word.toCharArray();
				object1 = new DuplicateFinder(arr);
				char[] duplicates = object1.findDuplicates();
				object1.printArray(duplicates);
				break;
			case 2:
				System.out.println("Enter a word: ");
				in2 = new Scanner(System.in);
				word = in2.next();
				arr = word.toCharArray();
				object2 = new LetterCounter(arr);
				System.out.println("Result: " + object2.countLetter());
				break;
			case 3:
				System.out.println("Enter a phrase: ");
				in2 = new Scanner(System.in);
				String phrase = in2.nextLine();
				object3 = new StringReverser(phrase);
				String[] wordArr = object3.reverseString();
				object3.printArray(wordArr);
				break;
			case 4:
				System.out.println("Enter a phrase: ");
				in2 = new Scanner(System.in);
				phrase = in2.nextLine();
				arr =  phrase.toCharArray();
				object4 = new WhiteSpaceRemover(arr);
				System.out.println("Result: " + object4.removeWhiteSpace());
				break;
			case 5:
				System.out.println("Thanks for playing!");
				continuePlay = false;
				break;

			default:
				System.out.println("Invalid entry!");
			}
		}
		while(continuePlay);
	}
}

