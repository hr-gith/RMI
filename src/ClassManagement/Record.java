package ClassManagement;

public abstract class Record {
	
	public String recordID;
	public String firstName;
	public String lastName;
	
	public Record(String recordID, String firstName, String lastName) {
		super();
		this.recordID = recordID;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
}
