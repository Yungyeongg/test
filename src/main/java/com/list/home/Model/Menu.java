package com.list.home.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long parent_id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String file_path;
	
	@Column(nullable = false)
	private String file_name;
	
	@Column(nullable = false)
	private String link;
	
	@Column(nullable = false)
	private Integer arrange;
	
	@Column(nullable = false)
	private Integer active;
	
	@Column(nullable = false)
	private Integer del_flag;
	
	@Column(nullable = false)
	private String regist;
	
	@Column(nullable = false)
	private LocalDateTime regist_date = LocalDateTime.now();
	
	@Column(nullable = false)
	private String renew;
	
	@Column(nullable = false)
	private LocalDateTime renew_date = LocalDateTime.now();
	
	public Menu () {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParent_id() {
		return parent_id;
	}

	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getArrange() {
		return arrange;
	}

	public void setArrange(Integer arrange) {
		this.arrange = arrange;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Integer getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(Integer del_flag) {
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
