package statTracker;

import java.util.ArrayList;
import java.util.List;

public class Team {
	
	private int id;
	private String teamName;
	private int wins;
	private int losses;
	private Coach coach;
	private List<Player> roster;
	private List<Player> lineUp;
	
	public Team() {
		wins = 0;
		losses = 0;
		roster = new ArrayList<Player>();
		lineUp = new ArrayList<Player>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public List<Player> getRoster() {
		return roster;
	}

	public void setRoster(List<Player> roster) {
		this.roster = roster;
	}

	public List<Player> getLineUp() {
		return lineUp;
	}

	public void setLineUp(List<Player> lineUp) {
		this.lineUp = lineUp;
	}
	
}
