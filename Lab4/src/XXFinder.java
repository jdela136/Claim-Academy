
public class XXFinder {
	private String xx;
	
	public XXFinder(String xx) {
		this.xx = xx;
	}
	
	
	public int countXX() {
	
		int count= 0;
	
		for(int i = 0; i < xx.length(); i++) {
			if(xx.charAt(i) == 'x') {
			count++;
			}
		}
		return count;
	}
}
