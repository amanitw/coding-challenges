package com.example.stage.loadbalancer;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HealthCheckService implements Runnable {
    private List<String> backendHosts;
    private List<String> allHost = new ArrayList<>();

    public HealthCheckService(List<String> backendHost) {
        this.backendHosts = backendHost;
        backendHost.stream()
                .forEach(host -> allHost.add(host));
    }

    @Override
    public void run() {
        while (true) {
            for (String host : backendHosts) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(host).openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(60000);
                    int responseCode = httpURLConnection.getResponseCode();

                    if (responseCode != 200) {
                        System.out.println("Removing server "+host);
                        backendHosts.remove(host);
                    }
                } catch (Exception exception) {
                    backendHosts.remove(host);
                    System.out.println(exception.getMessage());
                }
            }

            for (String host:allHost){
                if (!backendHosts.contains(host)){
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(host).openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(60000);
                        int responseCode = httpURLConnection.getResponseCode();

                        if (responseCode == 200) {
                            System.out.println("Adding server "+host);
                            backendHosts.add(host);
                        }
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                }
            }
        }
    }
}
