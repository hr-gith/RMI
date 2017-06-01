package ClassManagement;

import java.time.LocalDate;

public class StudentRecord extends Record {

	private String courseRegistered;
	private String status;
	private String statusDate;
	
	public StudentRecord() {
		super();				
	}
	public StudentRecord(String recordID, String firstName, String lastName,
			String courseRegistered, String status, String statusDate) {
		super(recordID, firstName, lastName);
		this.courseRegistered = courseRegistered;
		this.status = status;
		this.statusDate = statusDate;		
	}

	public void setCourseRegistered(String courseRegistered) {
		this.courseRegistered = courseRegistered;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}
	public String getCourseRegistered() {
		return courseRegistered;
	}
	public String getStatus() {
		return status;
	}
	public String getStatusDate() {
		return statusDate;
	}	
}
