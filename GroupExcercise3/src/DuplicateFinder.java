
public class DuplicateFinder {
	
	private char[] arr;
	
	public DuplicateFinder(char[] arr) {
		this.arr = arr;
	}
	
	public char[] findDuplicates() { 
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			int duplicate = 0;
			for(int j = 0; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					duplicate++;
				}
			}
			if(duplicate > 1) {
				count++;
			}
		}
		char[] tempArray = new char[count];
		int index = 0;
		for(int i = 0; i < arr.length; i++) {
			int duplicate = 0;
			for(int j = 0; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					duplicate++;
				}
			}
			if(duplicate > 1) {
				tempArray[index] = arr[i];
				index++;
			}
		}
		return tempArray;
	}
	
	public void printArray(char[] arr) {
		System.out.println("Result: ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
 }
