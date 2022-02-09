package com.tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stats")
public class Stats {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
	private Integer id;
	
	@Column(name = "pa_count")
	private Integer paCount;
	
	@Column(name = "at_bats")
	private Integer atBats;
	
	@Column(name = "average")
	private Double average;
	
	@Column(name = "obp")
	private Double obp;
	
	@Column(name = "slugging")
	private Double slugging;
	
	@Column(name = "hits")
	private Integer hits;
	
	@Column(name = "singles")
	private Integer singles;
	
	@Column(name = "doubles")
	private Integer doubles;
	
	@Column(name = "triples")
	private Integer triples;
	
	@Column(name = "homeruns")
	private Integer homeruns;
	
	@Column(name = "rbis")
	private Integer rbis;
	
	@Column(name = "runs")
	private Integer runs;
	
	@Column(name = "walks")
	private Integer walks;
	
	@Column(name = "strikeouts")
	private Integer strikeouts;
	
	public Stats() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPaCount() {
		return paCount;
	}

	public void setPaCount(Integer paCount) {
		this.paCount = paCount;
	}

	public Integer getAtBats() {
		return atBats;
	}

	public void setAtBats(Integer atBats) {
		this.atBats = atBats;
	}

	public Double getAverage() {
		average = ((double) hits / atBats);
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	public Double getObp() {
		obp = ((hits + walks) / (double) paCount);
		return obp;
	}

	public void setObp(Double obp) {
		this.obp = obp;
	}

	public Double getSlugging() {
		slugging = ((singles + (2 * doubles) + (3 * triples) + (4 * homeruns))/ (double) atBats);
		return slugging;
	}

	public void setSlugging(Double slugging) {
		this.slugging = slugging;
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	public Integer getSingles() {
		return singles;
	}

	public void setSingles(Integer singles) {
		this.singles = singles;
	}

	public Integer getDoubles() {
		return doubles;
	}

	public void setDoubles(Integer doubles) {
		this.doubles = doubles;
	}

	public Integer getTriples() {
		return triples;
	}

	public void setTriples(Integer triples) {
		this.triples = triples;
	}

	public Integer getHomeruns() {
		return homeruns;
	}

	public void setHomeruns(Integer homeruns) {
		this.homeruns = homeruns;
	}

	public Integer getRbis() {
		return rbis;
	}

	public void setRbis(Integer rbis) {
		this.rbis = rbis;
	}

	public Integer getRuns() {
		return runs;
	}

	public void setRuns(Integer runs) {
		this.runs = runs;
	}

	public Integer getWalks() {
		return walks;
	}

	public void setWalks(Integer walks) {
		this.walks = walks;
	}

	public Integer getStrikeouts() {
		return strikeouts;
	}

	public void setStrikeouts(Integer strikeouts) {
		this.strikeouts = strikeouts;
	}
	
	
}
