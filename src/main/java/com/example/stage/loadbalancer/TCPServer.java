package com.example.stage.loadbalancer;

public class TCPServer {

    public void startup(){
        LoadBalancer loadBalancer = new LoadBalancer();
        loadBalancer.startLoadBalancer();
    }

}
