package statTracker;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private int id;
	private List<Team> teams;
	private int homeScore;
	private int awayScore;
	private List<Inning> innings;
	
	public Game() {
		teams = new ArrayList<Team>(2);
		innings =  new ArrayList<Inning>();
	}
	
	public Game(Team home, Team away) {
		teams = new ArrayList<Team>(2);
		teams.add(away);
		teams.add(home);
		homeScore = 0;
		awayScore = 0;
		innings =  new ArrayList<Inning>();
	}
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
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
	public List<Inning> getInnings() {
		return innings;
	}
	public void setInnings(List<Inning> innings) {
		this.innings = innings;
	}
	
//	public void addToLineUp(Team team, Player player) {
//		if(team == teams.get(0)) {
//			awayBatters.add(player);			
//		}
//		else {
//			homeBatters.add(player);
//		}
//	}
	
	
}
