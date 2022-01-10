package statTracker;

public class Pitch {
	
	private int id;
	private static int balls;
	private static int strikes;
	
	public Pitch() {
		balls = 1;
		strikes = 1;
	}
	
	public Pitch(int balls, int strikes) {
		Pitch.balls = balls;
		Pitch.strikes = strikes;
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
		Pitch.balls = balls;
	}

	public int getStrikes() {
		return strikes;
	}

	public void setStrikes(int strikes) {
		Pitch.strikes = strikes;
	}

}
