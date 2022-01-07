package statTracker;

public class Pitch {
	
	private int id;
	private static int balls;
	private static int strikes;
	private boolean ballInPlay;
	
	public Pitch() {
		balls = 1;
		strikes = 1;
		ballInPlay = false;
	}
	
//	public Pitch(int balls, int strikes) {
//		this.balls = balls;
//		this.strikes = strikes;
//	}

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

	public boolean isBallInPlay() {
		return ballInPlay;
	}

	public void setBallInPlay(boolean ballInPlay) {
		this.ballInPlay = ballInPlay;
	}
	
}
