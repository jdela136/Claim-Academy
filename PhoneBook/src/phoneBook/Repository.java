package phoneBook;

import java.util.InputMismatchException;

import phoneBookUI.SystemOutputter;

public class Repository implements IRepository {

	// Create an array of customers
	PhoneBook p;

	public Repository() {
		p = new PhoneBook();
	}

	// Add a customer to the array
	public void addPerson(Person entry) {

		// create temporary array that is one slot larger than the current array
		Person[] tempArray = new Person[p.getPhoneBookEntries().length + 1];

		// add customers from the original array to the temporary array.
		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			tempArray[i] = p.getPhoneBookEntries()[i];
		}

		// adds the new customer to the end of the temp array
		tempArray[tempArray.length - 1] = entry;

		// reset the original array to the new one
		p.setPhoneBookEntries(tempArray);
	}
	
	public void addPerson(String firstName, String lastName, long phoneNumber, Address address) {
		Person entry = new Person();
		entry.setFirstName(firstName);
		entry.setLastName(lastName);
		entry.setPhoneNumber(phoneNumber);
		entry.setAddress(address);
		
		// create temporary array that is one slot larger than the current array
		Person[] tempArray = new Person[p.getPhoneBookEntries().length + 1];

		// add customers from the original array to the temporary array.
		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			tempArray[i] = p.getPhoneBookEntries()[i];
		}

		// adds the new customer to the end of the temp array
		tempArray[tempArray.length - 1] = entry;

		// reset the original array to the new one
		p.setPhoneBookEntries(tempArray);
	}
	
	public void addPerson(String firstName, String lastName, long phoneNumber, String street, String city, String state, int zip) {
		Person entry = new Person();
		entry.setFirstName(firstName);
		entry.setLastName(lastName);
		entry.setPhoneNumber(phoneNumber);
		Address a = new Address();
		entry.setAddress(a);
		entry.getAddress().setStreet(street);
		entry.getAddress().setCity(city);
		entry.getAddress().setState(state);
		entry.getAddress().setZipCode(zip);
		
		// create temporary array that is one slot larger than the current array
		Person[] tempArray = new Person[p.getPhoneBookEntries().length + 1];

		// add customers from the original array to the temporary array.
		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			tempArray[i] = p.getPhoneBookEntries()[i];
		}

		// adds the new customer to the end of the temp array
		tempArray[tempArray.length - 1] = entry;

		// reset the original array to the new one
		p.setPhoneBookEntries(tempArray);
	}

	public PhoneBook getPhoneBook() {
		return p;
	}

	// print directory
	public void printRecords(Person[] people, IOutputter o) {
		if (people.length == 0) {
			throw new NullPointerException("There are no entries");
		}
		o.printLine("\t\t\tPhoneBook Records");
		o.printLine("------------------------------------------------------");
		for (int i = 0; i < people.length; i++) {
			o.printLine(people[i].getPerson());
		}
		
		o.printLine("");
		o.printLine("");
	}

	public Person[] searchByFirstName(String firstName) {

		if (p.getPhoneBookEntries().length == 0) {
			throw new NullPointerException("There are no entries");
		}

		int count = 0;

		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			if (p.getPhoneBookEntries()[i].getFirstName().toLowerCase().equals(firstName.toLowerCase())) {
				count++;
			}
		}

		Person[] temp = new Person[count];

		int entryIndex = 0;
		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			if (p.getPhoneBookEntries()[i].getFirstName().toLowerCase().equals(firstName.toLowerCase())) {
				temp[entryIndex] = p.getPhoneBookEntries()[i];
				entryIndex++;
			}
		}

		return temp;
	}

	public Person[] searchByLastName(String lastName) {
		if (p.getPhoneBookEntries().length == 0) {
			throw new NullPointerException("There are no entries");
		}

		int count = 0;

		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			if (p.getPhoneBookEntries()[i].getLastName().toLowerCase().equals(lastName.toLowerCase())) {
				count++;
			}
		}

		Person[] temp = new Person[count];

		int entryIndex = 0;
		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			if (p.getPhoneBookEntries()[i].getLastName().toLowerCase().equals(lastName.toLowerCase())) {
				temp[entryIndex] = p.getPhoneBookEntries()[i];
				entryIndex++;
			}
		}

		return temp;
	}

	public Person[] searchByFullName(String firstName, String lastName) {

		if (p.getPhoneBookEntries().length == 0) {
			throw new NullPointerException("There are no entries");
		}

		int count = 0;

		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			if (p.getPhoneBookEntries()[i].getFirstName().toLowerCase().equals(firstName.toLowerCase())
					&& p.getPhoneBookEntries()[i].getLastName().toLowerCase().equals(lastName.toLowerCase())) {
				count++;
			}
		}

		Person[] temp = new Person[count];

		int entryIndex = 0;
		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			if (p.getPhoneBookEntries()[i].getFirstName().toLowerCase().equals(firstName.toLowerCase())
					&& p.getPhoneBookEntries()[i].getLastName().toLowerCase().equals(lastName.toLowerCase())) {
				temp[entryIndex] = p.getPhoneBookEntries()[i];
				entryIndex++;
			}
		}

		return temp;
	}

	public Person searchByTelephoneNumber(long number) {

		if (p.getPhoneBookEntries().length == 0) {
			throw new NullPointerException("There are no entries");
		}

		Person temp = new Person();
		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			if (p.getPhoneBookEntries()[i].getPhoneNumber() == number) {
				temp = p.getPhoneBookEntries()[i];
			}
		}
		return temp;
	}

	public Person[] searchByCity(String city) {

		if (p.getPhoneBookEntries().length == 0) {
			throw new NullPointerException("There are no entries");
		}

		int count = 0;

		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			if (p.getPhoneBookEntries()[i].getAddress().getCity().toLowerCase().equals(city.toLowerCase())) {
				count++;
			}
		}

		Person[] temp = new Person[count];

		int entryIndex = 0;
		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			if (p.getPhoneBookEntries()[i].getAddress().getCity().toLowerCase().equals(city.toLowerCase())) {
				temp[entryIndex] = p.getPhoneBookEntries()[i];
				entryIndex++;
			}
		}

		return temp;
	}

	public Person[] searchByState(String state) {

		if (p.getPhoneBookEntries().length == 0) {
			throw new NullPointerException("There are no entries");
		}

		int count = 0;

		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			if (p.getPhoneBookEntries()[i].getAddress().getState().toLowerCase().equals(state.toLowerCase())) {
				count++;
			}
		}

		Person[] temp = new Person[count];

		int entryIndex = 0;
		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			if (p.getPhoneBookEntries()[i].getAddress().getState().toLowerCase().equals(state.toLowerCase())) {
				temp[entryIndex] = p.getPhoneBookEntries()[i];
				entryIndex++;
			}
		}

		return temp;
	}

	public void deleteARecord(long number) {
		if (p.getPhoneBookEntries().length == 0) {
			throw new NullPointerException("There are no entries");
		}

		Person[] temp = new Person[p.getPhoneBookEntries().length - 1];
		int j = 0;
		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			if (p.getPhoneBookEntries()[i].getPhoneNumber() != number) {
				temp[j] = p.getPhoneBookEntries()[i];
				j++;
			}
		}
		p.setPhoneBookEntries(temp);
	}

	public void updateName(String firstName, String lastName, long number) {

		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			if (p.getPhoneBookEntries()[i].getPhoneNumber() == number) {
				p.getPhoneBookEntries()[i].setFirstName(firstName);
				p.getPhoneBookEntries()[i].setLastName(lastName);
			}
		}
	}

	public void updateNumber(long newNumber, long oldNumber) {
		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			if (p.getPhoneBookEntries()[i].getPhoneNumber() == oldNumber) {
				p.getPhoneBookEntries()[i].setPhoneNumber(newNumber);
			}
		}
	}

	public void updateAddress(String street, String city, String state, int zipCode, long number) {
		if (p.getPhoneBookEntries().length == 0) {
			throw new NullPointerException("There are no entries");
		}

		Address temp = new Address(street, city, state, zipCode);

		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			if (p.getPhoneBookEntries()[i].getPhoneNumber() == number) {
				p.getPhoneBookEntries()[i].setAddress(temp);
			}
		}
	}

	public void sortByFirstName() {
		if (p.getPhoneBookEntries().length == 0) {
			throw new NullPointerException("There are no entries");
		}

		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			for (int j = i + 1; j < p.getPhoneBookEntries().length; j++) {
				if (p.getPhoneBookEntries()[i].getFirstName()
						.compareTo(p.getPhoneBookEntries()[j].getFirstName()) > 0) {
					Person temp = new Person();
					temp = p.getPhoneBookEntries()[i];
					p.getPhoneBookEntries()[i] = p.getPhoneBookEntries()[j];
					p.getPhoneBookEntries()[j] = temp;
				}
			}
		}
	}

	public void sortByLastName() {
		if (p.getPhoneBookEntries().length == 0) {
			throw new NullPointerException("There are no entries");
		}

		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			for (int j = i + 1; j < p.getPhoneBookEntries().length; j++) {
				if (p.getPhoneBookEntries()[i].getLastName().compareTo(p.getPhoneBookEntries()[j].getLastName()) > 0) {
					Person temp = new Person();
					temp = p.getPhoneBookEntries()[i];
					p.getPhoneBookEntries()[i] = p.getPhoneBookEntries()[j];
					p.getPhoneBookEntries()[j] = temp;
				}
			}
		}
	}

	public void sortByPhoneNumber() {
		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			for (int j = i + 1; j < p.getPhoneBookEntries().length; j++) {
				// check
				if (p.getPhoneBookEntries()[i].getPhoneNumber() > p.getPhoneBookEntries()[j].getPhoneNumber()) {
					Person temp = new Person();
					temp = p.getPhoneBookEntries()[i];
					p.getPhoneBookEntries()[i] = p.getPhoneBookEntries()[j];
					p.getPhoneBookEntries()[j] = temp;
				}
			}
		}
	}

	public void sortByStreetAddress() {
		if (p.getPhoneBookEntries().length == 0) {
			throw new NullPointerException("There are no entries");
		}

		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			for (int j = i + 1; j < p.getPhoneBookEntries().length; j++) {
				if (p.getPhoneBookEntries()[i].getAddress().getStreet()
						.compareTo(p.getPhoneBookEntries()[j].getAddress().getStreet()) > 0) {
					Person temp = new Person();
					temp = p.getPhoneBookEntries()[i];
					p.getPhoneBookEntries()[i] = p.getPhoneBookEntries()[j];
					p.getPhoneBookEntries()[j] = temp;
				}
			}
		}
	}

	public void sortByCity() {
		if (p.getPhoneBookEntries().length == 0) {
			throw new NullPointerException("There are no entries");
		}

		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			for (int j = i + 1; j < p.getPhoneBookEntries().length; j++) {
				if (p.getPhoneBookEntries()[i].getAddress().getCity()
						.compareTo(p.getPhoneBookEntries()[j].getAddress().getCity()) > 0) {
					Person temp = new Person();
					temp = p.getPhoneBookEntries()[i];
					p.getPhoneBookEntries()[i] = p.getPhoneBookEntries()[j];
					p.getPhoneBookEntries()[j] = temp;
				}
			}
		}
	}

	public void sortByState() {
		if(p.getPhoneBookEntries().length == 0) {
			throw new NullPointerException("There are no entries");
		}
		
		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			for (int j = i + 1; j < p.getPhoneBookEntries().length; j++) {
				if (p.getPhoneBookEntries()[i].getAddress().getState()
						.compareTo(p.getPhoneBookEntries()[j].getAddress().getState()) > 0) {
					Person temp = new Person();
					temp = p.getPhoneBookEntries()[i];
					p.getPhoneBookEntries()[i] = p.getPhoneBookEntries()[j];
					p.getPhoneBookEntries()[j] = temp;
				}
			}
		}
	}

	public void sortByZipCode() {
		if (p.getPhoneBookEntries().length == 0) {
			throw new NullPointerException("There are no entries");
		}

		for (int i = 0; i < p.getPhoneBookEntries().length; i++) {
			for (int j = i + 1; j < p.getPhoneBookEntries().length; j++) {
				Person temp = new Person();
				if (p.getPhoneBookEntries()[i].getAddress().getZipCode() > p.getPhoneBookEntries()[j].getAddress()
						.getZipCode()) {
					temp = p.getPhoneBookEntries()[i];
					p.getPhoneBookEntries()[i] = p.getPhoneBookEntries()[j];
					p.getPhoneBookEntries()[j] = temp;
				}
			}
		}
	}
}
