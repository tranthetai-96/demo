package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Staffs")
public class Staff implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffId;
	@Column(name = "staff_name")
	@Size(min = 2, max=50, message = "{global.staff.fullname.size}")
	private String fullname;
	private boolean gender;
	@NotEmpty(message = "{global.staff.birthday.empty}")
	private String birthday;
	private String photo;
	@NotEmpty(message = "{global.staff.email.empty}")
	private String email;
	@Min(value = 1, message = "{global.staff.salary.empty}")
	private float salary;
	private String notes;
	private boolean deleted;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departId")
	private Department department;

	@OneToMany(mappedBy = "staff",fetch = FetchType.LAZY)
	private List<Record> records = new ArrayList<Record>();
	
	public Staff() {
		super();
	}
	
	
	
	public List<Record> getRecords() {
		return records;
	}



	public void setRecords(List<Record> records) {
		this.records = records;
	}



	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	

}
