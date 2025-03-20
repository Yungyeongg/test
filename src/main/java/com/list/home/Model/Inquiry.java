package com.list.home.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "inquiry")
public class Inquiry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	///@NotEmpty(message = "名前を入力してください。")
	private String name;
	
	@Column(nullable = false)
	//@NotEmpty(message = "メールを入力してください。")
	private String mail;
	
	@Column(nullable = false)
	//@NotEmpty(message = "件名を入力してください。")
	private String title;
	
	@Column(nullable = false)
	//@NotEmpty(message = "内容を入力してください。")
	private String content;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime regist_date = LocalDateTime.now();
	
	@Column(nullable = false)
	private int answer;
	
	public Inquiry() {};

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getRegist_date() {
		return regist_date;
	}

	public void setRegist_date(LocalDateTime regist_date) {
		this.regist_date = regist_date;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}
}
