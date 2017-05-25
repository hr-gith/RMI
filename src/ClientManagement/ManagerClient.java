package ClientManagement;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ManagerClient {
	
	public static void main(String[] args) {
		
		System.out.println("Please enter your manager ID: ");
		Scanner in = new Scanner(System.in);
		String managerID = in.nextLine();
		String location = "";
		if (managerID.length()==7){
			location = managerID.substring(0,2).toUpperCase();
		}
		
		Registry reg;
		try {
			if (location == "MTL"){
				reg = LocateRegistry.getRegistry(1771);						
			}else if (location == "LVL"){
				reg = LocateRegistry.getRegistry(1772);
			}else if (location == "DDO"){
				reg = LocateRegistry.getRegistry(1773);
			}else{
				System.out.println("Error: Manager ID is not valid.");
				
			}
		} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		in.close();
	}
	
	

}
