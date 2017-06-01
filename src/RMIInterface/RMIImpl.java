package RMIInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ClassManagement.Record;
import ClassManagement.StudentRecord;
import ClassManagement.TeacherRecord;

public class RMIImpl extends UnicastRemoteObject implements IRMI{

	private HashMap<Character, ArrayList<Record>> recordDB;
	private static int lastRecordID;
	
	public RMIImpl(int firstRecordID) throws RemoteException {
		super();
		lastRecordID = firstRecordID;
		recordDB = new HashMap<Character, ArrayList<Record>>();
		for(char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
		    recordDB.put(alphabet, new ArrayList<Record>());
		}

	}

	private Record find(String recordID){
		for (ArrayList<Record> listOfRecords : recordDB.values()){
			for (Record rec : listOfRecords){
				if (rec.getRecordID() == recordID)
					return rec;
			}
		}
		return null;		
	}
	
	private Record find (String firstName, String lastName){
		Character key = lastName.charAt(0);		
		if (recordDB.containsKey(key)){			
			for (Record rec :recordDB.get(key)){
				if (rec.getFirstName() == firstName && rec.getLastName() == lastName)
					return rec;
			}
		}
		return null;
	}
	public boolean createTRecord(String firstName, String lastName,
			String address, String phone, String specialization, String location) 
					throws RemoteException {
		if (this.find(firstName, lastName) != null){
			this.lastRecordID++;
			String recordID = "TR" + Integer.toString(this.lastRecordID);
			Record newTRecord = new TeacherRecord(recordID,firstName,lastName,
				address, phone, specialization, location);
			ArrayList list = recordDB.get(lastName.charAt(0));
			boolean result = false;
			synchronized(list){
				result = list.add(newTRecord);
			}
			if (!result)
				this.lastRecordID--;
			return result;
		}
		return false;
	}

	public boolean createSRecord(String firstName, String lastName,
			String courseRegisterd, String status, String statusDate)
					throws RemoteException {
		if (this.find(firstName, lastName) != null){
			this.lastRecordID++;
			String recordID = "SR" + Integer.toString(this.lastRecordID);
			Record newTRecord = new StudentRecord(recordID,firstName,lastName,
				courseRegisterd, status, statusDate);
			ArrayList list = recordDB.get(lastName.charAt(0));
			boolean result = false;
			synchronized(list){
				result = list.add(newTRecord);
			}
			if (!result)
				this.lastRecordID--;
			return result;
		}
		return false;
	}

	public int getRecordCounts() throws RemoteException {

		return 0;
	}

	public boolean editRecord(String recordID, String fieldName, String newValue)
			throws RemoteException{
		Record recFound = this.find(recordID); 
		fieldName = fieldName.trim().toLowerCase();

		if (recFound != null){
			if (recFound.getRecordID().substring(0,2).equals("TR")){
				//Teacher record				
				if (fieldName.equals("address")){
					((TeacherRecord)recFound).setAddress(newValue);
				}else if (fieldName.equals("phone")){
					((TeacherRecord)recFound).setPhone(newValue);					
				}else if (fieldName.equals("location")){
					((TeacherRecord)recFound).setLocation(newValue);
				}else
					return false;
			}else{
				//Student record
				if (fieldName.equals("courseregistered")){
					((StudentRecord)recFound).setCourseRegistered(newValue);
				}else if (fieldName.equals("status")){					
					((StudentRecord)recFound).setStatus(newValue);
				}else if (fieldName.equals("statusdate")){
					((StudentRecord)recFound).setStatusDate(newValue);
				}else
					return false;
			}				
		}			
		return false;
	}

	public void test() throws RemoteException{
		System.out.println("Test is running");
	}
	
}
