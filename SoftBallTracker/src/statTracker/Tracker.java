package statTracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {

	List<Game> games;

	public Tracker() {
		games = new ArrayList<Game>();
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public void startNewGame(Team home, Team away) {
		Game newGame = new Game(home, away);
		games.add(newGame);
	}

	public void addInning(int gameId) {
		for (Game game : games) {
			if (game.getId() == gameId) {
				Inning newInning = new Inning();
				game.getInnings().add(newInning);
			}
		}
	}

	public void addAtBat(int gameId) {
		for (Game game : games) {
			if (game.getId() == gameId) {
				AtBat newAtBat = new AtBat();
				newAtBat.setHome(game.getHome().getLineUp());
				newAtBat.setAway(game.getAway().getLineUp());
				newAtBat.setBatterUp(newAtBat.getAway().get(0));
				Inning lastInning = game.getInnings().get(game.getInnings().size()-1);
				lastInning.getAtBats().add(newAtBat);
			}
		}
	}

	public void addStrike(int gameId) {
		for(Game game : games) {
			if (game.getId() == gameId) {
				Inning lastInning = game.getInnings().get(game.getInnings().size()-1);
				AtBat lastAtBat = lastInning.getAtBats().get(lastInning.getAtBats().size() - 1);
				Pitch lastPitch = lastAtBat.getPitches().get(lastAtBat.getPitches().size() - 1);
				lastPitch.setStrikes(lastPitch.getStrikes() + 1);
			}
		}
	}

}
