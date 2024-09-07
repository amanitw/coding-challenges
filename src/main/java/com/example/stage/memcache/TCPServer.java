package com.example.stage.memcache;

import com.example.stage.memcache.service.ClientHandler;
import com.example.stage.memcache.service.ServerService;

public class TCPServer {
    public void start(String[] args) {
        int port = 11211; // default server

        for (String arg : args) {
            if (arg.startsWith("-p")){
                try {
                    port=Integer.parseInt(arg.substring(2));
                }catch (Exception e){
                    System.out.println("Invalid Port Number, using default port 11211");
                }
            }
        }

        ServerService serverService = new ServerService(new ClientHandler());
        serverService.startServer(port);
    }
}
