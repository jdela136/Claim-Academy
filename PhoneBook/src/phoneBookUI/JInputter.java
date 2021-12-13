package phoneBookUI;
import phoneBook.*;
import javax.swing.*;

public class JInputter implements IInputter{
	
	@Override
	public String getStringInput() {
		return JOptionPane.showInputDialog("Make your entry here");
	}
	public String getStringInput(String prompt) {
		return JOptionPane.showInputDialog(prompt);
	}

	@Override
	public String getStringLineInput() {
		return JOptionPane.showInputDialog("Make your entry here");
	}
	
	public String getStringLineInput(String prompt) {
		return JOptionPane.showInputDialog(prompt);
	}

	@Override
	public int getIntegerInput() {
		String in = JOptionPane.showInputDialog("Make your entry here");
		return Integer.parseInt(in);
	}
	
	public int getIntegerInput(String prompt) {
		String in = JOptionPane.showInputDialog(prompt);
		return Integer.parseInt(in);
	}

	@Override
	public long getLongInput() {
		String in = JOptionPane.showInputDialog("Make your entry here");
		return Long.parseLong(in);
	}
	
	public long getLongInput(String prompt) {
		String in = JOptionPane.showInputDialog(prompt);
		return Long.parseLong(in);
	}
}
