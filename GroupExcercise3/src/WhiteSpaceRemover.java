
public class WhiteSpaceRemover {

	private char[] arr;

	public WhiteSpaceRemover(char[] arr) {
		this.arr = arr;

	}

	public char[] removeWhiteSpace() {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == ' ') {
				count++;
			}
		}
	
		char[] tempArr = new char[arr.length - count];
		int index = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != ' ') {
				tempArr[index] = arr[i];
				index++;
			}
		}

		return tempArr;

	}
}
