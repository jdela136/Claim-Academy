package com.tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="game")
public class Game {
	
	@Id
    @Column(name = "id")
	private Integer id;
	
	@ManyToMany
	@JoinColumn(name = "team_id")
	private Team team;
	
	@Column(name = "score")
	private Integer score;
	
	@Column(name = "end_Game")
	private Boolean endGame;
	
	public Game() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Boolean getEndGame() {
		return endGame;
	}

	public void setEndGame(Boolean endGame) {
		this.endGame = endGame;
	}
	
}
