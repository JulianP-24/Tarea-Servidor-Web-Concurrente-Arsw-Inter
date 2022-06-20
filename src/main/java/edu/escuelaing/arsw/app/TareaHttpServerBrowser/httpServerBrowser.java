package edu.escuelaing.arsw.app.TareaHttpServerBrowser;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 
* Clase de la implementacion del HttpServer
*/
public class httpServerBrowser {

    public static void main(String[] args) throws IOException {
        ExecutorService poolDeHilos = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4567.");
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

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;

    }
}
