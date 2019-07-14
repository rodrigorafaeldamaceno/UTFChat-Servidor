/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfchat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 *
 * @author Rodri
 */
public class ChatServer extends UnicastRemoteObject implements ChatServerInt {

    private Vector v = new Vector();

    public ChatServer() throws RemoteException {
    }

    public boolean login(ChatClientInt a) throws RemoteException {
        System.out.println(a.getName() + "  conectando....");
        a.tell("Conectado com sucesso.");
        publish(a.getName() + " está online.");
        v.add(a);
        return true;
    }

    public void publish(String s) throws RemoteException {
        System.out.println(s);
        for (int i = 0; i < v.size(); i++) {
            try {
                ChatClientInt tmp = (ChatClientInt) v.get(i);
                tmp.tell(s);
            } catch (Exception e) {
                //problem with the client not connected.
                //Better to remove it
            }
        }
    }

    public Vector getConnected() throws RemoteException {
        return v;
    }
}
