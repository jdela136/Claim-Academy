package statTracker;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<AtBat> atBats;
	
	private int strikeouts;
	
	private int walks;
	
	private int runs;
	
	private int rbis;
	
	private int hits;
	
	private int singles;
	
	private int doubles;
	
	private int triples;
	
	private int homeruns;

	public Player() {
		atBats = new ArrayList<AtBat>();
		strikeouts = 0;
		walks = 0;
		runs = 0;
		rbis = 0;
		hits = 0;
		singles = 0;
		doubles = 0;
		triples = 0;
		homeruns = 0;
	}

	public List<AtBat> getAtBats() {
		return atBats;
	}

	public void setAtBats(List<AtBat> atBats) {
		this.atBats = atBats;
	}

	public int getStrikeouts() {
		return strikeouts;
	}

	public void setStrikeouts(int strikeouts) {
		this.strikeouts = strikeouts;
	}

	public int getWalks() {
		return walks;
	}

	public void setWalks(int walks) {
		this.walks = walks;
	}
	
	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getRbis() {
		return rbis;
	}

	public void setRbis(int rbis) {
		this.rbis = rbis;
	}

	public int getSingles() {
		return singles;
	}

	public void setSingles(int singles) {
		this.singles = singles;
	}

	public int getDoubles() {
		return doubles;
	}

	public void setDoubles(int doubles) {
		this.doubles = doubles;
	}

	public int getTriples() {
		return triples;
	}

	public void setTriples(int triples) {
		this.triples = triples;
	}

	public int getHomeruns() {
		return homeruns;
	}

	public void setHomeruns(int homeruns) {
		this.homeruns = homeruns;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
	
	
}
