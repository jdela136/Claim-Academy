package phoneBook;

import java.util.*;

public class Address {
	private String street;
	private String city;
	private String state;
	private int zipCode;
	
	public Address() {}
	
	public Address(String street, String city, String state, int zipCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		if(street.length() == 0) {
			throw new NullPointerException("No input entered");
		}
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		if(city.length() == 0) {
			throw new NullPointerException("No input entered");
		}
		for(int i = 0 ; i < city.length(); i++) {
			if(!((city.charAt(i) >= 65 && city.charAt(i) <= 90) 
					|| (city.charAt(i) >= 90 && city.charAt(i) <= 122) || city.charAt(i) == 32)) {
				throw new InputMismatchException("Input must be a letter");
			}
		}
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		if(state.length() == 0) {
			throw new NullPointerException("No input entered");
		}
		for(int i = 0 ; i < state.length(); i++) {
			if(!((state.charAt(i) >= 65 && state.charAt(i) <= 90) 
					|| (state.charAt(i) >= 90 && city.charAt(i) <= 122) || state.charAt(i) == 32)) {
				throw new InputMismatchException("Input must be a letter");
			}
		}
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		if(Integer.toString(zipCode).length() < 5) {
			throw new InputMismatchException("Input must have 5 or more numbers");
		}
		this.zipCode = zipCode;
	}


	@Override
	public String toString() {
		return street + ", " + city + ", " + state + ", " + zipCode;
	}
	
	
	
}

