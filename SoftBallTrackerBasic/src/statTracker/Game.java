package statTracker;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private int id;
	private List<Team> teams;
	private int awayScore;
	private int homeScore;
	private List<AtBat> atBats;
	private boolean endGame;

	public Game() {
		endGame = false;
		teams = new ArrayList<Team>(2);
		atBats = new ArrayList<AtBat>();
	}

	public Game(Team away, Team home) {
		endGame = false;
		teams = new ArrayList<Team>(2);
		teams.add(away);
		teams.add(home);
		homeScore = 0;
		awayScore = 0;
		atBats = new ArrayList<AtBat>();
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
//		if (getLastAtBat().getOuts() >= 3) {
//			return homeScore + getLastAtBat().getRunsScored();
//		} else {
//			return homeScore;
//		}
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public int getAwayScore() {
//		if (getLastAtBat().getOuts() >= 3) {
//			return awayScore + getLastAtBat().getRunsScored();
//		} else {
//			return awayScore;
//		}
		return awayScore;
	}

	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}

	public List<AtBat> getAtBats() {
		return atBats;
	}

	public void setAtBats(List<AtBat> innings) {
		this.atBats = innings;
	}

	public AtBat getLastAtBat() {
		return atBats.get(atBats.size() - 1);
	}

	public Team getAwayTeam() {
		return getTeams().get(0);
	}

	public Team getHomeTeam() {
		return getTeams().get(1);
	}

	public void addAtBat() {

		int totalOuts = getLastAtBat().getOuts();

//		AtBat newAtBat = new AtBat();
//		newAtBat.setId(getLastAtBat().getId() + 1);
		if (totalOuts < 3) {
			// awayScore += getLastAtBat().getRunsScored();
			AtBat newAtBat = new AtBat();
			newAtBat.setId(getLastAtBat().getId() + 1);
			newAtBat.setHomeIndex(getLastAtBat().getHomeIndex());
			if (getLastAtBat().getAwayIndex() == getAwayTeam().getLineUpSize()) {
				newAtBat.setAwayIndex(1);
			} else {
				newAtBat.setAwayIndex(getLastAtBat().getAwayIndex() + 1);
			}
			// newAtBat.setAwayIndex(getLastAtBat().getAwayIndex() + 1);
			newAtBat.setOuts(getLastAtBat().getOuts());
			newAtBat.setInningNum(getLastAtBat().getInningNum());
			newAtBat.setBattersOnBase(getLastAtBat().getBattersOnBase());
			Player nextAwayBatter = getAwayTeam().getPlayerByLineUpId(newAtBat.getAwayIndex());
			newAtBat.getBattersOnBase().set(0, nextAwayBatter);
			getAtBats().add(newAtBat);
		}
		if (totalOuts == 3) {
			// homeScore += getLastAtBat().getRunsScored();
			AtBat newAtBat = new AtBat();
			newAtBat.setId(getLastAtBat().getId() + 1);
			if (getLastAtBat().getInningNum() == 1) {
				newAtBat.setAwayIndex(getLastAtBat().getAwayIndex());
				newAtBat.setHomeIndex(1);
				newAtBat.setOuts(getLastAtBat().getOuts());
				newAtBat.setInningNum(getLastAtBat().getInningNum());
				newAtBat.getBattersOnBase().set(0, getHomeTeam().getPlayerByLineUpId(newAtBat.getHomeIndex()));
				getAtBats().add(newAtBat);
			} else {
				if (getLastAtBat().getHomeIndex() == getHomeTeam().getLineUpSize()) {
					newAtBat.setHomeIndex(1);
				} else {
					newAtBat.setHomeIndex(getLastAtBat().getHomeIndex() + 1);
				}
				// newAtBat.setHomeIndex(getLastAtBat().getHomeIndex() + 1);
				newAtBat.setAwayIndex(getLastAtBat().getAwayIndex());
				newAtBat.setOuts(getLastAtBat().getOuts());
				newAtBat.setInningNum(getLastAtBat().getInningNum());
				Player nextHomeBatter = getHomeTeam().getPlayerByLineUpId(newAtBat.getHomeIndex());
				newAtBat.getBattersOnBase().set(0, nextHomeBatter);
				getAtBats().add(newAtBat);
			}
		}
		if (totalOuts == 4 || totalOuts == 5) {
			// homeScore += getLastAtBat().getRunsScored();
			AtBat newAtBat = new AtBat();
			newAtBat.setId(getLastAtBat().getId() + 1);
			if (getLastAtBat().getHomeIndex() == getHomeTeam().getLineUpSize()) {
				newAtBat.setHomeIndex(1);
			} else {
				newAtBat.setHomeIndex(getLastAtBat().getHomeIndex() + 1);
			}
			// newAtBat.setHomeIndex(getLastAtBat().getHomeIndex() + 1);
			newAtBat.setAwayIndex(getLastAtBat().getAwayIndex());
			Player nextHomeBatter = getHomeTeam().getPlayerByLineUpId(newAtBat.getHomeIndex());
			newAtBat.setOuts(getLastAtBat().getOuts());
			newAtBat.setInningNum(getLastAtBat().getInningNum());
			newAtBat.setBattersOnBase(getLastAtBat().getBattersOnBase());
			newAtBat.getBattersOnBase().set(0, nextHomeBatter);
			newAtBat.setRunsScored(newAtBat.getRunsScored());
			getAtBats().add(newAtBat);
		}
		if (totalOuts == 6) {
			// awayScore += getLastAtBat().getRunsScored();
			AtBat newAtBat = new AtBat();
			newAtBat.setId(getLastAtBat().getId() + 1);
			newAtBat.setHomeIndex(getLastAtBat().getHomeIndex());
			if (getLastAtBat().getAwayIndex() == getAwayTeam().getLineUpSize()) {
				newAtBat.setAwayIndex(1);
			} else {
				newAtBat.setAwayIndex(getLastAtBat().getAwayIndex() + 1);
			}
			//newAtBat.setAwayIndex(getLastAtBat().getAwayIndex() + 1);
			newAtBat.setOuts(0);
			newAtBat.setInningNum(getLastAtBat().getInningNum() + 1);
			Player nextAwayBatter = getAwayTeam().getPlayerByLineUpId(newAtBat.getAwayIndex());
			newAtBat.getBattersOnBase().set(0, nextAwayBatter);
			getAtBats().add(newAtBat);

		}
	}

	public void startGame() {
		AtBat newAtBat = new AtBat();
		newAtBat.setAwayIndex(1);
		newAtBat.getBattersOnBase().set(0, getAwayTeam().getPlayerByLineUpId(1));
		getAtBats().add(newAtBat);
		newAtBat.setId(1);
	}

	public boolean isEndGame() {
		return endGame;
	}

	public void setEndGame(boolean endGame) {
		homeScore += getLastAtBat().getRunsScored();
		this.endGame = endGame;
		if (endGame == true) {
			if (awayScore > homeScore) {
				getAwayTeam().setWins(getAwayTeam().getWins() + 1);
				getHomeTeam().setLosses(getHomeTeam().getLosses() + 1);

			} else {
				getAwayTeam().setWins(getAwayTeam().getWins() + 1);
				getHomeTeam().setLosses(getHomeTeam().getLosses() + 1);
			}
		}
	}

	@Override
	public String toString() {
		return "Id: " + id + " " + getAwayTeam() + ": " + awayScore + " " + getHomeTeam() + ": " + homeScore;
	}

	public String nextBatter() {
		int outs = getLastAtBat().getOuts();
		if(outs < 3) {
			return "Batter: " + getAwayTeam().getPlayerByLineUpId(getLastAtBat().getAwayIndex() + 1);
		}
		else if(outs == 3) {
			return "Batter: " + getHomeTeam().getPlayerByLineUpId(getLastAtBat().getHomeIndex());
		}
		else if (outs > 3 && outs < 6) {
			return "Batter: " + getHomeTeam().getPlayerByLineUpId(getLastAtBat().getHomeIndex() + 1);
		} else {
			return "Batter: " + getAwayTeam().getPlayerByLineUpId(getLastAtBat().getAwayIndex());
		}
	}

	public String batterUp() {
		if (getLastAtBat().isEndAtBat()) {
			return nextBatter();
		} else {
			return "Batter: " + getLastAtBat().getBatterUp();
		}
	}

	public void calculateScore() {
		if (getLastAtBat().getOuts() >= 3) {
			homeScore += getLastAtBat().getRunsScored();
		} else {
			awayScore += getLastAtBat().getRunsScored();
		}
	}

	public void addAtBatToLastBatter() {
		getLastAtBat().getBatterUp().addAtBat(getLastAtBat());
	}

}
