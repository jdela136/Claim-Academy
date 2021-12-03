
public class LotteryTicket {
	private int numA;
	private int numB;
	private int numC;
	
	public LotteryTicket(int numA, int numB, int numC) {
		this.numA = numA;
		this.numB = numB;
		this.numC = numC;
	}
	
	public int greenTicket() {
	
	if(numA != numB && numA != numC && numB != numC) {
		return 0;
	}
	else if(numA == numB && numA == numC && numB == numC) {
		return 20;
	}
	else {
		return 10;
	}
}
}
