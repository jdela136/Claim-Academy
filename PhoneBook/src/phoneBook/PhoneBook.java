package phoneBook;

public class PhoneBook {
	Person[] entries;
	
	public PhoneBook() {
		entries = new Person[0];
	}
	
	public Person[] getPhoneBookEntries() {
		return entries;
	}
	
	public void setPhoneBookEntries(Person[] entries) {
		this.entries = entries;
	}
}
