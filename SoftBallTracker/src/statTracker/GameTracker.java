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

	public void startNewGame(Team home, Team away) {
		Game newGame = new Game(home, away);
		games.add(newGame);
		addInning(newGame);
		addAtBat(newGame);
	}

	public void addInning(Game game) {
		Inning newInning = new Inning();
		game.getInnings().add(newInning);
	}

	public void addAtBat(Game game) {
		Team home = game.getTeams().get(0);
		Team away = game.getTeams().get(1);
		if (game.getInnings().size() == 1) {
			Inning firstInning = game.getInnings().get(0);
			if (firstInning.getAtBats().size() == 0) {
				AtBat newAtBat = new AtBat();
				newAtBat.setAwayIndex(0);
				newAtBat.getBattersOnBase().set(0, away.getLineUp().get(newAtBat.getAwayIndex()));
				firstInning.getAtBats().add(newAtBat);
			} else {
				AtBat lastAtBat = firstInning.getAtBats().get(firstInning.getAtBats().size() - 1);
				int totalOuts = lastAtBat.getOuts();
				if (totalOuts < 3) {
					AtBat newAtBat = new AtBat();
					newAtBat.setAwayIndex(lastAtBat.getAwayIndex() + 1);
					newAtBat.setOuts(lastAtBat.getOuts());
					newAtBat.setBattersOnBase(lastAtBat.getBattersOnBase());
					Player nextBatter = away.getLineUp().get(newAtBat.getAwayIndex());
					newAtBat.getBattersOnBase().set(0, nextBatter);
					newAtBat.setRunsScored(newAtBat.getRunsScored());
					firstInning.getAtBats().add(newAtBat);
				} else if (totalOuts == 4) {
					AtBat newAtBat = new AtBat();
					newAtBat.setHomeIndex(0);
					newAtBat.getBattersOnBase().set(0, home.getLineUp().get(0));
					newAtBat.setHomeIndex(0);
					firstInning.getAtBats().add(newAtBat);
				} else {
					AtBat newAtBat = new AtBat();
					newAtBat.setHomeIndex(lastAtBat.getHomeIndex() + 1);
					newAtBat.setOuts(lastAtBat.getOuts());
					newAtBat.setBattersOnBase(lastAtBat.getBattersOnBase());
					Player nextBatter = home.getLineUp().get(newAtBat.getHomeIndex());
					newAtBat.getBattersOnBase().set(0, nextBatter);
					newAtBat.setRunsScored(newAtBat.getRunsScored());
					firstInning.getAtBats().add(newAtBat);
				}
			}
		} else {
			Inning lastInning = game.getInnings().get(game.getInnings().size() - 1);
			AtBat lastAtBat = lastInning.getAtBats().get(lastInning.getAtBats().size() - 1);
			Player nextAwayBatter = away.getLineUp().get(lastAtBat.getAwayIndex());
			Player nextHomeBatter = home.getLineUp().get(lastAtBat.getHomeIndex());
			if (lastInning.getAtBats().size() == 0) {
				AtBat newAtBat = new AtBat();
				newAtBat.setAwayIndex(lastAtBat.getAwayIndex() + 1);
				newAtBat.getBattersOnBase().set(0, nextAwayBatter);
				lastInning.getAtBats().add(newAtBat);
			} else {
				int totalOuts = lastAtBat.getOuts();
				if (totalOuts < 3) {
					AtBat newAtBat = new AtBat();
					newAtBat.setAwayIndex(lastAtBat.getAwayIndex() + 1);
					newAtBat.setOuts(lastAtBat.getOuts());
					newAtBat.setBattersOnBase(lastAtBat.getBattersOnBase());
					newAtBat.getBattersOnBase().set(0, nextAwayBatter);
					newAtBat.setRunsScored(newAtBat.getRunsScored());
					lastInning.getAtBats().add(newAtBat);
				} else if (totalOuts == 4) {
					AtBat newAtBat = new AtBat();
					newAtBat.setHomeIndex(lastAtBat.getHomeIndex() + 1);
					newAtBat.getBattersOnBase().set(0, nextHomeBatter);
					newAtBat.setHomeIndex(0);
					lastInning.getAtBats().add(newAtBat);
				} else {
					AtBat newAtBat = new AtBat();
					newAtBat.setHomeIndex(lastAtBat.getHomeIndex() + 1);
					newAtBat.setOuts(lastAtBat.getOuts());
					newAtBat.setBattersOnBase(lastAtBat.getBattersOnBase());
					newAtBat.getBattersOnBase().set(0, nextHomeBatter);
					newAtBat.setRunsScored(newAtBat.getRunsScored());
					lastInning.getAtBats().add(newAtBat);
				}
			}
		}
	}

	public void addStrike(Game game) {
		Inning lastInning = game.getInnings().get(game.getInnings().size() - 1);
		AtBat lastAtBat = lastInning.getAtBats().get(lastInning.getAtBats().size() - 1);
		if (lastAtBat.getPitches().size() == 0) {
			Pitch firstPitch = new Pitch();
			lastAtBat.getPitches().add(firstPitch);
			firstPitch.setStrikes(firstPitch.getStrikes() + 1);
		} else {
			Pitch lastPitch = lastAtBat.getPitches().get(lastAtBat.getPitches().size() - 1);
			if (lastPitch.getStrikes() == 2) {
				lastPitch.setStrikes(lastPitch.getStrikes() + 1);
				outMade(game);
				Player batter = lastAtBat.getBattersOnBase().get(0);
				batter.setStrikeouts(batter.getStrikeouts() + 1);
			} else {
				lastPitch.setStrikes(lastPitch.getStrikes() + 1);
			}
		}
	}

	public void addBall(Game game) {
		Inning lastInning = game.getInnings().get(game.getInnings().size() - 1);
		AtBat lastAtBat = lastInning.getAtBats().get(lastInning.getAtBats().size() - 1);
		if (lastAtBat.getPitches().size() == 0) {
			Pitch firstPitch = new Pitch();
			lastAtBat.getPitches().add(firstPitch);
			firstPitch.setBalls(firstPitch.getBalls() + 1);
		} else {
			Pitch lastPitch = lastAtBat.getPitches().get(lastAtBat.getPitches().size() - 1);
			if (lastPitch.getBalls() == 3) {
				lastPitch.setBalls(lastPitch.getBalls() + 1);
				Player batter = lastAtBat.getBattersOnBase().get(0);
				batter.setWalks(batter.getWalks() + 1);
				lastAtBat.getBattersOnBase().set(1, batter);
				lastAtBat.getBattersOnBase().set(0, null);
			} else {
				lastPitch.setBalls(lastPitch.getBalls() + 1);
			}
		}
	}

	public void outMade(Game game) {
		Inning lastInning = game.getInnings().get(game.getInnings().size() - 1);
		AtBat lastAtBat = lastInning.getAtBats().get(lastInning.getAtBats().size() - 1);
		if (lastAtBat.getPitches().size() == 0) {
			Pitch firstPitch = new Pitch();
			lastAtBat.getPitches().add(firstPitch);
			lastAtBat.setOuts(lastAtBat.getOuts() + 1);
		} else {
			Pitch lastPitch = lastAtBat.getPitches().get(lastAtBat.getPitches().size() - 1);
			if (lastPitch.getStrikes() == 3) {
				lastAtBat.setOuts(lastAtBat.getOuts() + 1);
			} else {
				Pitch nextPitch = new Pitch();
				nextPitch = lastAtBat.getPitches().get(lastAtBat.getPitches().size() - 1);
				lastAtBat.getPitches().add(nextPitch);
				lastAtBat.setOuts(lastAtBat.getOuts() + 1);
			}
		}
		if (lastAtBat.getOuts() == 3) {
			lastInning.setAwayScore(lastAtBat.getRunsScored());
			lastAtBat.setRunsScored(0);
		}
		if (lastAtBat.getOuts() == 6) {
			lastInning.setHomeScore(lastAtBat.getRunsScored());
		}
	}

	public void baseHit(Game game, int bases) {
		Inning lastInning = game.getInnings().get(game.getInnings().size() - 1);
		AtBat lastAtBat = lastInning.getAtBats().get(lastInning.getAtBats().size() - 1);
		Player batter = lastAtBat.getBattersOnBase().get(0);
		switch (bases) {
		case 1:
			moveRunner(lastAtBat, bases, batter);
			batter.setSingles(batter.getSingles() + 1);
			batter.setHits(batter.getHits() + 1);
			break;
		case 2:
			moveRunner(lastAtBat, bases, batter);
			batter.setDoubles(batter.getDoubles() + 2);
			batter.setHits(batter.getHits() + 1);
			break;
		case 3:
			moveRunner(lastAtBat, bases, batter);
			batter.setTriples(batter.getTriples() + 1);
			batter.setHits(batter.getHits() + 1);
			break;
		case 4:
			moveRunner(lastAtBat, bases, batter);
			batter.setHomeruns(batter.getHomeruns() + 1);
			batter.setHits(batter.getHits() + 1);
			break;
		}

	}

	public void moveRunner(AtBat atBat, int bases, Player player) {
		List<Player> runners = atBat.getBattersOnBase();
		for (Player runner : runners) {
			if (runner == player) {
				if (bases == 0) {
					runners.set(runners.indexOf(player), null);
				} else {
					int endBase = runners.indexOf(runner) + bases;
					if (endBase >= 4) {
						endBase = 4;
						runners.set(4, player);
						runner.setRuns(runner.getRuns() + 1);
						atBat.setRunsScored(atBat.getRunsScored() + 1);
					} else {
						runners.set(endBase, player);
						runners.set(runners.indexOf(player), null);
					}
				}
			}
		}
	}
}
