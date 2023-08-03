package com.gonder.ws.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Table ile databasedeki tablo adını istediğimiz şekilde belirleyebiliriz
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String username;
	
	private String displayname;
	
	private String password;
    
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getDisplayname() {
		return displayname;
	}



	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", displayname=" + displayname + ", password=" + password + "]";
	}

}
