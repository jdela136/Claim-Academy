import java.util.Scanner;

public class MainMenu{
	private AandB object1;
	private LotteryTicket object2;
	private SquirrelPlay object3;
	private XXFinder object4;
	private StringRepeater object5;
	private Scanner in;
	
	public void runMenu() {
		boolean continuePlay = true;
		do {
			System.out.println("\t\t\tMenu");
			System.out.println("------------------------------------------------------");
			System.out.println("What would you like to do? Press a number between 1-6");
			System.out.println("1: Sum 2 numbers or A, if the sum has more digit than A");
			System.out.println("2: Will the Squirrels play? ");
			System.out.println("3: Lottery Ticket");
			System.out.println("4: XX Finder");
			System.out.println("5: String Repeater");
			System.out.println("6: Quit");
			
			in = new Scanner(System.in);
			int choice = in.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter the first number: ");
				Scanner in2 = new Scanner(System.in);
				int a = in2.nextInt();
				System.out.println("Enter the second number: ");
				Scanner in3 = new Scanner(System.in);
				int b = in3.nextInt();
				object1 = new AandB(a,b);
				System.out.println("Result: " + object1.sumLimit());
				break;
			case 2:
				System.out.println("Enter the temperature: ");
				in2 = new Scanner(System.in);
				int temp = in2.nextInt();
				System.out.println("Is it summer? Enter t for True or t for False ");
				in3 = new Scanner(System.in);
				String entry = in3.next().toLowerCase();
				boolean isSummer;
				switch(entry) {
				case "t":
					isSummer = true;
					object3 = new SquirrelPlay(temp,isSummer);
					System.out.println("Result: " + object3.squirrelPlay());
					break;
				case "f":
					isSummer = false;
					object3 = new SquirrelPlay(temp,isSummer);
					System.out.println("Result: " + object3.squirrelPlay());
					break;
				default:
					System.out.println("Wrong entry! You did not enter t or f");
					break;
				}
				break;
			case 3:
				System.out.println("Enter the first lottery number: ");
				in2 = new Scanner(System.in);
				int num1 = in2.nextInt();
				System.out.println("Enter the second lottery number: ");
				in3 = new Scanner(System.in);
				int num2 = in3.nextInt();
				System.out.println("Enter the third lottery number: ");
				Scanner in4 = new Scanner(System.in);
				int num3 = in4.nextInt();
				object2 = new LotteryTicket(num1, num2, num3);
				System.out.println("Result: " + object2.greenTicket());
				break;
			case 4:
				System.out.println("Enter a word: ");
				in2 = new Scanner(System.in);
				String word = in2.next().toLowerCase();
				object4 =  new XXFinder(word);
				System.out.println("There are " + object4.countXX() + " Xs in " + word);
				break;
			case 5:
				System.out.println("Enter a word: ");
				in2 = new Scanner(System.in);
				word = in2.next();
				System.out.println("How many times do you want to repeat the word?: ");
				in3 = new Scanner(System.in);
				int num = in3.nextInt();
				object5 =  new StringRepeater(word, num);
				System.out.println("Result: " + object5.stringTimes());
				break;
			case 6:
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
