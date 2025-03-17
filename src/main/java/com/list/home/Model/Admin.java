package com.list.home.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "admin")
public class Admin {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long no;
		
		@Column(unique = true, nullable = false)
		@NotEmpty(message = "IDを入力してください。")
		private String id;
		
		@Column(nullable = false)
		private String name;
		
		@Column(nullable = false)
		@NotEmpty(message = "パスワードを入力してください。")
		private String password;
		
		@Column(nullable = false)
		private String mail;
		
		@Column(nullable = false)
		private String role;
		
		public Admin() {}

		public Long getNo() {
	        return no;
	    }

	    public void setNo(Long no) {
	        this.no = no;
	    }
	    
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
}
