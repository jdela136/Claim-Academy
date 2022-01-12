package statTracker;

import java.util.ArrayList;
import java.util.List;

public class GameTracker {

	List<Game> games;

	public GameTracker() {
		games = new ArrayList<Game>();
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
}
