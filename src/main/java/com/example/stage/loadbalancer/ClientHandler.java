package com.example.stage.loadbalancer;

import java.net.Socket;
import java.util.List;

public class ClientHandler {
    public void handleRequest(Socket socket,String backendHost){
        Task task = new Task(socket, backendHost);
        Thread thread = new Thread(task);
        thread.start();
    }
}
