package ClassManagement;

import java.time.LocalDate;

public class StudentRecord extends Record {

	public String[] courseRegistered;
	public boolean status;
	public LocalDate statusDate;
	
	public StudentRecord(String recordID, String firstName, String lastName,
			String[] courseRegistered, boolean status, LocalDate statusDate) {
		super(recordID, firstName, lastName);
		this.courseRegistered = courseRegistered;
		this.status = status;
		this.statusDate = statusDate;		
	}

	public void setCourseRegistered(String[] courseRegistered) {
		this.courseRegistered = courseRegistered;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setStatusDate(LocalDate statusDate) {
		this.statusDate = statusDate;
	}
	
	

}
