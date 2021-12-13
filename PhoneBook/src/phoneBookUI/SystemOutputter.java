package phoneBookUI;
import phoneBook.*;

public class SystemOutputter implements IOutputter{

	@Override
	public void print(String s) {
		System.out.print(s);
		
	}

	@Override
	public void printLine(String s) {
		System.out.println(s);		
	}

}
