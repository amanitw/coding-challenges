package com.example.stage.memcache.service;

import com.example.stage.memcache.cache.Cache;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler<K,V> {
    private static int counter = 1;
    public void handleClient(Socket clientSocket, Cache<K,V> cache ) {
        CLIInterpreter interpreter = new CLIInterpreter(clientSocket,cache);
        Thread thread = new Thread(interpreter);
        thread.start();
    }
}
