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
	Long price;
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Date create_time;
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Date lastupdate_time;

}
