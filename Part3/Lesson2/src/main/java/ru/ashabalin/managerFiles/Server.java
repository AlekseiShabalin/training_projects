package ru.ashabalin;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Aleksei Shabalin.
 */
public class Server {
    //it`s number port of server
    private int serverPort = 3000;
    //
    FileManager fileManager;

	void runServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            Socket socket = serverSocket.accept();

            InputStream socketIn = socket.getInputStream();
            OutputStream socketOut = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketIn);
            DataOutputStream out = new DataOutputStream(socketOut);

            String string = "";
            while(true) {
                string = in.readUTF();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
