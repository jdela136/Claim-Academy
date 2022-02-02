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
	
	@Column(name = "base")
	private Integer base;
	
	@Column(name = "outs")
	private Integer outs;
	
	@Column(name = "runs_scored")
	private Integer runsScored;
	
	
	@Column(name = "batting_order")
	private Integer battingOrder;
	
	@Column(name = "inning_num")
	private Integer inningNum;
	
	@Column(name = "in_play")
	private Integer inPlay;
	
	@Column(name = "end_pa")
	private Boolean endPa;
	
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

	public Integer getRunsScored() {
		return runsScored;
	}

	public void setRunsScored(Integer runsScored) {
		this.runsScored = runsScored;
	}

	public Integer getBattingOrder() {
		return battingOrder;
	}

	public void setBattingOrder(Integer battingOrder) {
		this.battingOrder = battingOrder;
	}

	public Integer getInningNum() {
		return inningNum;
	}

	public void setInningNum(Integer inningNum) {
		this.inningNum = inningNum;
	}

	public Integer getInPlay() {
		return inPlay;
	}

	public void setInPlay(Integer inPlay) {
		this.inPlay = inPlay;
	}

	public Boolean isEndPa() {
		return endPa;
	}

	public void setEndPa(Boolean endPa) {
		this.endPa = endPa;
	}
	
	
}
