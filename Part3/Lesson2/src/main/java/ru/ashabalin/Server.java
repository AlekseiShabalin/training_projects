package ru.ashabalin;

/**
 * @author Aleksei Shabalin.
 */
public interface Server {
    //it`s number port of server
    int serverPort;
    //
    FileManager fileManager;

	void runServer();

}
