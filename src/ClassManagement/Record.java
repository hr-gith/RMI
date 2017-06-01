package ClassManagement;

public abstract class Record {
	
	private String recordID;
	private String firstName;
	private String lastName;
	
	public Record(){
		this.recordID = "";
		this.firstName = "";
		this.lastName = "";
	}
	
	public Record(String recordID, String firstName, String lastName) {
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

	public String getRecordID() {
		return recordID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public boolean equals(Object rec) {
		if (rec instanceof Record){
			if (this.firstName == ((Record)rec).firstName && this.lastName == ((Record)rec).lastName) {
				return true;
			}
		}
		return false;		
	}	
	
}
