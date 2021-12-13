package phoneBookUI;
import java.util.Scanner;

import phoneBook.*;

public class ScanInputter implements IInputter{
	
	private Scanner in;
	
	@Override
	public String getStringInput() {
		in = new Scanner(System.in);
		return in.next();
	}
	
	@Override
	public String getStringLineInput() {
		in = new Scanner(System.in);
		return in.nextLine();
	}
	

	@Override
	public int getIntegerInput() {
		in = new Scanner(System.in);
		return in.nextInt();
	}

	@Override
	public long getLongInput() {
		in = new Scanner(System.in);
		return in.nextLong();
	}
	
}
