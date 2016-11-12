package ru.ashabalin;

/**
 * @author Aleksei Shabalin.
 */

/**
 * This class join to server
 */
public interface Client {
    //it`s number port of server
	int servPort;
    //it`s IP address
    String interAdress;

    //the method join to server
	void joinToServer();
}
