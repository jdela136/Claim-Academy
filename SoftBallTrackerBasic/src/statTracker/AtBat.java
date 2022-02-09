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
	private int inningNum;
	private boolean endAtBat;

	public AtBat() {
		outs = 0;
		runsScored = 0;
		pitches = new ArrayList<Pitch>();
		battersOnBase = new ArrayList<Player>(5);
		battersOnBase.add(null);
		battersOnBase.add(null);
		battersOnBase.add(null);
		battersOnBase.add(null);
		endAtBat = false;
		inningNum = 1;
		homeIndex = 1;
		awayIndex = 1;
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

	public int getViewOuts() {
		if (outs < 3) {
			return outs;
		} else if (outs == 3) {
			if (isEndAtBat()) {
				return 3;
			} else {
				return 0;
			}
		} else if (outs == 4) {
			return 1;
		} else if (outs == 5) {
			return 2;
		} else {
			return 3;
		}
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

	public int getInningNum() {
		return inningNum;
	}

	public void setInningNum(int inningNum) {
		this.inningNum = inningNum;
	}

	public void addStrike() {
		if (getPitches().size() == 0) {
			Pitch firstPitch = new Pitch(1, 2);
			firstPitch.setId(1);
			pitches.add(firstPitch);
//			firstPitch.setStrikes(firstPitch.getStrikes() + 1);

		} else {
			Pitch lastPitch = getPitches().get(getPitches().size() - 1);
			Pitch nextPitch = new Pitch();
			nextPitch.setId(lastPitch.getId() + 1);
			if (lastPitch.getStrikes() == 2) {
				nextPitch.setStrikes(lastPitch.getStrikes() + 1);
				nextPitch.setBalls(lastPitch.getBalls());
				pitches.add(nextPitch);
				outMade();
				Player batter = getBattersOnBase().get(0);
				batter.setStrikeouts(batter.getStrikeouts() + 1);
				setEndAtBat(true);
			} else {
				nextPitch.setStrikes(lastPitch.getStrikes() + 1);
				nextPitch.setBalls(lastPitch.getBalls());
				pitches.add(nextPitch);
			}
		}
	}

	public void addBall() {
		if (getPitches().size() == 0) {
			Pitch firstPitch = new Pitch(2, 1);
			firstPitch.setId(1);
			pitches.add(firstPitch);
		} else {
			Pitch lastPitch = getPitches().get(getPitches().size() - 1);
			Pitch nextPitch = new Pitch();
			nextPitch.setId(lastPitch.getId() + 1);
			if (lastPitch.getBalls() == 3) {
				nextPitch.setBalls(lastPitch.getBalls() + 1);
				nextPitch.setStrikes(lastPitch.getStrikes());
				pitches.add(nextPitch);
				Player batter = getBattersOnBase().get(0);
				batter.setWalks(batter.getWalks() + 1);
				moveAllRunners(1);
				getBattersOnBase().set(1, batter);
				setEndAtBat(true);
			} else {
				nextPitch.setBalls(lastPitch.getBalls() + 1);
				nextPitch.setStrikes(lastPitch.getStrikes());
				pitches.add(nextPitch);
			}
		}
	}

	public void outMade() {
		if (getPitches().size() == 0) {
			Pitch firstPitch = new Pitch(1, 1);
			firstPitch.setId(1);
			getPitches().add(firstPitch);
			setOuts(getOuts() + 1);
		} else {
			Pitch lastPitch = getPitches().get(getPitches().size() - 1);
			if (lastPitch.getStrikes() == 3) {
				setOuts(getOuts() + 1);
			} else {
				Pitch nextPitch = new Pitch();
				nextPitch.setId(lastPitch.getId() + 1);
				nextPitch = getPitches().get(getPitches().size() - 1);
				getPitches().add(nextPitch);
				setOuts(getOuts() + 1);
			}
		}
		setEndAtBat(true);
	}

	public void baseHit(int bases) {
		Player batter = battersOnBase.get(0);
		if (getPitches().size() == 0) {
			Pitch firstPitch = new Pitch(1, 1);
			getPitches().add(firstPitch);
			firstPitch.setId(1);
		} else {
			Pitch lastPitch = getPitches().get(getPitches().size() - 1);
			Pitch nextPitch = new Pitch();
			nextPitch.setId(lastPitch.getId() + 1);
		}

		switch (bases) {
		case 1:
			moveAllRunners(1);
			batter.setSingles(batter.getSingles() + 1);
			batter.setHits(batter.getHits() + 1);
			break;
		case 2:
			moveAllRunners(2);
			batter.setDoubles(batter.getDoubles() + 1);
			batter.setHits(batter.getHits() + 1);
			break;
		case 3:
			moveAllRunners(3);
			batter.setTriples(batter.getTriples() + 1);
			batter.setHits(batter.getHits() + 1);
			break;
		case 4:
			moveAllRunners(4);
			batter.setHomeruns(batter.getHomeruns() + 1);
			batter.setHits(batter.getHits() + 1);
			break;
		}
		endAtBat = true;
	}

	public void moveRunner(int endingBase, int runnerBase) {
		if (endingBase == 0) {
			battersOnBase.set(runnerBase, null);
		} else {
			if (endingBase > 3) {
				battersOnBase.get(runnerBase).setRuns(battersOnBase.get(runnerBase).getRuns() + 1);
				battersOnBase.get(0).setRbis(battersOnBase.get(0).getRbis() + 1);
				setRunsScored(getRunsScored() + 1);
				if (runnerBase != 0) {
					battersOnBase.set(runnerBase, null);
				}
			} else {
				battersOnBase.set(endingBase, battersOnBase.get(runnerBase));
				if (runnerBase != 0) {
					battersOnBase.set(runnerBase, null);
				}
			}
		}
	}

	public void moveAllRunners(int bases) {
		for (int i = 3; i >= 0; i--) {
			if (battersOnBase.get(i) != null) {
				if (i == bases) {
					moveRunner(i + 1, i);
				}
				if (i < bases) {
					moveRunner(i + bases, i);
				}
			}
		}
	}

	public boolean isEndAtBat() {
		return endAtBat;
	}

	public void setEndAtBat(boolean endAtBat) {
		this.endAtBat = endAtBat;
	}

	public Pitch getLastPitch() {
		return pitches.get(pitches.size() - 1);
	}

	public Player getBatterUp() {
		return battersOnBase.get(0);
	}

	@Override
	public String toString() {
		return "Inning: " + inningNum + " Id: " + id + " Outs=" + getViewOuts() + " RunsScored=" + runsScored
				+ " AwayIndex=" + awayIndex + " HomeIndex=" + homeIndex + "\nLast Batter: " + battersOnBase.get(0).toString()
				+ "\n1st: " + battersOnBase.get(1) + "\n2nd: " + battersOnBase.get(2) + "\n3rd: "
				+ battersOnBase.get(3);
	}

}
