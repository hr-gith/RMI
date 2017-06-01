package ServerManagement;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMIInterface.RMIImpl;

public class MTLServer {
	
	public static final int portNumber = 1771;
	public static final int firstRecordID = 1000;
		
	public static void main(String[] args) {
		
		String registryURL = "rmi://localhost:" + portNumber + "/classManagement";
		try {
			Registry reg = LocateRegistry.createRegistry(portNumber);
			RMIImpl skeleton = new RMIImpl(firstRecordID);
			try {
				reg.bind(registryURL, skeleton);
				System.out.println("MTL server is started");
			} catch (AlreadyBoundException e) {
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
