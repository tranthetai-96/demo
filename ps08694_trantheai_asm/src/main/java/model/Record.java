package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Records")
public class Record {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recordId;	
	
	@Column(name = "record_type")
	private String recordType;	
	

	@Column(name = "record_date")
	@NotEmpty(message = "{global.record.date.empty}")
	private String recordDate;
	
	@NotEmpty(message = "{global.record.reason.empty}")
	private String reason;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "staffId")
	private Staff staff;

	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	public String getRecordDate() {
		return recordDate;
		
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	

	
}
