package com.tracker.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="plate_appearance")
public class PlateAppearance {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;
	
	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;
	
	@Column(name = "strikes")
	private Integer strikes;
	
	@Column(name = "balls")
	private Integer balls;
	
	@Column(name = "base")
	private Integer base;
	
	@Column(name = "outs")
	private Integer outs;
	
	@Column(name = "away_index")
	private Integer awayIndex;
	
	@Column(name = "home_index")
	private Integer homeIndex;
	
	@Column(name = "inning_num")
	private Integer inningNum;
	
	@Column(name = "in_play")
	private Boolean inPlay;
	
	@Column(name = "end_game")
	private Boolean endGame;
	
	public PlateAppearance() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getBase() {
		return base;
	}

	public void setBase(Integer base) {
		this.base = base;
	}

	public Integer getOuts() {
		return outs;
	}

	public void setOuts(Integer outs) {
		this.outs = outs;
	}
	

	public Integer getAwayIndex() {
		return awayIndex;
	}

	public void setAwayIndex(Integer awayIndex) {
		this.awayIndex = awayIndex;
	}

	public Integer getHomeIndex() {
		return homeIndex;
	}

	public void setHomeIndex(Integer homeIndex) {
		this.homeIndex = homeIndex;
	}

	public Integer getInningNum() {
		return inningNum;
	}

	public void setInningNum(Integer inningNum) {
		this.inningNum = inningNum;
	}

	public Boolean getInPlay() {
		return inPlay;
	}

	public void setInPlay(Boolean inPlay) {
		this.inPlay = inPlay;
	}

	public Integer getStrikes() {
		return strikes;
	}

	public void setStrikes(Integer strikes) {
		this.strikes = strikes;
	}

	public Integer getBalls() {
		return balls;
	}

	public void setBalls(Integer balls) {
		this.balls = balls;
	}

	public Boolean getEndGame() {
		return endGame;
	}

	public void setEndGame(Boolean endGame) {
		this.endGame = endGame;
	}

	public void endPlateAppearance() {
		getPlayer().getStats().setAtBats(getPlayer().getStats().getAtBats()  + 1);
		getPlayer().getStats().setAverage(getPlayer().getStats().getAverage());
		getPlayer().getStats().setSlugging(getPlayer().getStats().getSlugging());
		getPlayer().getStats().setObp(getPlayer().getStats().getObp());
	}
	
}
