/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Lucas Eduardo Gomes, Joao Ribeiro Bezerra
 */
public interface ServerInterface extends Remote{
    void registrarCliente(ClienteInterface cliente) throws RemoteException;
    void enviarMensagem(String texto) throws RemoteException;
    void enviarListaClientes() throws RemoteException;
}
