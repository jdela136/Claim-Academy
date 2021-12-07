
public class StringReverser {
	
	private String phrase;
	
	public StringReverser(String phrase) {
		this.phrase = phrase;
	}
	
	public String[] reverseString() {
//		String one = "Deon Colvin";
		
		//Count the white space ex- 1
		int count = countWhiteSpace();
		
		//blank String array with size white space + 1  ex-2
		// words[2] = {"Colvin","Deon"}
		String[] words = new String[count + 1];
		
		//keeping track of white space index
		int whiteSpaceIndex = 0;
		//keeps track white space count
		count = 0;
		
		// i starts at 0
		// i increments by 1
		// i is smaller than 11
		// 0 1 2 3 4 5 6 7 8 9 10
		for(int i = 0; i < phrase.length(); i++) {
			//placeholder for future word we'll add to array
			String word = "";
			//if phrase[5] C
			if(phrase.charAt(i) == ' ') {
				if(whiteSpaceIndex == 0) {
					//word = Deon
					word = phrase.substring(0, i);
					//words[1] = Deon
					words[words.length - 1] = word;
				}
				else{
					word = phrase.substring(whiteSpaceIndex + 1, i);
					words[count] = word;
				}
				//count = 1
				count++;
				//index = 4
				whiteSpaceIndex = i;
			}
			// if 10 is 10
			if(i == phrase.length()-1) {
				//word = Colvin
				word = phrase.substring(whiteSpaceIndex + 1, i + 1);
				words[0] = word;
			}
		}
		return words;
	}
	
	public int countWhiteSpace() {
		int count = 0;
		for(int i = 0; i < phrase.length(); i++) {
			if(phrase.charAt(i) == ' ') {
				count++;
			}
		}
		return count;
	}
	
	public void printArray(String[] arr) {
		System.out.println("Reversed Phrase: ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
