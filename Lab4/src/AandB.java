
public class AandB {
	private int a;
	private int b;
	public AandB(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int sumLimit() {
		if(a > 0 && b > 0) {
			String sumString = Integer.toString(a + b);
			String aString = Integer.toString(a);
			if(sumString.length() > aString.length()) {
				return a;
			}
			else {
				return a + b;
			}
		}
		else {
			throw new IllegalArgumentException("Numbers cannot be less than 0");
		}
	}
}
