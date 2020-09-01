package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Departments")
public class Department implements Serializable{
	@Id
	@NotEmpty(message = "{global.depart.id.empty}")
	@Size(min = 2, max = 20, message = "{global.depart.id.size}")
	private String departId;
	@NotEmpty(message = "{global.depart.name.empty}")
	private String name;
	private boolean status;
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDepartId() {
		return departId;
	}
	public void setDepartId(String departId) {
		this.departId = departId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
