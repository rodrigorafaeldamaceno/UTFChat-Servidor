
package utfchat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Rodri
 */
public interface ChatClientInt extends Remote {

    public void tell(String name) throws RemoteException;

    public String getName() throws RemoteException;
}
