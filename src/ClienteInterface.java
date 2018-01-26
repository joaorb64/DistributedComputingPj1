/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Lucas
 */
public interface ClienteInterface extends Remote{
    String getNome() throws RemoteException;
    void receberMensagem(String texto) throws RemoteException;
    void atualizarListaClientes(String lista) throws RemoteException;
}
