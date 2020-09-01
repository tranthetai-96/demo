package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")
public class User implements Serializable {
	@Id
	@NotNull(message = "{global.user.username.empty}")
	@Size(min = 1, max = 50, message = "{global.user.username.size}")
	private String username;
	@NotNull(message = "{global.user.password.empty}")
	@Size(min = 6, max = 20, message = "{global.user.password.size}")
	private String password;
	@NotNull(message = "{global.user.fullname.empty}")
	@Size(min = 2, max = 50, message = "{global.user.fullname.size}")
	private String fullname;
	private String img;
	
	public User() {
		super();
	}
	public User(String username, String password, String fullname, String img) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.img = img;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
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
	}
	
	
}