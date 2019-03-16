package com.company;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient {
    public static void main(String[] args) {
        double wynik;
        CalcObject zObiekt;
        CalcObject2 zObiekt2;
        ResultType wynik2;
        InputType inObj;

        System.setProperty(
                "java.security.policy",
                //Adres do waszego pliku srv.policy
                "C:\\Users\\AAA\\IdeaProjects\\RSI Cw2\\src\\srv.policy"
        );


        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 20001);
            zObiekt = (CalcObject) registry.lookup("metoda");
            zObiekt2 = (CalcObject2) registry.lookup("metoda2");
            inObj = new InputType();
            inObj.x1 = 2.0;
            inObj.x2 = 1.3;
            inObj.operation="sub";
        } catch (RemoteException e) {
            e.printStackTrace();
            return;
        } catch (NotBoundException e) {
            e.printStackTrace();
            return;

        }

        try {
            wynik = zObiekt.calculate(1.1,2.2);
            wynik2 = zObiekt2.calculate(inObj);

        } catch (Exception e) {
            System.out.println("Blad zdalnego wywolania.");
            e.printStackTrace();
            return;
        }
        System.out.println("Wynik = "+wynik);
        System.out.println("Wynik2 = "+wynik2.result +" "+wynik2.result_desc);
        return;
    }
}
