package com.claim.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="inventory")
public class Inventory {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="type")
    private String type;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="purchase_date")
    private LocalDate purchaseDate;
	
	@Column(name="miles")
    private Integer miles;
	
	@Column(name="price")
    private Double price;
	
	@Column(name="description")
    private String description;
	
	@Column(name="is_biddable")
	private Boolean isBiddable;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="car_id")
 	private Car car;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="sale_id")
 	private Sale sale;

	public Inventory() {}

	public Inventory(Integer id, String type, LocalDate purchaseDate, Integer miles, Double price,
			String description, Car car, Sale sale) {
		this.id = id;
		this.type = type;
		this.purchaseDate = purchaseDate;
		this.miles = miles;
		this.price = price;
		this.description = description;
		this.car = car;
		this.sale = sale;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Integer getMiles() {
		return miles;
	}

	public void setMiles(Integer miles) {
		this.miles = miles;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Boolean getIsBiddable() {
		return isBiddable;
	}

	public void setIsBiddable(Boolean isBiddable) {
		this.isBiddable = isBiddable;
	}
	
	
}
