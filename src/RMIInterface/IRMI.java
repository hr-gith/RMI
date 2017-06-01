package RMIInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

public interface IRMI extends Remote{

	public boolean createTRecord(String firstName, String lastName,String address, String phone, String specialization, String location)
			throws RemoteException;
	public boolean createSRecord(String firstName, String lastName, String courseRegisterd, String status, String statusDate)
			throws RemoteException;
	public int getRecordCounts() throws RemoteException;
	public boolean editRecord(String recordID, String fieldName, String newValue) throws RemoteException;
	public void test() throws RemoteException;
}
