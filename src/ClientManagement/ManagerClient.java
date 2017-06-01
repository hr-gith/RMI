package ClientManagement;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import RMIInterface.IRMI;

public class ManagerClient {
	
	public static void main(String[] args) {
		
		System.out.println("Please enter your manager ID: ");
		Scanner in = new Scanner(System.in);
		String managerID = in.nextLine();
		String newInput = "";
		if (managerID.length() == 7){
			newInput = managerID.substring(0,3).toUpperCase();
		}
		Registry reg;
		int portNumber = 0;
		try {
			if (newInput.equals("MTL")){
				portNumber = 1771;						
			}else if (newInput.equals("LVL")){
				portNumber = 1772;
			}else if (newInput.equals("DDO")){
				portNumber = 1773;
			}else{
				System.out.println("Error: Manager ID is not valid.");
			}
			if (portNumber != 0){
				reg = LocateRegistry.getRegistry(portNumber);
				String registryURL = "rmi://localhost:" + portNumber + "/classManagement";
			 	try {
					IRMI serverObject = (IRMI) reg.lookup(registryURL);
					//serverObject.test();
					displayMenu();
					newInput = in.nextLine().trim();
					switch (Integer.valueOf(newInput)){
					case 1: 
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;	
					}
					
					//TO-DO: Display menu
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 	}
		} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		in.close();
	}
	
	public static void displayMenu(){
		System.out.println(">>>>> CLASS MANAGEMENT SYSTEM <<<<<");
		System.out.println("-----------------------------------");
		System.out.println("1. Add a Teacher ");
		System.out.println("2. Add a Student ");
		System.out.println("3. Edit a Teacher/Student");
		System.out.println("4. Get total number of members");
		System.out.println("5. Exit");
		System.out.println("");
		System.out.println("Please enter your choice: ");
	}
	

}
