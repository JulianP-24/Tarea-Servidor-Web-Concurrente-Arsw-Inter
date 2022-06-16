package edu.escuelaing.arsw.app.TareaHttpServerBrowser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.escuelaing.arsw.app.TareaHttpServerBrowser.Reader.FilesReader;

/* 
* Clase de la implementacion del HttpServer
*/
public class httpServerBrowser {

    public static void main(String[] args) throws IOException {
        ExecutorService poolDeHilos = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35001);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35001.");
            System.exit(1);
        }
        boolean running = true;
        while (running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            RequestProcessor requestProcessor = new RequestProcessor(clientSocket);

            poolDeHilos.execute(requestProcessor);

            //new Thread(requestProcessor).start();


        }
        serverSocket.close();
    }
}
