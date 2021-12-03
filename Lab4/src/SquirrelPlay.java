
public class SquirrelPlay {
	private int temp;
	private boolean isSummer;
	
	public SquirrelPlay(int temp, boolean isSummer) {
		this.temp = temp;
		this.isSummer = isSummer;
	}
	
	public boolean squirrelPlay() {
	
	if(isSummer) {
		if(temp > 60 && temp < 100) {
			return true;
		}
		else {
			return false;
		}
	}
	else {
		if(temp > 60 && temp < 90) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
}
