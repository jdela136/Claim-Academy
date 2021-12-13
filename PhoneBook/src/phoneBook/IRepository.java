package phoneBook;

public interface IRepository {
	PhoneBook p = new PhoneBook();
	
	public PhoneBook getPhoneBook();
	
	public void addPerson(Person entry);
	
	// print directory
	public void printRecords(Person[] people, IOutputter o);
	
	public Person[] searchByFirstName(String firstName);
	
	public Person[] searchByLastName(String lastName);
	
	public Person[] searchByFullName(String firstName, String lastName);
	
	public Person searchByTelephoneNumber(long number);
	
	public Person[] searchByCity(String city);
	
	public Person[] searchByState(String state);
	
	public void deleteARecord(long number);
	
	public void updateName(String firstName, String lastName, long number);
	
	public void updateNumber(long newNumber, long oldNumber);
	
	public void updateAddress(String street, String city, String state, int zipCode, long number);
	
	public void sortByFirstName();
	
	public void sortByLastName();
	
	public void sortByPhoneNumber();
	
	public void sortByStreetAddress();
	
	public void sortByCity();
	
	public void sortByState();
	
	public void sortByZipCode();
}
