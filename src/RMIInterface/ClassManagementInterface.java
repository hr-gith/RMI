package RMIInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

public interface ClassManagementInterface extends Remote{

	public boolean createTRecord(String firstName, String lastName, String phone, String specialization, String location)
			throws RemoteException;
	public boolean createSRecord(String firstName, String lastName, String[] courseRegisterd, boolean status, LocalDate statusDate)
			throws RemoteException;
	public int getRecordCounts() throws RemoteException;
	public boolean editRecord(String recordID, String fieldName, String newValue) throws RemoteException;
}
