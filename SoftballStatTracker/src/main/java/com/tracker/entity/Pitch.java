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
@Table(name="pitch")
public class Pitch {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
	private Integer id;
	
	@Column(name = "balls")
	private  Integer balls;
	
	@Column(name = "strikes")
	private  Integer strikes;
	
	@ManyToOne
	@JoinColumn(name = "plate_appearance_id")
	private PlateAppearance plateAppearance;
	
	public Pitch() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBalls() {
		return balls;
	}

	public void setBalls(Integer balls) {
		this.balls = balls;
	}

	public Integer getStrikes() {
		return strikes;
	}

	public void setStrikes(Integer strikes) {
		this.strikes = strikes;
	}

	public PlateAppearance getPlateAppearance() {
		return plateAppearance;
	}

	public void setPlateAppearance(PlateAppearance plateAppearance) {
		this.plateAppearance = plateAppearance;
	}
	
	
}
