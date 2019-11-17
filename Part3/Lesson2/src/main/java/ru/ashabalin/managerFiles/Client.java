package ru.ashabalin;

/**
 * @author Aleksei Shabalin.
 */

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This class join to server
 */
public class Client {
    //it`s number port of server
	private int servPort = 3000;
    //it`s IP address
    private String interAdress = "127.0.0.1";

    //the method join to server
	void joinToServer() {
        try {
            InetAddress inetAddress = InetAddress.getByName(interAdress);
            Socket socket = new Socket(inetAddress, servPort);

            InputStream socketIn = socket.getInputStream();
            OutputStream socketOut = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketIn);
            DataOutputStream out = new DataOutputStream(socketOut);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String string = "";

            while(true) {
                string = reader.readLine();
                out.writeUTF(string);
                out.flush();
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
}
