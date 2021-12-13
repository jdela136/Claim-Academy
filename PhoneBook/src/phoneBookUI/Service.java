package phoneBookUI;
import java.util.*;
import javax.swing.*;

import phoneBook.*;

public class Service {

	private Repository p1;
	private SystemOutputter a;
	private JOutputter b;
	private JInputter i;
	//private IInputter i;
	
	public Service() {
		p1 = new Repository();
		a = new SystemOutputter();
		b = new JOutputter();
		i = new JInputter();
		//i = new Inputter();
		//o = new Outputter();
	}
	
	public void runMenu() throws InputMismatchException {
		
		boolean continueRun = true;
			do {
				JList list = new JList(new String[] {"Add a new record", "Delete a record", "Update a record","Search for records"
						,"View all records", "Quit"});
				JOptionPane.showMessageDialog(
				  null, list, "PhoneBook Menu", JOptionPane.PLAIN_MESSAGE);
				
				
//				o.printLine("\t\t\tPhoneBook Menu\n------------------------------------------------------"
//						+ "\n1: Add a new record\n2: Delete a record \n3: Update a record"
//						+ "\n4: Search for records\n5: View all records\n6: Quit");
				
				//int choice = i.getIntegerInput();
				int choice = list.getSelectedIndex() + 1;
				
				switch(choice) {
				case 0:
					b.printLine("Good Bye!");
					continueRun = false;
					break;
				case 1:
					
					try {
//					o.printLine("Enter the First Name: ");
//					String firstName = i.getStringLineInput();
					String firstName = i.getStringInput("Enter the First Name: ");
					
//					o.printLine("Enter the Last Name: ");					
//					String lastName = i.getStringLineInput();
					String lastName = i.getStringLineInput("Enter the Last Name: ");
					
//					o.printLine("Enter the Phone Number: ");					
//					long number = i.getLongInput();
					long number = i.getLongInput("Enter the Phone Number: ");
					
//					o.printLine("Enter a Street Address");					
//					String street = i.getStringLineInput();
					String street = i.getStringLineInput("Enter a Street Address");
					
//					o.printLine("Enter a City");					
//					String city = i.getStringLineInput();
					String city = i.getStringLineInput("Enter a City");
					
//					o.printLine("Enter a State");					
//					String state = i.getStringLineInput();
					String state = i.getStringLineInput("Enter a State");
					
//					o.printLine("Enter a Zip Code");					
//					int zip = i.getIntegerInput();
					int zip = i.getIntegerInput("Enter a Zip Code");
					
					//Address addy = new Address(street, city, state, zip);

					//Person entry = new Person(firstName, lastName, number, addy);
					p1.addPerson(firstName, lastName, number, street, city, state, zip);
					b.printLine(p1.searchByTelephoneNumber(number).getFirstName()
							+ " " + p1.searchByTelephoneNumber(number).getLastName() + " has been Successfully added!");
					}
					catch(NullPointerException e3) {
						b.printLine("Error! One of your imputs were empty!");
					}
					catch(InputMismatchException e) {
						b.printLine("Error! One of your entries was in an incorrect format!");
					}
					catch(NumberFormatException e2) {
						b.printLine("Error! Input must be a number!");
					}
					break;
				case 2:
					try {
//					o.printLine("Enter the phone number for the person you would like to delete");					
//					number = i.getLongInput();
					long number = i.getLongInput("Enter the phone number for the person you would like to delete");
					
					Person searched = p1.searchByTelephoneNumber(number);
//					o.printLine("Would you like to delete " + searched.getFirstName() + " " + searched.getLastName() 
//					+ "? (Enter) Y or N");					
//					String choice2 = i.getStringLineInput().toLowerCase();
					String choice2 = i.getStringLineInput("Would you like to delete " + searched.getFirstName() + " " + searched.getLastName() 
					+ "? (Enter) Y or N").toLowerCase();
					
					switch(choice2) {
					case "y":
						p1.deleteARecord(number);
						b.printLine(searched.getFirstName() + " " + searched.getLastName() + " has been deleted!");
						break;
					case "n":
						b.printLine(searched.getFirstName() + " " + searched.getLastName() + " will not be deleted.");
						break;
					default:
						throw new InputMismatchException();
					}
					}
					catch(NullPointerException e3) {
						b.printLine(e3.getMessage());
					}
					catch(InputMismatchException e) {
						b.printLine("Error! One of your entries was in an incorrect format!");
					}
					catch(NumberFormatException e2) {
						b.printLine("Error! Input must be a number!");
					}
					break;
				case 3:
					try {
//					o.printLine("Enter the Phone Number: ");					
//					number = i.getLongInput();
					long number = i.getLongInput("Enter the Phone Number: ");
					
					Person searched = p1.searchByTelephoneNumber(number);
//					o.printLine("Would you like to update " + searched.getFirstName() + " " + searched.getLastName() 
//					+ "? (Enter) Y or N");					
//					choice2 = i.getStringLineInput().toLowerCase();
					String choice2 = i.getStringLineInput("Would you like to update " + searched.getFirstName() + " " + searched.getLastName() 
					+ "? (Enter) Y or N").toLowerCase();
					
					switch(choice2) {
					case "y":
						
						JList list3 = new JList(new String[] {"Full Name", "Phone Number","Address"});
						JOptionPane.showMessageDialog(
						  null, list3, "What would you like to update?", JOptionPane.PLAIN_MESSAGE);
						
						
						//o.printLine("What would you like to update?\n1: Full Name\n2: Phone Number\n3: Address");
						
						
						//int choice3 = i.getIntegerInput();
						int choice3 = list3.getSelectedIndex() + 1;
						
						switch(choice3) {
//						case 0:
//							b.printLine("Good Bye!");
//							continueRun = false;
//							break;
						case 1:
//							o.printLine("Enter the First Name: ");							
//							firstName = i.getStringLineInput();
							String firstName = i.getStringLineInput("Enter the First Name: ");
							
//							o.printLine("Enter the Last Name: ");							
//							lastName = i.getStringLineInput();
							String lastName = i.getStringLineInput("Enter the Last Name: ");
							
							p1.updateName(firstName, lastName, number);
							b.printLine(searched.getFirstName() + " " + searched.getLastName() + "has been updated!");
							break;
						case 2:
//							o.printLine("Enter the new Phone Number: ");							
//							long newNumber = i.getLongInput();
							long newNumber = i.getLongInput("Enter the new Phone Number: ");
							
							p1.updateNumber(newNumber, number);
							b.printLine(searched.getFirstName() + " " + searched.getLastName() + " has been updated!");
							break;
						case 3:
//							o.printLine("Enter the Street Address: ");							
//							street = i.getStringLineInput();
							String street = i.getStringLineInput("Enter the Street Address: ");
							
//							o.printLine("Enter the City: ");							
//							city = i.getStringLineInput();
							String city = i.getStringLineInput("Enter the City: ");
							
//							o.printLine("Enter the State: ");						
//							state = i.getStringLineInput();
							String state = i.getStringLineInput("Enter the State: ");
							
//							o.printLine("Enter the Zip Code: ");							
//							zip = i.getIntegerInput();
							int zip = i.getIntegerInput("Enter the Zip Code: ");
							
							p1.updateAddress(street, city, state, zip, number);
							b.printLine(searched.getFirstName() + " " + searched.getLastName() + " has been updated!");
							break;
//						default:
//							o.printLine("Invalid Entry!");
//							break;
						}
						break;
					case "n":
						b.printLine(searched.getFirstName() + " " + searched.getLastName() + " will not be updated.");
						break;
					default:
						throw new InputMismatchException();
					}
					}
					catch(NullPointerException e3) {
						b.printLine(e3.getMessage());
					}
					catch(InputMismatchException e) {
						b.printLine("Error! One of your entries was in an incorrect format!");
					}
					catch(NumberFormatException e2) {
						b.printLine("Error! Input must be a number!");
					}
					break;
				case 4:
					try {
					JList list2 = new JList(new String[] {"Search By First Name", "Search By Last Name", "Search By Full Name",
							"Search By Phone Number","Search By City", "Search By State"});
					JOptionPane.showMessageDialog(
					  null, list2, "PhoneBook Menu", JOptionPane.PLAIN_MESSAGE);
					
//					o.printLine("Please choose a search option\n1: Search By First Name"
//							+ "\n2: Search By Last Name"
//							+ "'n3: Search By Full Name"
//							+ "\n4: Search By Phone Number"
//							+ "\n5: Search By City"
//							+ "\n6: Search By State");
					
					
					//int choice3 = i.getIntegerInput();
					int choice3 = list2.getSelectedIndex() + 1;
					
					switch(choice3) {
					case 1:
//						o.printLine("Enter the First Name: ");						
//						firstName = i.getStringLineInput();
						String firstName = i.getStringLineInput("Enter the First Name: ");
						
						Person[] people  = p1.searchByFirstName(firstName);
						p1.printRecords(people, a);
						break;
					case 2:
//						o.printLine("Enter the Last Name: ");						
//						lastName = i.getStringLineInput();
						String lastName = i.getStringLineInput("Enter the Last Name: ");
						
						people  = p1.searchByLastName(lastName);
						p1.printRecords(people, a);
						break;
					case 3:
//						o.printLine("Enter the First Name: ");						
//						firstName = i.getStringLineInput();
						firstName = i.getStringLineInput("Enter the First Name: ");
						
//						o.printLine("Enter the Last Name: ");						
//						lastName = i.getStringLineInput();
						lastName = i.getStringLineInput("Enter the Last Name: ");
						
						people = p1.searchByFullName(firstName, lastName);
						p1.printRecords(people, a);
						break;
					case 4:
//						o.printLine("Enter the Phone Number: ");						
//						number = i.getLongInput();
						long number = i.getLongInput("Enter the Phone Number: ");
						
						Person entry  = p1.searchByTelephoneNumber(number);
						b.printLine(entry.getPerson());
						break;
					case 5:
//						o.printLine("Enter the City: ");						
//						city = i.getStringLineInput();
						String city = i.getStringLineInput("Enter the City: ");
						
						people  = p1.searchByCity(city);
						p1.printRecords(people, a);
						break;
					case 6:
//						o.printLine("Enter the State: ");						
//						state = i.getStringLineInput();
						String state = i.getStringLineInput("Enter the State: ");
						
						people  = p1.searchByState(state);
						p1.printRecords(people, a);
						break;
//					default:
//						throw new InputMismatchException();
					}
					}
					catch(NullPointerException e3) {
						b.printLine(e3.getMessage());
					}
					catch(InputMismatchException e) {
						b.printLine("Error! One of your entries was in an incorrect format!");
					}
					catch(NumberFormatException e2) {
						b.printLine("Error! Input must be a number!");
					}
					break;
				case 5:
					try {
					JList list2 = new JList(new String[] {"First Name", "Last Name", "Phone Number",
							"Street Address","City", "State","Zip Code"});
					JOptionPane.showMessageDialog(
					  null, list2, "Please choose a sorting option", JOptionPane.PLAIN_MESSAGE);
					
					
//					o.printLine("Please choose a sorting option");
//					o.printLine("1: First Name");
//					o.printLine("2: Last Name");
//					o.printLine("3: Phone Number");
//					o.printLine("4: Street Address");
//					o.printLine("5: City");
//					o.printLine("6: State");
//					o.printLine("7: Zip Code");
					
					
					//choice3 = i.getIntegerInput();
					int choice3 = list2.getSelectedIndex() + 1;
					
					switch(choice3) {
//					case 0:
//						b.printLine("Good Bye!");
//						continueRun = false;
//						break;
					case 1:
						p1.sortByFirstName();
						p1.printRecords(p1.getPhoneBook().getPhoneBookEntries(), a);
						break;
					case 2:
						p1.sortByLastName();
						p1.printRecords(p1.getPhoneBook().getPhoneBookEntries(), a);
						break;
					case 3:
						p1.sortByPhoneNumber();
						p1.printRecords(p1.getPhoneBook().getPhoneBookEntries(), a);
						break;
					case 4:
						p1.sortByStreetAddress();
						p1.printRecords(p1.getPhoneBook().getPhoneBookEntries(), a);
						break;
					case 5:
						p1.sortByCity();
						p1.printRecords(p1.getPhoneBook().getPhoneBookEntries(), a);
						break;
					case 6:
						p1.sortByState();
						p1.printRecords(p1.getPhoneBook().getPhoneBookEntries(), a);
						break;
					case 7:
						p1.sortByZipCode();
						p1.printRecords(p1.getPhoneBook().getPhoneBookEntries(), a);
						break;
//					default:
//						throw new InputMismatchException();
					}
					}
					catch(NullPointerException e3) {
						b.printLine(e3.getMessage());
					}
					catch(InputMismatchException e) {
						b.printLine("Error! One of your entries was in an incorrect format!");
					}
					catch(NumberFormatException e2) {
						b.printLine("Error! Input must be a number!");
					}
					break;
				case 6:
					b.printLine("Good Bye!");
					continueRun = false;
					break;

//				default:
//					throw new InputMismatchException();
				}
			}
			while(continueRun);
		}
	
 
}
