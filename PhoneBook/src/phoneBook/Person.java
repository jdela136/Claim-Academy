
package phoneBook;
import java.util.*;
public class Person {
	
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private Address address;
	
	public Person() {}


	public Person(String firstName, String lastName, long phoneNumber, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName.length() == 0) {
			throw new NullPointerException("No input entered");
		}
		for(int i = 0 ; i < firstName.length(); i++) {
			if(!((firstName.charAt(i) >= 65 && firstName.charAt(i) <= 90) 
					|| (firstName.charAt(i) >= 90 && firstName.charAt(i) <= 122) || firstName.charAt(i) == 32)) {
				throw new InputMismatchException("Input must be a letter");
			}
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName.length() == 0) {
			throw new NullPointerException("No input entered");
		}
		for(int i = 0 ; i < lastName.length(); i++) {
			if(!((lastName.charAt(i) >= 65 && lastName.charAt(i) <= 90) 
					|| (lastName.charAt(i) >= 90 && lastName.charAt(i) <= 122) || lastName.charAt(i) == 32)) {
				throw new InputMismatchException("Input must be a letter");
			}
		}
		this.lastName = lastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		if(Long.toString(phoneNumber).length() < 10) {
			throw new InputMismatchException("Input must have 10 or more numbers");
		}
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void setAddress(String street, String city, String state, int zipCode) {
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZipCode(zipCode);
	}


	public String getPerson() {
		return firstName + " " + lastName + ", " + address.toString() + ", " + phoneNumber;
	}
	
	
	

}

