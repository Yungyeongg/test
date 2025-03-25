package com.list.home.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "eccess")
public class Eccess {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String subtitle;
	
	@Column(nullable = false)
	private BigDecimal latitude;
	
	@Column(nullable = false)
	private BigDecimal longitude;
	
	@Column(nullable = false)
	private String pin;
	
	@Column(nullable = false)
	private int del_flag;
	
	@Column(nullable = false)
	private String regist;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime regist_date = LocalDateTime.now();
	
	@Column(nullable = false)
	private String renew;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime renew_date = LocalDateTime.now();
	
	public Eccess() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public int getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(int del_flag) {
		this.del_flag = del_flag;
	}

	public String getRegist() {
		return regist;
	}

	public void setRegist(String regist) {
		this.regist = regist;
	}

	public LocalDateTime getRegist_date() {
		return regist_date;
	}

	public void setRegist_date(LocalDateTime regist_date) {
		this.regist_date = regist_date;
	}

	public String getRenew() {
		return renew;
	}

	public void setRenew(String renew) {
		this.renew = renew;
	}

	public LocalDateTime getRenew_date() {
		return renew_date;
	}

	public void setRenew_date(LocalDateTime renew_date) {
		this.renew_date = renew_date;
	};
}