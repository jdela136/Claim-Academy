package statTracker;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private int lineUpId;
	
	private List<AtBat> atBats;
	
	private int number;
	
	private int strikeouts;
	
	private int walks;
	
	private int runs;
	
	private int rbis;
	
	private int hits;
	
	private int singles;
	
	private int doubles;
	
	private int triples;
	
	private int homeruns;
	
	private int trueAtBats;
	
	private double average;

	public Player() {
		atBats = new ArrayList<AtBat>();
//		strikeouts = 0;
//		walks = 0;
//		runs = 0;
//		rbis = 0;
//		hits = 0;
//		singles = 0;
//		doubles = 0;
//		triples = 0;
//		homeruns = 0;
	}
	
	

	public Player(int id, String firstName, String lastName) {
		atBats = new ArrayList<AtBat>();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLineUpId() {
		return lineUpId;
	}

	public void setLineUpId(int battingId) {
		this.lineUpId = battingId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



//	@Override
//	public String toString() {
//		return "Id: " + id + " FirstName: " + firstName + " LastName: " + lastName + " LineUpId: " + lineUpId;
//	}

	@Override
	public String toString() {
		int ab = getTrueAtBats();
		double avg = getAverage();
		return "Id: " + id + " FirstName=" + firstName + " LastName: " + lastName + " LineUpId: " + lineUpId
				+ " Average: " + avg + " AB: " + ab + " Strikeouts: " + strikeouts + " Walks: " + walks
				+ " Runs: " + runs + " Rbis: " + rbis + " Hits: " + hits + " Singles: " + singles + " Doubles: "
				+ doubles + " Triples: " + triples + " Homeruns: " + homeruns;
	}


	public void setTrueAtBats(int trueAtBats) {
		this.trueAtBats = trueAtBats;
	}


	public void setAverage(double average) {
		this.average = average;
	}
	
	public int getTrueAtBats() {
//		if (atBats.isEmpty()) {
//			return walks;
//		} else {
//			return atBats.size() - walks;
//		}
		try {
			trueAtBats = atBats.size() - walks;
		}
		catch(NullPointerException e) {
			trueAtBats = walks;
		}
		
		return trueAtBats;
	}

	public double getAverage() {
//		if (atBats.isEmpty()) {
//			return 0;
//		} else {
//			return hits / atBats.size();
//		}		
		try {
			average = (double) hits / trueAtBats;
		}
		catch(NullPointerException e) {
			average = 0;
		}
		catch(ArithmeticException e) {
			average = 0;
		}
		
		return average;
	}
	
	public void addAtBat(AtBat ab) {
		atBats.add(ab);
	}
}
