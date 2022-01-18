package statTracker;

public class Pitch {
	
	private int id;
	private  int balls;
	private  int strikes;
	
	public Pitch() {}
	
	public Pitch(int balls, int strikes) {
		this.balls = balls;
		this.strikes = strikes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalls() {
		return balls;
	}

	public void setBalls(int balls) {
		this.balls = balls;
	}

	public int getStrikes() {
		return strikes;
	}

	public void setStrikes(int strikes) {
		this.strikes = strikes;
	}
	

	@Override
	public String toString() {
		return "Id: " + id + " Balls: " + balls + " Strikes " + strikes;
	}

}
