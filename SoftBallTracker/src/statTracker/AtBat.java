package statTracker;

import java.util.*;

public class AtBat {

	private int id;
	private int outs;
	private int runsScored;
	private List<Player> battersOnBase;
	private List<Pitch> pitches;
	private int awayIndex;
	private int homeIndex;

	public AtBat() {
		outs = 0;
		runsScored = 0;
		pitches = new ArrayList<Pitch>();
		battersOnBase = new ArrayList<Player>(5);
		battersOnBase.add(null);
		battersOnBase.add(null);
		battersOnBase.add(null);
		battersOnBase.add(null);
		battersOnBase.add(null);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOuts() {
		return outs;
	}

	public void setOuts(int outs) {
		this.outs = outs;
	}

	public int getRunsScored() {
		return runsScored;
	}

	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}

	public List<Pitch> getPitches() {
		return pitches;
	}

	public void setPitches(List<Pitch> pitches) {
		this.pitches = pitches;
	}

	public List<Player> getBattersOnBase() {
		return battersOnBase;
	}

	public void setBattersOnBase(List<Player> battersOnBase) {
		this.battersOnBase = battersOnBase;
	}
	
	public int getAwayIndex() {
		return awayIndex;
	}

	public void setAwayIndex(int batterIndex) {
		this.awayIndex = batterIndex;
	}

	public int getHomeIndex() {
		return homeIndex;
	}

	public void setHomeIndex(int homeIndex) {
		this.homeIndex = homeIndex;
	}
	
	
}
