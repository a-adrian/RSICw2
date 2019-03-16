package com.company;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyServer {

    public static void main(String[] args) {
        System.setProperty(
                "java.security.policy",
                //Adres do waszego pliku srv.policy
                "C:\\Users\\AAA\\IdeaProjects\\RSI Cw2\\src\\srv.policy"
        );



	if (System.getSecurityManager() == null)
	    System.setSecurityManager(new SecurityManager());

	try {
	    CalcObjImpl implObject = new CalcObjImpl();
	    CalcObjImpl2 implObject2 = new CalcObjImpl2();
        Registry registry = LocateRegistry.createRegistry(20001);
        registry.rebind("metoda",implObject);
        registry.rebind("metoda2",implObject2);
        System.out.println("Server is registered");
	    System.out.println("Press ctr+c to stop");

    } catch (Exception e) {
        System.out.println("Server can't be registered");
        e.printStackTrace();
        return;
    }
    }

}
