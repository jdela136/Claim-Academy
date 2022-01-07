package statTracker;

import java.util.ArrayList;
import java.util.List;

public class Inning {
	private int inningNum;
	private List<AtBat> atBats;
	private int homeScore;
	private int awayScore;
	
	public Inning() {
		atBats = new ArrayList<AtBat>();
		homeScore = 0;
		awayScore = 0 ;
	}

	public int getInningNum() {
		return inningNum;
	}

	public void setInningNum(int inningNum) {
		this.inningNum = inningNum;
	}

	public List<AtBat> getAtBats() {
		return atBats;
	}

	public void setAtBats(List<AtBat> atBats) {
		this.atBats = atBats;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public int getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}
	
	
}
