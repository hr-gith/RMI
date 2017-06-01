package ClassManagement;

public class TeacherRecord extends Record {

	private String address;
	private String phone;
	private String specialization;
	private String location;
	
	public TeacherRecord() {
		super();
		this.address = "";
		this.phone = "";
		this.specialization = "";
		this.location = "";
	}
	public TeacherRecord(String recordID, String firstName, String lastName,
			String address, String phone, String specialization, String location) {
		super(recordID, firstName, lastName);
		this.address = address;
		this.phone = phone;
		this.specialization = specialization;
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
	public String getSpecialization() {
		return specialization;
	}
	
	
	
}
