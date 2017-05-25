package RMIInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;

public class ClassManagement extends UnicastRemoteObject implements ClassManagementInterface{

	public ClassManagement() throws RemoteException {
		super();

	}

	public boolean createTRecord(String firstName, String lastName,
			String phone, String specialization, String location) 
					throws RemoteException {

		return false;
	}

	public boolean createSRecord(String firstName, String lastName,
			String[] courseRegisterd, boolean status, LocalDate statusDate)
					throws RemoteException {

		return false;
	}

	public int getRecordCounts() throws RemoteException {

		return 0;
	}

	public boolean editRecord(String recordID, String fieldName, String newValue)
			throws RemoteException{

		return false;
	}

}
