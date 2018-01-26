/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class ServerConnect {
    public static void main(String [] args) throws MalformedURLException, RemoteException{
        Naming.rebind("DistribuidaCHAT", new Server());
    }
}
