package com.example.stage.memcache.service;

import com.example.stage.memcache.cache.Cache;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class CLIInterpreter<K,V> implements Runnable{
    private Socket socket;
    private Cache<K,V> cache;
    public CLIInterpreter(Socket socket, Cache<K,V> cache) {
        this.socket = socket;
        this.cache = cache;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String line;
            while ((line = reader.readLine()) != null){
                List<String> params = Arrays.stream(line.split(" ")).toList();
                if (params.get(0).equals("set")){
                    cache.put((K) params.get(1), (V) params.get(2));
                    writer.write("Stored\r\n");
                    writer.flush();
                } else if (params.get(0).equals("get")) {
                    V value = cache.get((K)params.get(1));
                    if (value == null){
                        writer.write("The key doesn't exist \r\n");
                    }else {
                        writer.write("The value is "+value.toString()+" \r\n");
                    }
                    writer.flush();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
