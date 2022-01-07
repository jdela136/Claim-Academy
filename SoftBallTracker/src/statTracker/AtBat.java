package statTracker;

import java.util.*;

public class AtBat {
	
	private int id;
	private int outs;
	private int runsScored;
	private List<Player> home;
	private List<Player> away;
	private Player batterUp;
	private Player batterOnFirst;
	private Player batterOnSecond;
	private Player batterOnThird;
	private List<Pitch> pitches;
	
	public AtBat() {
		outs = 0;
		runsScored = 0;
		pitches = new ArrayList<Pitch>();
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
	public List<Player> getHome() {
		return home;
	}
	public void setHome(List<Player> home) {
		this.home = home;
	}
	public List<Player> getAway() {
		return away;
	}
	public void setAway(List<Player> away) {
		this.away = away;
	}
	public Player getBatterUp() {
		return batterUp;
	}
	public void setBatterUp(Player batterUp) {
		this.batterUp = batterUp;
	}
	public Player getBatterOnFirst() {
		return batterOnFirst;
	}
	public void setBatterOnFirst(Player batterOnFirst) {
		this.batterOnFirst = batterOnFirst;
	}
	public Player getBatterOnSecond() {
		return batterOnSecond;
	}
	public void setBatterOnSecond(Player batterOnSecond) {
		this.batterOnSecond = batterOnSecond;
	}
	public Player getBatterOnThird() {
		return batterOnThird;
	}
	public void setBatterOnThird(Player batterOnThird) {
		this.batterOnThird = batterOnThird;
	}
	public List<Pitch> getPitches() {
		return pitches;
	}
	public void setPitches(List<Pitch> pitches) {
		this.pitches = pitches;
	}
	
	
}
