package com.example.games.networking;

import com.example.games.lib.utils.Log;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private static ServerSocket serverSocket;

    private Server() {
    }

    private static void serverProperties(String port) {
        try {
            serverSocket = new ServerSocket(Integer.parseInt(port));
        } catch (IOException e) {
            Log.error("Server Error on Start");
            throw new RuntimeException(e);
        }
    }

    public static void start(String port) {
        new Thread(() -> Server.serverProperties(port)).start();

        Log.info("Server Started");
    }


}
