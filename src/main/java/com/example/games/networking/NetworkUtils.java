package com.example.games.networking;

import com.example.games.lib.utils.Log;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NetworkUtils {
    private static final AtomicInteger opponent = new AtomicInteger(0);
    private static final List<Class<Client>> opponentList = new ArrayList<>();
    private static final BooleanProperty booleanProperty = new SimpleBooleanProperty(true);

    private NetworkUtils() {
    }

    public static boolean getStatusOfOpponent() {
        return opponentList.isEmpty();
    }

    public static BooleanProperty isBooleanProperty() {
        return booleanProperty;
    }

    public static void onOpponentConnect() {
        opponent.incrementAndGet();
        booleanProperty.setValue(opponent.get() != 1);
    }

    public static void onOpponentConnect(Class<Client> connectedOpponent) {
        opponent.incrementAndGet();
        opponentList.add(connectedOpponent);
        booleanProperty.setValue(opponent.get() != 1);
    }

    private static void onOpponentDisconnect() {
        opponent.decrementAndGet();
        opponentList.removeLast();
        booleanProperty.setValue(opponent.get() != 1);
    }


    public static void close(Socket socket, BufferedReader in, PrintWriter out) {
        try {
            if (socket != null) socket.close();
            if (in != null) in.close();
            if (out != null) out.close();
        } catch (IOException e) {
            Log.message("Error on Close");
            throw new RuntimeException(e);
        } finally {
            onOpponentDisconnect();
        }
    }

}
