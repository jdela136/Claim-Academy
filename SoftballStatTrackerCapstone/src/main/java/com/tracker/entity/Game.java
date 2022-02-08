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
@Table(name="game")
public class Game {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
	private Integer id;
	
//	@Column(name = "game_id")
//	private Integer gameId;
	
	@ManyToOne
	@JoinColumn(name = "home_team_id")
	private Team homeTeam;
	
	@ManyToOne
	@JoinColumn(name = "away_team_id")
	private Team awayTeam;
	
	@Column(name = "home_score")
	private Integer homeScore;
	
	@Column(name = "away_score")
	private Integer awayScore;
	
	public Game() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
//	public Integer getGameId() {
//		return gameId;
//	}
//
//	public void setGameId(Integer gameId) {
//		this.gameId = gameId;
//	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public Integer getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(Integer score) {
		this.awayScore = score;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Integer getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(Integer homeScore) {
		this.homeScore = homeScore;
	}
	
	
	
}
