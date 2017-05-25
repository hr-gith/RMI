package ServerManagement;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMIInterface.ClassManagement;

public class DDOServer{

	public static void main(String[] args) {
		
		int portNumber = 1773;
		String registryURL = "rmi://localhost:" + portNumber + "/classManagement";
		try {
			Registry reg = LocateRegistry.createRegistry(portNumber);
			ClassManagement stub = new ClassManagement();
			try {
				reg.bind(registryURL, stub);
				System.out.println("DDO server is started");
			} catch (AlreadyBoundException e) {
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

}
