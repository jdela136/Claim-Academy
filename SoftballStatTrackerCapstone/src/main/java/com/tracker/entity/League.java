package com.tracker.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "league")
public class League {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
    private Integer id;
	
	@Column(name = "league_name")
	private String leagueName;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commissioner_id")
    private Commissioner commissioner;
	
	public League() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public Commissioner getCommissioner() {
		return commissioner;
	}

	public void setCommissioner(Commissioner commissioner) {
		this.commissioner = commissioner;
	}
	
}
