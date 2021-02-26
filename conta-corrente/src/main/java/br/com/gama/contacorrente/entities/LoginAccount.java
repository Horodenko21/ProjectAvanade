package br.com.gama.contacorrente.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.horodenko.entities.AbstractEntity;

@Entity
@Table(name="TB_LOGIN")
public class LoginAccount extends AbstractEntity {

	@Column(name="NM_USERNAME", unique = true)
	private String username;
	
	@Column(name="DS_PASSWORD")
	private String password;

	public LoginAccount(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	private LoginAccount() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		updateClass();
	}
	
}
