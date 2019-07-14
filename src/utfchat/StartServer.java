/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfchat;

import java.awt.Color;
import java.rmi.Naming;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodri
 */
public class StartServer {

    public static void main(String[] args) {
        try {

            //Cria os objetos necessário para instânciar o servidor
            JLabel lblMessage = new JLabel("UTFChat");
            JLabel lblIP = new JLabel("IP do servidor: 127.0.0.1");
            Object[] texts = {lblMessage, lblIP};
            JOptionPane.showMessageDialog(null, texts);

            //System.setSecurityManager(new RMISecurityManager());
            java.rmi.registry.LocateRegistry.createRegistry(1099);

            ChatServerInt b = new ChatServer();
            Naming.rebind("rmi://127.0.0.1/myabc", b);
            System.out.println("Servidor online...");
        } catch (Exception e) {
            System.out.println("Falha no servidor! " + e);
        }
    }
}
