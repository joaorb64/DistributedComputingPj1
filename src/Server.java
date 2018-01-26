/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Server extends UnicastRemoteObject implements ServerInterface{
    private static final long serialVersionUID = 1L;
    private ArrayList<ClienteInterface> listaClientes;
    
    public Server() throws RemoteException{
        listaClientes = new ArrayList<ClienteInterface>();
    }

    public synchronized void registrarCliente(ClienteInterface cliente) throws RemoteException {
        this.listaClientes.add(cliente);
        enviarListaClientes();
        System.out.println(">> Novo cliente: "+cliente.getNome());
    }
    
    public synchronized void enviarMensagem(String texto) throws RemoteException {
        for(int x = 0; x < listaClientes.size(); x++){
            listaClientes.get(x).receberMensagem(texto);
        }
        System.out.println("Mensagem: " + texto);
    }

    public synchronized void enviarListaClientes() throws RemoteException{
        String lista = "";
        
        for(int x = 0; x < listaClientes.size(); x++){
            lista += listaClientes.get(x).getNome() + "\n";
        }
        
        for(int x = 0; x < listaClientes.size(); x++){
            listaClientes.get(x).atualizarListaClientes(lista);
        }
    }
}
