package statTracker;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private Team home;
	private Team away;
	private int homeScore;
	private int awayScore;
	private List<Inning> innings;
	
	public Game() {
		homeScore = 0;
		awayScore = 0;
		innings =  new ArrayList<Inning>();
	}
	public Game(Team home, Team away) {
		this.home = home;
		this.away = away;
		homeScore = 0;
		awayScore = 0;
		innings =  new ArrayList<Inning>();
	}
	public Team getHome() {
		return home;
	}
	public void setHome(Team home) {
		this.home = home;
	}
	public Team getAway() {
		return away;
	}
	public void setAway(Team away) {
		this.away = away;
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
	
	
	
}
