package com.alien.java2.lesson6.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class Server {

    private Vector<ClientHandler> clientHandlers;
    private Scanner scanner = new Scanner(System.in);

    public Server(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        clientHandlers = new Vector<ClientHandler>();

        try {
            serverSocket = new ServerSocket(8189);
            System.out.println("сервер запущен");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        broadcastMsg(" *** Server say: " + scanner.nextLine());
                    }
                }
            }).start();

            while (true){
                socket = serverSocket.accept();
                System.out.println("клиент подключился");
                clientHandlers.add(new ClientHandler(this, socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadcastMsg(String msg){
        for (ClientHandler clientHandler : clientHandlers) {
            clientHandler.sendMsg(msg);
        }
    }
}
