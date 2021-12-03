
public class StringRepeater {
	private String word;
	private int n;
	
	public StringRepeater(String word, int n) {
		this.word = word;
		this.n = n;
	}
	
	
	public String stringTimes() {
	
	String temp = "";

	for (int i = 0; i < n; i++)

		temp += word;

	return temp;

}
}
