package com.example.games.networking;

import com.example.games.lib.utils.Log;

import java.io.*;
import java.net.Socket;

public class Client {
    private Client() {
    }


    public static void start(String host) {
        Thread.startVirtualThread(() -> Client.clientProps(host));
        Log.info("Client connected");
    }

    private static void clientProps(String host) {
        try (Socket socket = new Socket(host, 8000)) {
            var bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            var bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                var message = bufferedReader.readLine();
                if (message != null) {
                    Log.info("Server says: " + message);
                } else {
                    Log.info("Server disconnected");
                    break;
                }
            }
        } catch (IOException e) {
            Log.error("Error on Client Start");
            throw new RuntimeException(e);
        }
    }
}
