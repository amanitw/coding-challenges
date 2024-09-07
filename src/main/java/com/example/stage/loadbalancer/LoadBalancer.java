package com.example.stage.loadbalancer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LoadBalancer {
    private List<String> backendHosts = new CopyOnWriteArrayList<>(Arrays.asList("http://localhost:8081","http://localhost:8082","http://localhost:8083"));
    private ClientHandler clientHandler;
    private static int index=-1;

    public LoadBalancer() {
        this.clientHandler =new ClientHandler();
        startHealthCheck();
    }

    private void startHealthCheck() {
        HealthCheckService healthCheckService = new HealthCheckService(backendHosts);
        Thread thread = new Thread(healthCheckService);
        thread.start();
    }


    public void startLoadBalancer() {
        try {
            System.out.println("Starting load balancer");
            ServerSocket serverSocket = new ServerSocket(80);
            while (true) {
                Socket socket = serverSocket.accept();
                int id = getServer();
                clientHandler.handleRequest(socket, backendHosts.get(id));
            }
        } catch (Exception exception) {
            System.out.println("Error in starting up load balancer");
        }

    }

    public synchronized int getServer(){
        index=(index+1)% backendHosts.size();
        return index;
    }




}
