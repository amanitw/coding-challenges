package com.example.stage.memcache.service;

import com.example.stage.memcache.cache.Cache;
import com.example.stage.memcache.cache.InMemoryCache;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerService<K,V> {
    private ClientHandler clienthandler;
    private Cache<K,V> cache;
    public ServerService(ClientHandler clienthandler) {
        this.clienthandler = clienthandler;
        this.cache = new InMemoryCache<K,V>();
    }

    public void startServer(int port){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port "+port);

            while (true){
                System.out.println("waiting for connection");
                Socket clientSocket = serverSocket.accept();
                clienthandler.handleClient(clientSocket,cache);
            }
        }catch (Exception exception){
            System.out.println("Error starting server");
        }

    }
}
