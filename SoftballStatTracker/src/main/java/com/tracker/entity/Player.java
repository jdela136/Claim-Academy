package com.tracker.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
	private Integer id;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "lineup_id")
	private Integer lineupId;

	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stats_id")
	private Stats stats;
	
	public Player() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getLineupId() {
		return lineupId;
	}

	public void setLineupId(Integer lineupId) {
		this.lineupId = lineupId;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}
	
	
}
