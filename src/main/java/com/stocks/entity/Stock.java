package com.stocks.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Stock {
	@Id
	@Column(name="id", nullable=false, unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@NotBlank
	@Min(1)
	@Column(name="name")
	String name;
	
	@NotBlank
	@Min(1)
	@Column(name="current_price")
	Long currentPrice;
	
	
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Date create_time;
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Date lastupdate_time;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getLastupdate_time() {
		return lastupdate_time;
	}

	public void setLastupdate_time(Date lastupdate_time) {
		this.lastupdate_time = lastupdate_time;
	}

	public Long getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Long currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	



}
