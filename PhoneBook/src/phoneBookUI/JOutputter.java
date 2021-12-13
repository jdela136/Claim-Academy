package phoneBookUI;
import phoneBook.*;

import javax.swing.*;

public class JOutputter implements IOutputter{

	@Override
	public void print(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	@Override
	public void printLine(String s) {
		JOptionPane.showMessageDialog(null, s);
	}
	
}
