package com.example.games.networking;

import com.example.games.lib.utils.Log;

import java.io.*;
import java.net.Socket;

public class Client {

    private static void clientProps() {
        try (Socket socket = new Socket("localhost", 8000)) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("Hello from client!\n");
            bufferedWriter.flush();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Log.info(bufferedReader.readLine());
        } catch (IOException e) {
            Log.error("Error on Client Start");
            throw new RuntimeException(e);
        }
    }

    public static void start() {
        Thread.startVirtualThread(Client::clientProps);
        Log.info("Client connected");
    }
}
