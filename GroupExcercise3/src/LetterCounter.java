
public class LetterCounter {
	private char[] word;

	public LetterCounter(char[] word) {

		this.word = word;
	}

	public int  countLetter() {

		int count = 0;
		for(int i = 0; i < word.length; i++) {
			if(word[i] == 'a') {
				count++;
			}
		}
		return count;
	}
}
