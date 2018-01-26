/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class ClienteBack extends UnicastRemoteObject implements ClienteInterface, Runnable{
    private static final long serialVersionUID = 1L;
    public ServerInterface server;
    public String nome = null;
    public ClienteFront parent;
    
    public ClienteBack(String nome, ServerInterface server, ClienteFront parent) throws RemoteException{
        this.nome = nome;
        this.server = server;
        this.parent = parent;
        server.registrarCliente(this);
    }

    public void receberMensagem(String texto) throws RemoteException {
        System.out.println(texto);
        parent.jTextArea2.append(texto);
    }
    
    public void enviarMensagem(String texto) throws RemoteException {
        server.enviarMensagem(nome + ": "+texto+"\n");
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        String mensagem;
        while(true){
            mensagem = input.nextLine();
            try{
                server.enviarMensagem(nome + ": "+mensagem);
            } catch(RemoteException e){
                e.printStackTrace();
            }
        }
    }

    public void atualizarListaClientes(String lista) throws RemoteException {
        parent.jTextArea1.setText(lista);
    }

    public String getNome() throws RemoteException {
        return this.nome;
    }
}
