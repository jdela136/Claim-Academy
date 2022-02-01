package com.claim.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.sql.rowset.serial.SerialBlob;

@Entity
@Table(name="car")
public class Car {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="make")
    private String make;
	
	@Column(name="model")
    private String model;
	
	@Column(name="year")
    private Integer year;
	
	@Column(name="build")
    private String build;
	
	@Column(name="image")
    private String image;
	

	public Car() {}
	
	public Car(Integer id, String make, String model, Integer year, String build, String image) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.build = build;
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
