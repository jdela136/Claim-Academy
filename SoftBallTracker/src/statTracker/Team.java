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
	
	public Team() {
		wins = 0;
		losses = 0;
		roster = new ArrayList<Player>();
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
	
	public void addPlayerToRoster(Player player) {
		roster.add(player);
	}
	
	public Player getPlayerById(int id) {
		Player temp = new Player();
		for (Player player : roster) {
			if(player.getId() == id) {
				temp = player;
			}
		}
		return temp;
	}
	
	public Player getPlayerByLineUpId(int id) {
		Player temp = new Player();
		for (Player player : roster) {
			if(player.getLineUpId() == id) {
				temp = player;
			}
		}
		return temp;
	}
	
	public void setBattertoLineUp(int batterId, int lineUpId) {
		getPlayerById(batterId).setLineUpId(lineUpId);
	}
	
	
	public void clearLineUp() {
		for (Player player : roster) {
			if(player.getLineUpId() != 0) {
				player.setLineUpId(0);
			}
		}
	}
	
	public void setLineUp(Player one, Player two, Player three, Player four , Player five, 
			Player six, Player seven, Player eight, Player nine, Player ten) {
		one.setLineUpId(1);
		two.setLineUpId(2);
		three.setLineUpId(3);
		four.setLineUpId(4);
		five.setLineUpId(5);
		six.setLineUpId(6);
		seven.setLineUpId(7);
		eight.setLineUpId(8);
		nine.setLineUpId(9);
		ten.setLineUpId(10);
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", teamName=" + teamName + ", wins=" + wins + ", losses=" + losses + ", coach="
				+ coach;
	}

	public Team(int id, String teamName, int wins, int losses, Coach coach, List<Player> roster) {
		this.id = id;
		this.teamName = teamName;
		this.wins = wins;
		this.losses = losses;
		this.coach = coach;
		this.roster = roster;
	}
	
	
}
